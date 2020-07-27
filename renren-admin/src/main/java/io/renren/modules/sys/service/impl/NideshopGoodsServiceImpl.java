package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopGoodsDao;
import io.renren.modules.sys.entity.NideshopGoodsEntity;
import io.renren.modules.sys.service.NideshopGoodsService;


@Service("nideshopGoodsService")
public class NideshopGoodsServiceImpl extends ServiceImpl<NideshopGoodsDao, NideshopGoodsEntity> implements NideshopGoodsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopGoodsEntity> page = this.page(
                new Query<NideshopGoodsEntity>().getPage(params),
                new QueryWrapper<NideshopGoodsEntity>()
        );

        return new PageUtils(page);
    }

}
