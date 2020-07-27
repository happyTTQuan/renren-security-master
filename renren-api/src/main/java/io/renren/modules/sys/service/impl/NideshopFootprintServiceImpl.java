package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopFootprintDao;
import io.renren.modules.sys.entity.NideshopFootprintEntity;
import io.renren.modules.sys.service.NideshopFootprintService;


@Service("nideshopFootprintService")
public class NideshopFootprintServiceImpl extends ServiceImpl<NideshopFootprintDao, NideshopFootprintEntity> implements NideshopFootprintService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopFootprintEntity> page = this.page(
                new Query<NideshopFootprintEntity>().getPage(params),
                new QueryWrapper<NideshopFootprintEntity>()
        );

        return new PageUtils(page);
    }

}
