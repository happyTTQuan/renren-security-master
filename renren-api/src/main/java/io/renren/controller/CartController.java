package io.renren.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import io.renren.param.CartParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import io.renren.common.utils.R;
import io.renren.common.utils.R;
import io.renren.common.utils.SystemCache;
import io.renren.modules.sys.entity.NideshopAddressEntity;
import io.renren.modules.sys.entity.NideshopCartEntity;
import io.renren.modules.sys.entity.NideshopGoodsEntity;
import io.renren.modules.sys.service.NideshopAddressService;
import io.renren.modules.sys.service.NideshopCartService;
import io.renren.modules.sys.service.NideshopGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/cart/")
@Api(tags="购物车")
public class CartController extends BaseController{
    @Autowired
    private NideshopCartService nideshopCartService;
    @Autowired
    private NideshopGoodsService nideshopGoodsService;
    @Autowired
    private NideshopAddressService nideshopAddressService;
    /**
         * 列表
     */	
    @GetMapping("index")
    @ApiOperation(value="获取当前购物车")
    public R index(HttpServletRequest request){
    	return getCart(request);
    }
    public R getCart(HttpServletRequest request) {
    	Integer userid=getUserID(request);
    	boolean isvip=isVip(request);
    	if(userid==null) {
    		return R.error(10001, "请先登录");
    	}
    	log.info("userid:{}",userid);
    	List<NideshopCartEntity> list=nideshopCartService.listcarts(userid);
    	int goodscount=0;
    	double goodsAmount=0.00;
    	int checkedGoodsCount=0;
    	double checkedGoodsAmount=0.00;
    	for(NideshopCartEntity cartItem:list) {
    		goodscount+=cartItem.getNumber();
    		if(isvip) {
    		goodsAmount+=cartItem.getNumber()*cartItem.getRetailPrice().doubleValue();
    		}else {
    			goodsAmount+=cartItem.getNumber()*cartItem.getMarketPrice().doubleValue();
    		}
    		if(cartItem.getChecked()==1) {
    			checkedGoodsCount+=cartItem.getNumber();
    			if(isvip) {
    			checkedGoodsAmount+=cartItem.getNumber()*cartItem.getRetailPrice().doubleValue();
    			}else {
    				checkedGoodsAmount+=cartItem.getNumber()*cartItem.getMarketPrice().doubleValue();
    			}
    		}
    		//cartItem.setListPicUrl(nideshopGoodsService.queryGoodsPicUrl(cartItem.getGoodsId()));
    	}
    	JSONObject jsonobj=new JSONObject();
    	jsonobj.put("goodsCount", goodscount);
    	jsonobj.put("goodsAmount", goodsAmount);
    	jsonobj.put("checkedGoodsCount", checkedGoodsCount);
    	jsonobj.put("checkedGoodsAmount", checkedGoodsAmount);
    	JSONObject data=new JSONObject();
    	data.put("cartList",list);
    	data.put("cartTotal", jsonobj);
    	return R.ok().put("data",data);
    }
    @PostMapping("add")
    @ApiOperation(value="添加商品到购物车")
    public R add(HttpServletRequest request, @RequestBody CartParam cartParam) {
    	Integer userid=this.getUserID(request);
    	if(userid==null) {
    		return R.error(10001, "请先登录");
    	}
    	NideshopGoodsEntity good=nideshopGoodsService.getById(cartParam.getGoodsId());
    	if(good.getIsDelete()==1) {
    		return R.error(1000114, "商品已经下架");
    	}
    	List<NideshopCartEntity> list=nideshopCartService.listMyCarts(userid,cartParam.getGoodsId());
    	if(list==null||list.isEmpty()) {
    		NideshopCartEntity cart=new NideshopCartEntity();
    		cart.setGoodsId(cartParam.getGoodsId());
    		cart.setGoodsName(good.getName());
    		cart.setGoodsSn(good.getGoodsSn());
    		cart.setListPicUrl(good.getListPicUrl());
    		cart.setNumber(cartParam.getNumber());
    		cart.setSessionId(1+"");
    		cart.setUserId(this.getUserID(request));
    		//购物车商品的会员价
    		cart.setRetailPrice(good.getRetailPrice());
    		//购物车商品的市场价
    		cart.setMarketPrice(good.getUnitPrice());
    		cart.setGoodsSpecifitionNameValue(good.getGoodsBrief());
    		cart.setChecked(1);
    		nideshopCartService.save(cart);
    	}else {
    		NideshopCartEntity ent=list.get(0);
    		ent.setNumber(ent.getNumber()+cartParam.getNumber());
    		nideshopCartService.updateById(ent);
    	}
    	return getCart(request);
    }
    @PostMapping("update")
    @ApiOperation(value="修改购物车信息")
    public R update(HttpServletRequest request,@RequestBody CartParam cartParam) {
    	Integer userid=this.getUserID(request);
    	if(userid==null) {
    		return R.error(10001, "请先登录");
    	}
    	NideshopCartEntity cart=nideshopCartService.getById(cartParam.getCartid());
    	NideshopGoodsEntity good=nideshopGoodsService.getById(cartParam.getGoodsId());
    	List<NideshopCartEntity> list=nideshopCartService.listMyCarts(userid,cartParam.getGoodsId());
    	if(list==null||list.isEmpty()) {
    		cart.setGoodsId(cartParam.getGoodsId());
    		cart.setGoodsName(good.getName());
    		cart.setGoodsSn(good.getGoodsSn());
    		cart.setListPicUrl(good.getListPicUrl());
    		cart.setNumber(cartParam.getNumber());
    		cart.setSessionId(1+"");
    		cart.setUserId(this.getUserID(request));
    		cart.setRetailPrice(good.getRetailPrice());
    		cart.setMarketPrice(good.getUnitPrice());
    		cart.setGoodsSpecifitionNameValue(good.getGoodsBrief());
    		cart.setChecked(1);
    		nideshopCartService.updateById(cart);
    	}else {
    	NideshopCartEntity newcart=list.get(0);
    	if(newcart.getId()==cart.getId()) {
    		cart.setNumber(cartParam.getNumber());
    		nideshopCartService.updateById(cart);
    		return getCart(request);
    	}
    	}
    	return getCart(request);
    }
    @PostMapping("checked")
    @ApiOperation(value="修改购物车信息")
    public R checked(HttpServletRequest request,@RequestBody CartParam cartParam) {
    	//TODO 此接口 选择或取消选择商品
    	String goodsArr[]=cartParam.getGoodsIdList().split(",");
    	List<Integer> goodsList=new ArrayList<>();
    	for(String id:goodsArr) {
    		goodsList.add(Integer.parseInt(id));
    	}
    	nideshopCartService.updateMyCarts(goodsList, getUserID(request), cartParam.getIschecked());
    	return getCart(request);
    }
    @PostMapping("delete")
    @ApiOperation(value="修改购物车信息", response=NideshopCartEntity.class)
    public R delete(HttpServletRequest request,@RequestBody CartParam cartParam) {
    	String goodsArr[]=cartParam.getGoodsIdList().split(",");
    	List<Integer> goodsList=new ArrayList<>();
    	for(String id:goodsArr) {
    		goodsList.add(Integer.parseInt(id));
    	}
    	nideshopCartService.deleteMyCarts(goodsList, this.getUserID(request));
    	return getCart(request);
    }
    @GetMapping("goodscount")
    @ApiOperation(value="获取总件数")
    public R goodscount(HttpServletRequest request) {
    	R r=getCart(request);
    	JSONObject data=(JSONObject)r.get("data");
    	JSONObject json=data.getJSONObject("cartTotal");
    	JSONObject goodsCount=new JSONObject();
    	goodsCount.put("goodsCount", json.get("goodsCount"));
    	JSONObject cartTotalJSON=new JSONObject();
    	cartTotalJSON.put("cartTotal", json);
    	return R.ok().put("data", cartTotalJSON);
    }
    @GetMapping("checkout")
    @ApiOperation(value="下单")
    public R checkout(HttpServletRequest request,@RequestParam(required=false) Integer addressId,@RequestParam
			(required=false) Integer couponId) {
    	Integer userid=this.getUserID(request);
    	if(userid==null) {
    		return R.error(10001, "请先登录");
    	}
    	NideshopAddressEntity addr=null;
    	log.info("用户ID是：{}",this.getUserID(request));
    	if(addressId==null||addressId==0) {
    		NideshopAddressEntity address=nideshopAddressService.getDefaultAddress(userid);
    		if(address==null) {
    			return R.error(1000153, "尚未添加收获地址，请添加");
    		}else {
    			addr=address;
    		}
    	}else {
    		addr=nideshopAddressService.getById(addressId);
    	}
    	JSONObject checkedAddress=(JSONObject)JSON.toJSON(addr);
    	checkedAddress.put("province_name", SystemCache.regionMap.get(addr.getProvinceId()).split("---")[0]);
    	checkedAddress.put("city_name", SystemCache.regionMap.get(addr.getCityId()).split("---")[0]);
    	checkedAddress.put("district_name", SystemCache.regionMap.get(addr.getDistrictId()).split("---")[0]);
    	String addres=SystemCache.regionMap.get(addr.getProvinceId()).split("---")[0]+
    			SystemCache.regionMap.get(addr.getCityId()).split("---")[0]+
    			SystemCache.regionMap.get(addr.getDistrictId()).split("---")[0];
        checkedAddress.put("full_region", addres);
        R r=this.getCart(request);
    	JSONObject data=((JSONObject)r.get("data"));
    	List<NideshopCartEntity> list=(List<NideshopCartEntity>)data.get("cartList");
    	List<NideshopCartEntity> checkedlist=new ArrayList<>();
    	for(NideshopCartEntity ent:list) {
    		checkedlist.add(ent);
    	}
    	JSONObject cartTotal=(JSONObject)data.get("cartTotal");
    	double goodsTotalPrice =cartTotal.getDoubleValue("checkedGoodsAmount"); // 商品总价
    	double orderTotalPrice = cartTotal.getDoubleValue("checkedGoodsAmount"); // 订单的总价
    	double actualTotalPrice=orderTotalPrice;
    	JSONObject retJSON=new JSONObject();
    	retJSON.put("checkedAddress", checkedAddress);
    	retJSON.put("freightPrice", 0.0);
    	retJSON.put("checkedGoodsList", checkedlist);
    	retJSON.put("goodsTotalPrice", goodsTotalPrice);
    	retJSON.put("orderTotalPrice", orderTotalPrice);
    	retJSON.put("actualPrice", actualTotalPrice);
    	return R.ok().put("data", retJSON);
    }
    
}
