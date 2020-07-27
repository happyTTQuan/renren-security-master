package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopSpecificationDao;
import io.renren.modules.sys.entity.NideshopSpecificationEntity;
import io.renren.modules.sys.service.NideshopSpecificationService;


@Service("nideshopSpecificationService")
public class NideshopSpecificationServiceImpl extends ServiceImpl<NideshopSpecificationDao, NideshopSpecificationEntity> implements NideshopSpecificationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopSpecificationEntity> page = this.page(
                new Query<NideshopSpecificationEntity>().getPage(params),
                new QueryWrapper<NideshopSpecificationEntity>()
        );

        return new PageUtils(page);
    }

}
