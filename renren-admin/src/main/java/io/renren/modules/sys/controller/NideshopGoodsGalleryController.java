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

import io.renren.modules.sys.entity.NideshopGoodsGalleryEntity;
import io.renren.modules.sys.service.NideshopGoodsGalleryService;
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
@RequestMapping("sys/nideshopgoodsgallery")
public class NideshopGoodsGalleryController {
    @Autowired
    private NideshopGoodsGalleryService nideshopGoodsGalleryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:nideshopgoodsgallery:list")
    public AR list(@RequestParam Map<String, Object> params){
        PageUtils page = nideshopGoodsGalleryService.queryPage(params);

        return AR.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:nideshopgoodsgallery:info")
    public AR info(@PathVariable("id") Integer id){
        NideshopGoodsGalleryEntity nideshopGoodsGallery = nideshopGoodsGalleryService.getById(id);

        return AR.ok().put("nideshopGoodsGallery", nideshopGoodsGallery);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:nideshopgoodsgallery:save")
    public AR save(@RequestBody NideshopGoodsGalleryEntity nideshopGoodsGallery){
        nideshopGoodsGalleryService.save(nideshopGoodsGallery);

        return AR.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:nideshopgoodsgallery:update")
    public AR update(@RequestBody NideshopGoodsGalleryEntity nideshopGoodsGallery){
        ValidatorUtils.validateEntity(nideshopGoodsGallery);
        nideshopGoodsGalleryService.updateById(nideshopGoodsGallery);
        
        return AR.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:nideshopgoodsgallery:delete")
    public AR delete(@RequestBody Integer[] ids){
        nideshopGoodsGalleryService.removeByIds(Arrays.asList(ids));

        return AR.ok();
    }

}
