package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopCouponDao;
import io.renren.modules.sys.entity.NideshopCouponEntity;
import io.renren.modules.sys.service.NideshopCouponService;


@Service("nideshopCouponService")
public class NideshopCouponServiceImpl extends ServiceImpl<NideshopCouponDao, NideshopCouponEntity> implements NideshopCouponService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopCouponEntity> page = this.page(
                new Query<NideshopCouponEntity>().getPage(params),
                new QueryWrapper<NideshopCouponEntity>()
        );

        return new PageUtils(page);
    }

}
