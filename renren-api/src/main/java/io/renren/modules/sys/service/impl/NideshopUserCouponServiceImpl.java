package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopUserCouponDao;
import io.renren.modules.sys.entity.NideshopUserCouponEntity;
import io.renren.modules.sys.service.NideshopUserCouponService;


@Service("nideshopUserCouponService")
public class NideshopUserCouponServiceImpl extends ServiceImpl<NideshopUserCouponDao, NideshopUserCouponEntity> implements NideshopUserCouponService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopUserCouponEntity> page = this.page(
                new Query<NideshopUserCouponEntity>().getPage(params),
                new QueryWrapper<NideshopUserCouponEntity>()
        );

        return new PageUtils(page);
    }

}
