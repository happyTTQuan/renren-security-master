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

import io.renren.modules.sys.entity.NideshopGoodsEntity;
import io.renren.modules.sys.service.NideshopGoodsService;
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
@RequestMapping("sys/nideshopgoods")
public class NideshopGoodsController {
    @Autowired
    private NideshopGoodsService nideshopGoodsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:nideshopgoods:list")
    public AR list(@RequestParam Map<String, Object> params){
        PageUtils page = nideshopGoodsService.queryPage(params);

        return AR.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:nideshopgoods:info")
    public AR info(@PathVariable("id") Integer id){
        NideshopGoodsEntity nideshopGoods = nideshopGoodsService.getById(id);

        return AR.ok().put("nideshopGoods", nideshopGoods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:nideshopgoods:save")
    public AR save(@RequestBody NideshopGoodsEntity nideshopGoods){
        nideshopGoodsService.save(nideshopGoods);

        return AR.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:nideshopgoods:update")
    public AR update(@RequestBody NideshopGoodsEntity nideshopGoods){
        ValidatorUtils.validateEntity(nideshopGoods);
        nideshopGoodsService.updateById(nideshopGoods);
        
        return AR.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:nideshopgoods:delete")
    public AR delete(@RequestBody Integer[] ids){
        nideshopGoodsService.removeByIds(Arrays.asList(ids));

        return AR.ok();
    }

}
