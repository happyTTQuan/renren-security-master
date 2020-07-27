package io.renren.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.qq.weixin.mp.aes.SHA1;
import com.qq.weixin.mp.aes.WeChatUtil;
import io.renren.Utils;
import io.renren.common.utils.R;
import io.renren.common.utils.SnowflakeIdWorker;
import io.renren.config.WechatAppConfig;
import io.renren.modules.sys.entity.NideshopAdEntity;
import io.renren.modules.sys.entity.NideshopUserEntity;
import io.renren.modules.sys.service.NideshopUserService;
import io.renren.param.LoginParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import weixin.popular.api.WxaAPI;
import weixin.popular.bean.wxa.SessionDataResult;
import weixin.popular.bean.wxa.WxaUserInfoResult;

import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/auth/")
@Api(tags="微信授权")
public class AuthController extends BaseController{
    @Autowired
    private NideshopUserService nideshopUserService;
	@Autowired
	private WechatAppConfig wechatAppConfig;
    private static final Gson gson=new Gson();
	/**
       * 列表
     */
    @PostMapping("loginByWeixin")
    @ApiOperation(value="微信登录", response=NideshopAdEntity.class)
    public R loginByWeixin(@RequestBody LoginParam loginParam, HttpSession  session){
    	log.info("appid:{}  appsecret:{},userinfo:{},code:{}",wechatAppConfig.getAppid(),wechatAppConfig.getAppsecret(),gson.toJson(loginParam.getUserInfo()),loginParam.getCode());
		SessionDataResult result = WxaAPI.getSessionDataResult(loginParam.getCode(), wechatAppConfig.getAppid(),
				wechatAppConfig.getAppsecret());
		if(result.getOpenid()==null) {
        	return R.error(100001, "获取用户数据失败");
        }
        String sha1=SHA1.verifyUserInfo(loginParam.getUserInfo().getRawData(), result.getSession_key());
        if(!loginParam.getUserInfo().getSignature().equals(sha1)) {
        	//TODO 此处先跳过
			log.error("signature 校验不一致:"+loginParam.getUserInfo().getSignature()+"!="+sha1);
        	return R.error(100002, "signature 校验不一致");
        }
        String str=WeChatUtil.decryptData(loginParam.getUserInfo().getEncryptedData(), result.getSession_key(), loginParam.getUserInfo().getIv());
        JSONObject json=JSON.parseObject(str);
        log.info("userwx："+str);
        NideshopUserEntity user=nideshopUserService.queryByOpenid(json.getString("openId"));
//        int userid=0;
        NideshopUserEntity resultUserInfo;
		String clientIp = Utils.getClientIp();
		SnowflakeIdWorker sfw=new SnowflakeIdWorker(1, 1);
		String token =sfw.nextId()+"";
		log.info("token:{}",token);
		if(user==null) {
        	NideshopUserEntity entity=new NideshopUserEntity();
        	entity.setUsername("微信用户--游客"+new Random().nextInt(1000000));
        	entity.setGender(json.getInteger("gender"));
        	entity.setAvatar(json.getString("avatarUrl"));
        	entity.setNickname(json.getString("nickName"));
        	entity.setWeixinOpenid(json.getString("openId"));
        	entity.setRegisterIp(clientIp);
        	entity.setRegisterTime((int)(System.currentTimeMillis()/1000));
        	entity.setLastLoginIp(token);
        	entity.setLastLoginTime((int)(System.currentTimeMillis()/1000));
        	nideshopUserService.save(entity);
			resultUserInfo = entity;
        }else {
//        	userid=user.getId();
        	user.setLastLoginIp(token);
        	user.setLastLoginTime((int)(System.currentTimeMillis()/1000));
        	nideshopUserService.updateById(user);
        	resultUserInfo=user;
        }
		if(resultUserInfo.getVip()==1&&resultUserInfo.getVipExpiretime().getTime()>System.currentTimeMillis()) {
			resultUserInfo.setVip(1);
		}else {
			resultUserInfo.setVip(0);
		}
		JSONObject data = new JSONObject();
		session.setAttribute(token,user);
		setUserLogin(session,user);
		data.put("token",token);
		data.put("userInfo",resultUserInfo);

        return R.ok().put("data", data);
    }
}
