package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopRelatedGoodsDao;
import io.renren.modules.sys.entity.NideshopRelatedGoodsEntity;
import io.renren.modules.sys.service.NideshopRelatedGoodsService;


@Service("nideshopRelatedGoodsService")
public class NideshopRelatedGoodsServiceImpl extends ServiceImpl<NideshopRelatedGoodsDao, NideshopRelatedGoodsEntity> implements NideshopRelatedGoodsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopRelatedGoodsEntity> page = this.page(
                new Query<NideshopRelatedGoodsEntity>().getPage(params),
                new QueryWrapper<NideshopRelatedGoodsEntity>()
        );

        return new PageUtils(page);
    }

}
