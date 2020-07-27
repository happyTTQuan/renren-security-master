package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.NideshopAttributeEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-29 17:42:05
 */
public interface NideshopAttributeService extends IService<NideshopAttributeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

