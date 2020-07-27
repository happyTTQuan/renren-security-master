package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.NideshopGoodsSpecificationEntity;

import java.util.Map;

/**
 * 商品对应规格表值表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-29 17:41:59
 */
public interface NideshopGoodsSpecificationService extends IService<NideshopGoodsSpecificationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

