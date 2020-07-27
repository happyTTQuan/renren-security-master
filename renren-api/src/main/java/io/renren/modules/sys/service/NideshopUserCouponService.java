package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.NideshopUserCouponEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-29 17:41:52
 */
public interface NideshopUserCouponService extends IService<NideshopUserCouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

