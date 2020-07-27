package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.NideshopSpecificationEntity;

import java.util.Map;

/**
 * 规格表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-29 17:41:59
 */
public interface NideshopSpecificationService extends IService<NideshopSpecificationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

