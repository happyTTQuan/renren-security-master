package io.renren.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import io.renren.common.utils.R;
import io.renren.common.utils.SnowflakeIdWorker;
import io.renren.common.utils.SystemCache;
import io.renren.modules.sys.entity.NideshopAddressEntity;
import io.renren.modules.sys.entity.NideshopCartEntity;
import io.renren.modules.sys.entity.NideshopOrderEntity;
import io.renren.modules.sys.entity.NideshopOrderExpressEntity;
import io.renren.modules.sys.entity.NideshopOrderGoodsEntity;
import io.renren.modules.sys.service.NideshopAddressService;
import io.renren.modules.sys.service.NideshopCartService;
import io.renren.modules.sys.service.NideshopOrderExpressService;
import io.renren.modules.sys.service.NideshopOrderGoodsService;
import io.renren.modules.sys.service.NideshopOrderService;
import io.renren.param.HandleOption;
import io.renren.param.OrderInfoResp;
import io.renren.param.OrderListResp;
import io.renren.param.OrderParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/order")
@Api(tags="订单管理")
public class OrderController extends BaseController{
@Autowired
private NideshopOrderService nideshopOrderService;
@Autowired
private NideshopAddressService nideshopAddressService;
@Autowired
private NideshopCartService nideshopCartService;
@Autowired
private NideshopOrderGoodsService nideshopOrderGoodsService;
@Autowired
private NideshopOrderExpressService nideshopOrderExpressService;
private static final Gson gson=new Gson();
private static final Map<Integer,String> statusMap=new HashMap<>();
static {
	statusMap.put(0, "订单尚未支付");
	statusMap.put(1, "订单已经支付");
}
@PostMapping("submit")
@ApiOperation(value="提交购物车信息")
public R checked(HttpServletRequest  request,@RequestBody OrderParam cartParam) {
	Integer userid=this.getUserID(request);
	if(userid==null) {
		return R.error(10001, "请先登录");
	}
	Integer addressId=cartParam.getAddressId();
	NideshopAddressEntity address=nideshopAddressService.getById(addressId);
	if(address==null) {
		return R.error(100001, "请选择收货地址");
	}
	List<NideshopCartEntity> list=nideshopCartService.queryCheckedGoods(userid, 1, 1);
	if(list==null||list.isEmpty()) {
		return R.error(100002,"请选择商品");
	}
	log.info("选择的商品信息是：{}",gson.toJson(list));
	Double goodsTotalPrice=0.00;
	for(NideshopCartEntity cart:list) {
		goodsTotalPrice=goodsTotalPrice+1.00*cart.getNumber()*cart.getRetailPrice().doubleValue();
	}
	Integer freightPrice=0;
	double orderTotalPrice=goodsTotalPrice+freightPrice;
	double actualPrice=orderTotalPrice;
	long currentTime=(System.currentTimeMillis()/1000);
	NideshopOrderEntity order=new NideshopOrderEntity();
	SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
	order.setOrderSn(idWorker.nextId()+"");
	order.setUserId(getUserID(request));
	//收获地址信息
	order.setConsignee(address.getName());
	order.setMobile(address.getMobile());
	order.setProvince(address.getProvinceId());
	order.setCity(address.getCityId());
	order.setDistrict(address.getDistrictId());
	order.setAddress(address.getAddress());
	order.setFreightPrice(freightPrice);
	order.setPostscript(cartParam.getPostscript());
	order.setCouponId(0);
	order.setCouponPrice(new BigDecimal("0.00"));
	order.setAddTime(new Long(currentTime).intValue());
	order.setGoodsPrice(new BigDecimal(goodsTotalPrice));
	order.setOrderPrice(new BigDecimal(orderTotalPrice));
	order.setActualPrice(new BigDecimal(actualPrice));
	nideshopOrderService.save(order);
	List<NideshopOrderGoodsEntity> orderGoods=new ArrayList<>();
	NideshopOrderExpressEntity express=new NideshopOrderExpressEntity();
	String province_name=SystemCache.regionMap.get(order.getProvince()).split("---")[0];
	String city_name=SystemCache.regionMap.get(order.getCity()).split("---")[0];
	String district_name=SystemCache.regionMap.get(order.getDistrict()).split("---")[0];
	String full_region=province_name+city_name+district_name;
	express.setRecvAddress(full_region+order.getAddress());
	express.setRecvMobile(address.getMobile());
	express.setRecvUsername(address.getName());
	express.setOrderId(order.getId());
	express.setOrderPrice(order.getActualPrice());
	StringBuffer goodsDetail=new StringBuffer();
	for(NideshopCartEntity cart:list) {
		NideshopOrderGoodsEntity ogent=new NideshopOrderGoodsEntity();
		ogent.setOrderId(order.getId());
		ogent.setGoodsId(cart.getGoodsId());
		ogent.setGoodsSn(cart.getGoodsSn());
		ogent.setProductId(cart.getProductId());
		ogent.setGoodsName(cart.getGoodsName());
		ogent.setListPicUrl(cart.getListPicUrl());
		ogent.setMarketPrice(cart.getMarketPrice());
		ogent.setRetailPrice(cart.getRetailPrice());
		ogent.setNumber(cart.getNumber());
		ogent.setGoodsSpecifitionIds(cart.getGoodsSpecifitionIds());
		ogent.setGoodsSpecifitionNameValue(cart.getGoodsSpecifitionNameValue());
		goodsDetail.append(cart.getGoodsName()+"*"+cart.getNumber()+"<br>");
		orderGoods.add(ogent);
	}
	String gd=goodsDetail.toString().substring(0,goodsDetail.toString().length()-4);
	express.setGoodsDetail(gd);
	if(!gd.equals("VIP会员*1")) {
	nideshopOrderExpressService.save(express);
	}
	nideshopOrderGoodsService.saveBatch(orderGoods);
	nideshopCartService.clearBuyGoods(userid);
	R r=R.ok1();
	r.put("orderInfo", order);
	return R.ok().put("data", r);
}
@GetMapping("detail")
@ApiOperation(value="订单详情")
public R detail(HttpServletRequest request,@RequestParam Integer orderId) {
	NideshopOrderEntity order=nideshopOrderService.getById(orderId);
	if(order==null) {
		return R.error(100003, "订单信息不存在");
	}
	OrderInfoResp resp=new OrderInfoResp();
	BeanUtils.copyProperties(order, resp);
	String province_name=SystemCache.regionMap.get(order.getProvince()).split("---")[0];
	String city_name=SystemCache.regionMap.get(order.getCity()).split("---")[0];
	String district_name=SystemCache.regionMap.get(order.getDistrict()).split("---")[0];
	String full_region=province_name+city_name+district_name;
	resp.setProvince_name(province_name);
	resp.setCity_name(city_name);
	resp.setDistrict_name(district_name);
	resp.setFull_region(full_region);
	resp.setOrder_status_text(statusMap.get(order.getOrderStatus()));
	SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	resp.setAdd_time(sdf.format(new Date(((long)order.getAddTime())*1000)));
	List<NideshopOrderGoodsEntity> orderGoods=nideshopOrderGoodsService.queryByOrderId(orderId);
	NideshopOrderExpressEntity express=nideshopOrderExpressService.queryExpressByOrderId(orderId);
	if(express!=null) {
		resp.setExpressNo(express.getExpressNo());
		resp.setExpressName(express.getExpressName());
	}
	R r=R.ok1();
	r.put("orderInfo", resp);
	r.put("orderGoods", orderGoods);
	return R.ok().put("data", r);
}
@GetMapping("list")
@ApiOperation(value="订单信息")
public R list(HttpServletRequest request) {
	Integer userid=this.getUserID(request);
	if(userid==null) {
		return R.error(10001, "请先登录");
	}
	List<NideshopOrderEntity> ents=nideshopOrderService.queryOrderByUserId(userid);
	List<OrderListResp> rs=new ArrayList<>();
	for(NideshopOrderEntity ent:ents) {
	List<NideshopOrderGoodsEntity> orderGoods=nideshopOrderGoodsService.queryByOrderId(ent.getId());
	OrderListResp resp=new OrderListResp();
	BeanUtils.copyProperties(ent, resp);
	if(ent.getOrderStatus()==1) {
		NideshopOrderExpressEntity express=nideshopOrderExpressService.queryExpressByOrderId(ent.getId());
		if(express!=null) {
		resp.setExpressNo(express.getExpressNo());
		resp.setExpressName(express.getExpressName());
		}
	}
	resp.setGoodsList(orderGoods);
	resp.setGoodsCount(orderGoods.size());
	HandleOption handleOption=new HandleOption();
	handleOption.setPay(ent.getOrderStatus()==1);
	resp.setOrder_status_text(statusMap.get(ent.getOrderStatus()));
	rs.add(resp);
	}
	R r=R.ok1().put("orderList", rs);
	return R.ok().put("data", r);
}
}
