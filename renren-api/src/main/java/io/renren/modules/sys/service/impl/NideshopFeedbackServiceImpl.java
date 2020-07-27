package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopFeedbackDao;
import io.renren.modules.sys.entity.NideshopFeedbackEntity;
import io.renren.modules.sys.service.NideshopFeedbackService;


@Service("nideshopFeedbackService")
public class NideshopFeedbackServiceImpl extends ServiceImpl<NideshopFeedbackDao, NideshopFeedbackEntity> implements NideshopFeedbackService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopFeedbackEntity> page = this.page(
                new Query<NideshopFeedbackEntity>().getPage(params),
                new QueryWrapper<NideshopFeedbackEntity>()
        );

        return new PageUtils(page);
    }

}
