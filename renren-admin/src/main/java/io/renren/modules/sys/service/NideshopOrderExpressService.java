package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.NideshopOrderExpressEntity;

import java.util.Map;

/**
 * 快递信息表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-07-26 17:58:36
 */
public interface NideshopOrderExpressService extends IService<NideshopOrderExpressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

