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

import io.renren.modules.sys.entity.NideshopOrderExpressEntity;
import io.renren.modules.sys.service.NideshopOrderExpressService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import io.renren.common.utils.AR;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 快递信息表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-07-26 17:58:36
 */
@Slf4j
@RestController
@RequestMapping("sys/nideshoporderexpress")
public class NideshopOrderExpressController {
    @Autowired
    private NideshopOrderExpressService nideshopOrderExpressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:nideshoporderexpress:list")
    public AR list(@RequestParam Map<String, Object> params){
        PageUtils page = nideshopOrderExpressService.queryPage(params);

        return AR.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:nideshoporderexpress:info")
    public AR info(@PathVariable("id") Long id){
        NideshopOrderExpressEntity nideshopOrderExpress = nideshopOrderExpressService.getById(id);

        return AR.ok().put("nideshopOrderExpress", nideshopOrderExpress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:nideshoporderexpress:save")
    public AR save(@RequestBody NideshopOrderExpressEntity nideshopOrderExpress){
        nideshopOrderExpressService.save(nideshopOrderExpress);

        return AR.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:nideshoporderexpress:update")
    public AR update(@RequestBody NideshopOrderExpressEntity nideshopOrderExpress){
        ValidatorUtils.validateEntity(nideshopOrderExpress);
        
        nideshopOrderExpressService.updateById(nideshopOrderExpress);
        
        return AR.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:nideshoporderexpress:delete")
    public AR delete(@RequestBody Long[] ids){
        nideshopOrderExpressService.removeByIds(Arrays.asList(ids));

        return AR.ok();
    }

}
