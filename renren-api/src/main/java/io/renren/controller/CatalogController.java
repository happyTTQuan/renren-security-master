package io.renren.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import io.renren.common.utils.R;
import io.renren.common.utils.R;
import io.renren.entity.CategoryResp;
import io.renren.modules.sys.entity.NideshopCategoryEntity;
import io.renren.modules.sys.service.NideshopCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/catalog/")
@Api(tags = "分类")
public class CatalogController {
	@Autowired
	private NideshopCategoryService nideshopCategoryService;

	@GetMapping("/index")
	@ApiOperation(value = "分类首页")
	public R index(@RequestParam(required = false) Integer id) {
		List<NideshopCategoryEntity> list = nideshopCategoryService.list();
		NideshopCategoryEntity current = null;
		if (id == null) {
			current = list.get(0);
		} else {
			current = nideshopCategoryService.getById(id);
		}
		CategoryResp resp = new CategoryResp();
		BeanUtils.copyProperties(current, resp);
		resp.setSubCategoryList(nideshopCategoryService.findsubCata(current.getId()));
		R r = R.ok1().put("categoryList", list).put("currentCategory", resp);
		return R.ok().put("data", r);
	}
	
	@GetMapping("/current")
	@ApiOperation(value = "当前分类")
	public R current(@RequestParam(required = true) Integer id) {
		NideshopCategoryEntity current = null;
		current = nideshopCategoryService.getById(id);
		CategoryResp resp = new CategoryResp();
		BeanUtils.copyProperties(current, resp);
		resp.setSubCategoryList(nideshopCategoryService.findsubCata(current.getId()));
		R r = R.ok1().put("currentCategory", resp);
		return R.ok().put("data", r);
	}

}
