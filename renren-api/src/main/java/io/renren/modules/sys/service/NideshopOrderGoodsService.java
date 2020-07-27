package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.NideshopOrderGoodsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-29 17:41:59
 */
public interface NideshopOrderGoodsService extends IService<NideshopOrderGoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<NideshopOrderGoodsEntity> queryByOrderId(Integer orderId);
}

