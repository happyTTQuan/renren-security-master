package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopCollectDao;
import io.renren.modules.sys.entity.NideshopCollectEntity;
import io.renren.modules.sys.service.NideshopCollectService;


@Service("nideshopCollectService")
public class NideshopCollectServiceImpl extends ServiceImpl<NideshopCollectDao, NideshopCollectEntity> implements NideshopCollectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopCollectEntity> page = this.page(
                new Query<NideshopCollectEntity>().getPage(params),
                new QueryWrapper<NideshopCollectEntity>()
        );

        return new PageUtils(page);
    }

}
