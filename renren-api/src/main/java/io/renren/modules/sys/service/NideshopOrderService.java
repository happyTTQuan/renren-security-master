package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.NideshopOrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-29 17:58:46
 */
public interface NideshopOrderService extends IService<NideshopOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<NideshopOrderEntity> queryOrderByUserId(Integer userid);
    void updateOrderStatus(Integer orderId);
}

