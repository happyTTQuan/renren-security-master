package io.renren.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.R;
import io.renren.common.utils.R;
import io.renren.common.utils.SystemCache;
import io.renren.modules.sys.entity.NideshopAddressEntity;
import io.renren.modules.sys.entity.NideshopRegionEntity;
import io.renren.modules.sys.service.NideshopRegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/region")
@Api(tags="地区列表")
public class RegionController {
  @Autowired
  private NideshopRegionService nideshopRegionService;
  /**
   * 列表
*/	
@GetMapping("/info")
@ApiOperation(value="获取地区信息", response=NideshopRegionEntity.class)
public R info(@RequestParam(required=true) Integer regionId){
	NideshopRegionEntity ret=nideshopRegionService.getById(regionId);
	return R.ok().put("data", ret);
}
@GetMapping("/list")
@ApiOperation(value="获取地址信息", response=NideshopRegionEntity.class)
public R list(@RequestParam(required=true) Integer parentId){
	List<NideshopRegionEntity> ret= nideshopRegionService.queryByParentid(parentId);
	return R.ok().put("data", ret);
}
}
