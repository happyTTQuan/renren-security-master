package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopSearchHistoryDao;
import io.renren.modules.sys.entity.NideshopSearchHistoryEntity;
import io.renren.modules.sys.service.NideshopSearchHistoryService;


@Service("nideshopSearchHistoryService")
public class NideshopSearchHistoryServiceImpl extends ServiceImpl<NideshopSearchHistoryDao, NideshopSearchHistoryEntity> implements NideshopSearchHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopSearchHistoryEntity> page = this.page(
                new Query<NideshopSearchHistoryEntity>().getPage(params),
                new QueryWrapper<NideshopSearchHistoryEntity>()
        );

        return new PageUtils(page);
    }

}
