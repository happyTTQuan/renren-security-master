package io.renren.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.qq.weixin.mp.aes.WeChatUtil;

import io.renren.common.utils.R;
import io.renren.common.utils.SystemCache;
import io.renren.config.WechatAppConfig;
import io.renren.modules.sys.entity.NideshopOrderEntity;
import io.renren.modules.sys.entity.NideshopOrderGoodsEntity;
import io.renren.modules.sys.entity.NideshopUserEntity;
import io.renren.modules.sys.service.NideshopOrderGoodsService;
import io.renren.modules.sys.service.NideshopOrderService;
import io.renren.modules.sys.service.NideshopUserService;
import io.renren.param.OrderParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import weixin.popular.api.PayMchAPI;
import weixin.popular.bean.paymch.Receiver;
import weixin.popular.bean.paymch.SecapiPayProfitsharing;
import weixin.popular.bean.paymch.SecapiPayProfitsharingResult;
import weixin.popular.bean.paymch.Unifiedorder;
import weixin.popular.bean.paymch.UnifiedorderResult;
import weixin.popular.util.PayUtil;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;

@Slf4j
@RestController
@RequestMapping("/pay")
@Api(tags="支付管理")
public class PayController extends BaseController{
	@Autowired
	private NideshopOrderService nideshopOrderService;
	@Autowired
	private NideshopUserService nideshopUserService;
	@Autowired
	private WechatAppConfig wechatAppConfig;
	@Autowired
	private NideshopOrderGoodsService nideshopOrderGoodsService;
	private static final Gson gson=new Gson();
	public static String getIPAddress(HttpServletRequest request) {
	    String ip = null;

	    //X-Forwarded-For：Squid 服务代理
	    String ipAddresses = request.getHeader("X-Forwarded-For");
	if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //Proxy-Client-IP：apache 服务代理
	        ipAddresses = request.getHeader("Proxy-Client-IP");
	    }
	if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //WL-Proxy-Client-IP：weblogic 服务代理
	        ipAddresses = request.getHeader("WL-Proxy-Client-IP");
	    }
	if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //HTTP_CLIENT_IP：有些代理服务器
	        ipAddresses = request.getHeader("HTTP_CLIENT_IP");
	    }
	if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //X-Real-IP：nginx服务代理
	        ipAddresses = request.getHeader("X-Real-IP");
	    }

	    //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
	    if (ipAddresses != null && ipAddresses.length() != 0) {
	        ip = ipAddresses.split(",")[0];
	    }

	    //还是不能获取到，最后再通过request.getRemoteAddr();获取
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
	@GetMapping("prepay")
	@ApiOperation(value="修改购物车信息")
	public R prepay(HttpServletRequest request,@RequestParam Integer orderId) {
		String clientIp=getIPAddress(request);
		log.info("用户客户端IP地址是：{}",clientIp);
		NideshopOrderEntity order=nideshopOrderService.getById(orderId);
		List<NideshopOrderGoodsEntity> orderGoods=nideshopOrderGoodsService.queryByOrderId(orderId);
		String body="";
		for(NideshopOrderGoodsEntity ent:orderGoods) {
			body=body+ent.getGoodsName()+",";
		}
		if(order.getPayStatus()!=0) {
			return R.error(1010001, "订单已经支付");
		}
		Integer userid=this.getUserID(request);
		NideshopUserEntity user=nideshopUserService.getById(userid);
		if(user.getWeixinOpenid()==null) {
			return R.error(1010002, "OPENID为空，请先微信登陆");
		}
		Unifiedorder unifiedorder=new Unifiedorder();
		unifiedorder.setAppid(wechatAppConfig.getAppid());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
		String datestr=sdf.format(new Date());
		unifiedorder.setAttach(datestr+orderId+"");
		unifiedorder.setBody(body.substring(0, body.length()-1));
		unifiedorder.setMch_id(wechatAppConfig.getMch_id());
		unifiedorder.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
		unifiedorder.setNotify_url(wechatAppConfig.getNotify_url());
		unifiedorder.setOut_trade_no(datestr+orderId+"");
		unifiedorder.setOpenid(user.getWeixinOpenid());
		//用户客户端IP
		unifiedorder.setSpbill_create_ip(clientIp);
		unifiedorder.setTotal_fee(((int)(order.getActualPrice().doubleValue()*100))+"");
		unifiedorder.setTrade_type("JSAPI");
		//是否分账
		//unifiedorder.setProfit_sharing("Y");
		String mch_key=wechatAppConfig.getMch_key();
		UnifiedorderResult result=PayMchAPI.payUnifiedorder(unifiedorder, mch_key);
		log.info("微信支付返回信息：{}",gson.toJson(result));
		Map<String,String> map=new HashMap<String, String>();
		map.put("timeStamp", (System.currentTimeMillis()/1000)+"");
		map.put("appId",wechatAppConfig.getAppid());
		map.put("nonceStr", UUID.randomUUID().toString().replace("-", ""));
		map.put("package", "prepay_id="+result.getPrepay_id());
		map.put("signType", "MD5");
		String sign = SignatureUtil.generateSign(map,"MD5",mch_key);
		map.put("paySign", sign);
		return R.ok().put("data", map);
	}
	@PostMapping("notify")
	@ApiOperation(value="微信回调")
	public void notifyApp(HttpServletRequest request, HttpServletResponse response) {
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
        	BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			while ((line = br.readLine()) != null) {
			    sb.append(line);
			}
			br.close();
			//sb为微信返回的xml
			String notifyXml = sb.toString();
			log.info("微信回调的数据是：{}",notifyXml);
			Map<String, String> map=XMLConverUtil.convertToMap(notifyXml);
			log.info("转化为MAP是：{}",map);
			String return_code = (String) map.get("return_code");
			log.info("return_code:{}",return_code);
			String ret="";
			if(return_code.equals("SUCCESS")) {
				String out_trade_no=map.get("out_trade_no");
				//获取微信支付的事务ID
				String transaction_id=map.get("transaction_id");
				String order_id=out_trade_no.substring(12,out_trade_no.length());
				NideshopOrderEntity orderEntity=nideshopOrderService.getById(order_id);
				nideshopOrderService.updateOrderStatus(Integer.parseInt(order_id));
				List<NideshopOrderGoodsEntity> goodsEntities=nideshopOrderGoodsService.queryByOrderId(Integer.parseInt(order_id));
				boolean isvip=false;
				for(NideshopOrderGoodsEntity good:goodsEntities) {
					if(good.getGoodsId()==102) {
						isvip=true;
					}
				}
				if(isvip) {
					for(Map.Entry<String, NideshopUserEntity> me:SystemCache.userMap.entrySet()) {
						NideshopUserEntity u=me.getValue();
						if(u.getId()==orderEntity.getUserId()) {
							SystemCache.userMap.remove(me.getKey());
						}
					}
					nideshopUserService.setUserVip(orderEntity.getUserId());
				}
				ret="<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
			}else {	
				ret="<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[支付失败]]></return_msg></xml>";
			}
			log.info("返回给小程序的数据是：{}"+ret);
			BufferedOutputStream out = new BufferedOutputStream(
			        response.getOutputStream());
			out.write(ret.getBytes());
			out.flush();
			out.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//回调返回数据中获取transaction_id..{appid=wx57af29bdae81b789, attach=20200727152827, bank_type=OTHERS, cash_fee=1, fee_type=CNY, is_subscribe=N, mch_id=1600582956, nonce_str=21da10b5a82041a8a9d1629321ee638a, openid=ot-Yw5ZUaOfav6Sa8zUFeB3th2oA, out_trade_no=20200727152827, result_code=SUCCESS, return_code=SUCCESS, sign=C8E6184AAB89131ED9496A624B3F4ACC, time_end=20200727152841, total_fee=1, trade_type=JSAPI, transaction_id=4200000707202007272141305771}
	private void profitsharding(String out_order_no,String transaction_id,String key,BigDecimal subOrderPrice,String openid) {
		SecapiPayProfitsharing secapiPayProfitsharing=new SecapiPayProfitsharing();
		secapiPayProfitsharing.setAppid(wechatAppConfig.getAppid());
		secapiPayProfitsharing.setMch_id(wechatAppConfig.getMch_id());
		secapiPayProfitsharing.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
		secapiPayProfitsharing.setOut_order_no(out_order_no);
		secapiPayProfitsharing.setTransaction_id(transaction_id);
		List<Receiver> recvs=new ArrayList<Receiver>();
		Receiver recv=new Receiver();
		recv.setType("PERSONAL_OPENID");
		recv.setAmount((int)(subOrderPrice.doubleValue()*100));
		recv.setAccount(openid);
		recv.setDescription("推荐奖励");
		recvs.add(recv);
		secapiPayProfitsharing.setReceivers(recvs);
		log.info("请求分账的数据：{},商户KEY信息是：{}",gson.toJson(secapiPayProfitsharing),key);
		//调用接口分账
		SecapiPayProfitsharingResult result=PayMchAPI.secapiPayProfitsharing(secapiPayProfitsharing, key);
		if(result.getResult_code().equals("SUCCESS")) {
			log.info("分账成功");
		}
	}
}
