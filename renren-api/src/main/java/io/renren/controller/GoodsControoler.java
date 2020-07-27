package io.renren.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.NideshopAdEntity;
import io.renren.modules.sys.entity.NideshopCategoryEntity;
import io.renren.modules.sys.entity.NideshopGoodsEntity;
import io.renren.modules.sys.entity.NideshopGoodsGalleryEntity;
import io.renren.modules.sys.service.NideshopCategoryService;
import io.renren.modules.sys.service.NideshopCollectService;
import io.renren.modules.sys.service.NideshopGoodsGalleryService;
import io.renren.modules.sys.service.NideshopGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/goods/")
@Api(tags = "商品管理")
public class GoodsControoler {
  @Autowired
  private NideshopGoodsService nideshopGoodsService;
  @Autowired
  private NideshopGoodsGalleryService nideshopGoodsGalleryService;
  @Autowired
  private NideshopCategoryService nideshopCategoryService;
  @GetMapping("/index")
  @ApiOperation(value="商品首页")
  public R index(@RequestParam(required=false) Map<String, Object> params){
  	PageUtils goods=nideshopGoodsService.queryPage(params);
  	return R.ok().put("data", goods);
  }
  @GetMapping("/sku")
  @ApiOperation(value="根据商品ID获取商品")
  public R sku(@RequestParam(required=true) String  id){
  	NideshopGoodsEntity good=nideshopGoodsService.getById(id);
  	R r=R.ok1().put("specificationList", good);
  	return R.ok().put("data", r);
  }
  @GetMapping("/detail")
  @ApiOperation(value="根据商品ID获取商品详情")
  public R detail(@RequestParam(required=true) Integer  id){
  	NideshopGoodsEntity info=nideshopGoodsService.getById(id);
  	List<NideshopGoodsGalleryEntity> gallery=nideshopGoodsGalleryService.findByGoodsId(id);
  	R r=R.ok1().put("info", info).put("gallery", gallery);
  	return R.ok().put("data", r);
  }
  @GetMapping("/category")
  @ApiOperation(value="根据分类获取商品")
  public R category(@RequestParam(required=true) Integer  id){
  	NideshopCategoryEntity current=nideshopCategoryService.getById(id);
  	NideshopCategoryEntity parent=nideshopCategoryService.getById(current.getParentId());
  	List<NideshopCategoryEntity> brother=nideshopCategoryService.findsubCata(current.getParentId());
  	R r=R.ok1().put("currentCategory", current).put("parentCategory", parent).put("brotherCategory", brother);
  	return R.ok().put("data", r);
  }
  @GetMapping("/list")
  @ApiOperation(value="根据分类获取商品")
  public R list(@RequestParam(required=false) Map<String, Object> params,@RequestParam(required=true) Integer categoryId){
	  List<NideshopCategoryEntity> children=nideshopCategoryService.findsubCata(categoryId);
	  if(children==null||children.isEmpty()) {
	  PageUtils goods=nideshopGoodsService.listByCataLog(params,categoryId);
	  R r=R.ok1();
	  r.put("goodsList", goods.getList());
	  return R.ok().put("data", r);
	  }else {
		  List<Integer> catalogs=new ArrayList<>();
		  for(NideshopCategoryEntity ent:children) {
			  catalogs.add(ent.getId());
		  }
		  catalogs.add(categoryId);
		  PageUtils goods=nideshopGoodsService.queryPageByCataLogs(params,catalogs);
		  R r=R.ok1();
		  r.put("goodsList", goods.getList());
		  return R.ok().put("data", r);
	  }
	  
  }
  @GetMapping("/count")
  @ApiOperation(value="获取商品总数")
  public R count(){
	    int count=nideshopGoodsService.count();
	    R r=R.ok1();
	    r.put("goodsCount", count);
	    //返回商品数量
	    return R.ok().put("data", r);
  }
  
}
