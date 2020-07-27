package io.renren.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import io.renren.common.utils.R;
import io.renren.common.utils.R;
import io.renren.entity.IndexResp;
import io.renren.modules.sys.entity.NideshopAdEntity;
import io.renren.modules.sys.entity.NideshopAddressEntity;
import io.renren.modules.sys.entity.NideshopGoodsEntity;
import io.renren.modules.sys.service.NideshopAdService;
import io.renren.modules.sys.service.NideshopAddressService;
import io.renren.modules.sys.service.NideshopGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.spring.web.json.Json;

@RestController
@RequestMapping("/index")
@Api(tags="首页")
public class IndexController {
	  @Autowired
	  private NideshopAdService nideshopAdService;
	  @Autowired
	  private NideshopGoodsService nideshopGoodsService;
	  /**
           * 列表
     */	
    @GetMapping("/index")
    @ApiOperation(value="首页信息")
    public R index(){
    	List<NideshopAdEntity> ads=nideshopAdService.queryAd();
    	List<NideshopGoodsEntity> goods=nideshopGoodsService.queryHotGoods();
    	R r=R.ok1().put("banner", ads).put("hotGoodsList", goods);
    	return R.ok().put("data", r);
    }
}
