package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopAttributeDao;
import io.renren.modules.sys.entity.NideshopAttributeEntity;
import io.renren.modules.sys.service.NideshopAttributeService;


@Service("nideshopAttributeService")
public class NideshopAttributeServiceImpl extends ServiceImpl<NideshopAttributeDao, NideshopAttributeEntity> implements NideshopAttributeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopAttributeEntity> page = this.page(
                new Query<NideshopAttributeEntity>().getPage(params),
                new QueryWrapper<NideshopAttributeEntity>()
        );

        return new PageUtils(page);
    }

}
