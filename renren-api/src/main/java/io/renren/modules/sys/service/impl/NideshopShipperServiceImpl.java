package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopShipperDao;
import io.renren.modules.sys.entity.NideshopShipperEntity;
import io.renren.modules.sys.service.NideshopShipperService;


@Service("nideshopShipperService")
public class NideshopShipperServiceImpl extends ServiceImpl<NideshopShipperDao, NideshopShipperEntity> implements NideshopShipperService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopShipperEntity> page = this.page(
                new Query<NideshopShipperEntity>().getPage(params),
                new QueryWrapper<NideshopShipperEntity>()
        );

        return new PageUtils(page);
    }

}
