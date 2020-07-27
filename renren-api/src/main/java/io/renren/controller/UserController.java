package io.renren.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.Md5Crypt;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.R;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.NideshopAdEntity;
import io.renren.modules.sys.entity.NideshopUserEntity;
import io.renren.modules.sys.service.NideshopUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user/")
@Api(tags="用户信息")
public class UserController extends BaseController{
	@Autowired
	private NideshopUserService nideshopUserService;
	/**
     * 绑定用户手机号
     */
    @GetMapping("bind")
    @ApiOperation(value="绑定用户手机号", response=NideshopAdEntity.class)
    public R bind(HttpServletRequest request,@RequestParam(required = true) String mobileno) {
    	NideshopUserEntity orguser=nideshopUserService.getById(this.getUserID(request));
		orguser.setMobile(mobileno);
        return R.ok();
    }
}
