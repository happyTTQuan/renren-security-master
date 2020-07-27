package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.NideshopUserIntegralEntity;

import java.util.Map;

/**
 * 用户积分表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-07-04 19:31:22
 */
public interface NideshopUserIntegralService extends IService<NideshopUserIntegralEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPage(Map<String, Object> params,Integer userid);
}

