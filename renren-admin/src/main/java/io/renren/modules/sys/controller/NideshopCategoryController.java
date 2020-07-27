package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.NideshopCategoryEntity;
import io.renren.modules.sys.service.NideshopCategoryService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.AR;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-07-23 13:44:46
 */
@RestController
@RequestMapping("sys/nideshopcategory")
public class NideshopCategoryController {
    @Autowired
    private NideshopCategoryService nideshopCategoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:nideshopcategory:list")
    public AR list(@RequestParam Map<String, Object> params){
        PageUtils page = nideshopCategoryService.queryPage(params);

        return AR.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:nideshopcategory:info")
    public AR info(@PathVariable("id") Integer id){
        NideshopCategoryEntity nideshopCategory = nideshopCategoryService.getById(id);

        return AR.ok().put("nideshopCategory", nideshopCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:nideshopcategory:save")
    public AR save(@RequestBody NideshopCategoryEntity nideshopCategory){
    	nideshopCategory.setLevel("1");
    	nideshopCategory.setBannerUrl(nideshopCategory.getWapBannerUrl());
    	nideshopCategory.setIconUrl(nideshopCategory.getWapBannerUrl());
    	nideshopCategory.setImgUrl(nideshopCategory.getWapBannerUrl());
        nideshopCategoryService.save(nideshopCategory);

        return AR.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:nideshopcategory:update")
    public AR update(@RequestBody NideshopCategoryEntity nideshopCategory){
        ValidatorUtils.validateEntity(nideshopCategory);
        nideshopCategoryService.updateById(nideshopCategory);
        
        return AR.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:nideshopcategory:delete")
    public AR delete(@RequestBody Integer[] ids){
        nideshopCategoryService.removeByIds(Arrays.asList(ids));

        return AR.ok();
    }

}
