package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopCommentDao;
import io.renren.modules.sys.entity.NideshopCommentEntity;
import io.renren.modules.sys.service.NideshopCommentService;


@Service("nideshopCommentService")
public class NideshopCommentServiceImpl extends ServiceImpl<NideshopCommentDao, NideshopCommentEntity> implements NideshopCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopCommentEntity> page = this.page(
                new Query<NideshopCommentEntity>().getPage(params),
                new QueryWrapper<NideshopCommentEntity>()
        );

        return new PageUtils(page);
    }

}
