package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopUserLevelDao;
import io.renren.modules.sys.entity.NideshopUserLevelEntity;
import io.renren.modules.sys.service.NideshopUserLevelService;


@Service("nideshopUserLevelService")
public class NideshopUserLevelServiceImpl extends ServiceImpl<NideshopUserLevelDao, NideshopUserLevelEntity> implements NideshopUserLevelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopUserLevelEntity> page = this.page(
                new Query<NideshopUserLevelEntity>().getPage(params),
                new QueryWrapper<NideshopUserLevelEntity>()
        );

        return new PageUtils(page);
    }

}
