package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopAdPositionDao;
import io.renren.modules.sys.entity.NideshopAdPositionEntity;
import io.renren.modules.sys.service.NideshopAdPositionService;


@Service("nideshopAdPositionService")
public class NideshopAdPositionServiceImpl extends ServiceImpl<NideshopAdPositionDao, NideshopAdPositionEntity> implements NideshopAdPositionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopAdPositionEntity> page = this.page(
                new Query<NideshopAdPositionEntity>().getPage(params),
                new QueryWrapper<NideshopAdPositionEntity>()
        );

        return new PageUtils(page);
    }

}
