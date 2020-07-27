package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopChannelDao;
import io.renren.modules.sys.entity.NideshopChannelEntity;
import io.renren.modules.sys.service.NideshopChannelService;


@Service("nideshopChannelService")
public class NideshopChannelServiceImpl extends ServiceImpl<NideshopChannelDao, NideshopChannelEntity> implements NideshopChannelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopChannelEntity> page = this.page(
                new Query<NideshopChannelEntity>().getPage(params),
                new QueryWrapper<NideshopChannelEntity>()
        );

        return new PageUtils(page);
    }

}
