package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopGoodsAttributeDao;
import io.renren.modules.sys.entity.NideshopGoodsAttributeEntity;
import io.renren.modules.sys.service.NideshopGoodsAttributeService;


@Service("nideshopGoodsAttributeService")
public class NideshopGoodsAttributeServiceImpl extends ServiceImpl<NideshopGoodsAttributeDao, NideshopGoodsAttributeEntity> implements NideshopGoodsAttributeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopGoodsAttributeEntity> page = this.page(
                new Query<NideshopGoodsAttributeEntity>().getPage(params),
                new QueryWrapper<NideshopGoodsAttributeEntity>()
        );

        return new PageUtils(page);
    }

}
