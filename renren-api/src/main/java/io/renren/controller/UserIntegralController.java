package io.renren.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.NideshopAdEntity;
import io.renren.modules.sys.entity.NideshopUserEntity;
import io.renren.modules.sys.service.NideshopUserIntegralService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/user/")
@Api(tags="用户积分")
public class UserIntegralController extends BaseController{
    @Autowired
	private NideshopUserIntegralService nideshopUserIntegralService;
    /**
     * 绑定用户手机号
     */
    @GetMapping("list")
    @ApiOperation(value="用户积分查询", response=NideshopAdEntity.class)
    public R list(HttpServletRequest request,@RequestParam(required=false) Map<String, Object> params) {
    	Integer userid=this.getUserID(request);
    	if(userid==null) {
    		return R.error(10001, "请先登录");
    	}
    	if(params==null) {
    		params=new HashMap<>();
    	}
    	PageUtils page=nideshopUserIntegralService.queryPage(params,userid);
        return R.ok().put("data", page);
    }
}
