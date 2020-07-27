package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopTopicCategoryDao;
import io.renren.modules.sys.entity.NideshopTopicCategoryEntity;
import io.renren.modules.sys.service.NideshopTopicCategoryService;


@Service("nideshopTopicCategoryService")
public class NideshopTopicCategoryServiceImpl extends ServiceImpl<NideshopTopicCategoryDao, NideshopTopicCategoryEntity> implements NideshopTopicCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopTopicCategoryEntity> page = this.page(
                new Query<NideshopTopicCategoryEntity>().getPage(params),
                new QueryWrapper<NideshopTopicCategoryEntity>()
        );

        return new PageUtils(page);
    }

}
