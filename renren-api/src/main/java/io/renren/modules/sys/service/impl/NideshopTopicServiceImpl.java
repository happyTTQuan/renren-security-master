package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopTopicDao;
import io.renren.modules.sys.entity.NideshopTopicEntity;
import io.renren.modules.sys.service.NideshopTopicService;


@Service("nideshopTopicService")
public class NideshopTopicServiceImpl extends ServiceImpl<NideshopTopicDao, NideshopTopicEntity> implements NideshopTopicService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopTopicEntity> page = this.page(
                new Query<NideshopTopicEntity>().getPage(params),
                new QueryWrapper<NideshopTopicEntity>()
        );

        return new PageUtils(page);
    }

}
