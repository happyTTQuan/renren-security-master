package io.renren.controller;

import io.renren.common.utils.SystemCache;
import io.renren.modules.sys.entity.NideshopUserEntity;
import io.renren.modules.sys.service.NideshopUserService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
@Slf4j
public class BaseController {
	@Autowired
	private NideshopUserService nideshopUserService;
	private static final Gson gson=new Gson();
     public void setUserLogin(HttpSession session,NideshopUserEntity user){
      session.setAttribute("loginUser",user);
    }
    public Integer getUserID(HttpServletRequest request) {
        String token=request.getHeader("X-Nideshop-Token");
        if(SystemCache.userMap.containsKey(token)) {
        	return SystemCache.userMap.get(token).getId();
        }else {
        NideshopUserEntity ent=nideshopUserService.queryByToken(token);
        if(ent!=null) {
        	SystemCache.userMap.put(token, ent);
        	return ent.getId();
        }else {
        	return null;
        }
        }
    }
    public boolean isVip(HttpServletRequest request) {
        String token=request.getHeader("X-Nideshop-Token");
        if(SystemCache.userMap.containsKey(token)) {
        	NideshopUserEntity user= SystemCache.userMap.get(token);
        	if(user.getVip()==1&&user.getVipExpiretime().getTime()>System.currentTimeMillis()) {
        		return true;
        	}else {
        		return false;
        	}
        }else {
        NideshopUserEntity ent=nideshopUserService.queryByToken(token);
        if(ent!=null) {
        	SystemCache.userMap.put(token, ent);
        	if(ent.getVip()==1&&ent.getVipExpiretime().getTime()>System.currentTimeMillis()) {
        		return true;
        	}else {
        		return false;
        	}
        }else {
        	return false;
        }
        }
    }
}
