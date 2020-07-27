package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopProductDao;
import io.renren.modules.sys.entity.NideshopProductEntity;
import io.renren.modules.sys.service.NideshopProductService;


@Service("nideshopProductService")
public class NideshopProductServiceImpl extends ServiceImpl<NideshopProductDao, NideshopProductEntity> implements NideshopProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopProductEntity> page = this.page(
                new Query<NideshopProductEntity>().getPage(params),
                new QueryWrapper<NideshopProductEntity>()
        );

        return new PageUtils(page);
    }

}
