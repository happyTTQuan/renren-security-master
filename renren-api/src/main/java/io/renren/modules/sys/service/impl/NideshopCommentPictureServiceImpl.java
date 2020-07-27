package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopCommentPictureDao;
import io.renren.modules.sys.entity.NideshopCommentPictureEntity;
import io.renren.modules.sys.service.NideshopCommentPictureService;


@Service("nideshopCommentPictureService")
public class NideshopCommentPictureServiceImpl extends ServiceImpl<NideshopCommentPictureDao, NideshopCommentPictureEntity> implements NideshopCommentPictureService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopCommentPictureEntity> page = this.page(
                new Query<NideshopCommentPictureEntity>().getPage(params),
                new QueryWrapper<NideshopCommentPictureEntity>()
        );

        return new PageUtils(page);
    }

}
