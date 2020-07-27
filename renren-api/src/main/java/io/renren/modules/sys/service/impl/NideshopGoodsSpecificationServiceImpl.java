package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopGoodsSpecificationDao;
import io.renren.modules.sys.entity.NideshopGoodsSpecificationEntity;
import io.renren.modules.sys.service.NideshopGoodsSpecificationService;


@Service("nideshopGoodsSpecificationService")
public class NideshopGoodsSpecificationServiceImpl extends ServiceImpl<NideshopGoodsSpecificationDao, NideshopGoodsSpecificationEntity> implements NideshopGoodsSpecificationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopGoodsSpecificationEntity> page = this.page(
                new Query<NideshopGoodsSpecificationEntity>().getPage(params),
                new QueryWrapper<NideshopGoodsSpecificationEntity>()
        );

        return new PageUtils(page);
    }

}
