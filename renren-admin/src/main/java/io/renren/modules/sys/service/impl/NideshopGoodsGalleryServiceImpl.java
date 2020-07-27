package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopGoodsGalleryDao;
import io.renren.modules.sys.entity.NideshopGoodsGalleryEntity;
import io.renren.modules.sys.service.NideshopGoodsGalleryService;


@Service("nideshopGoodsGalleryService")
public class NideshopGoodsGalleryServiceImpl extends ServiceImpl<NideshopGoodsGalleryDao, NideshopGoodsGalleryEntity> implements NideshopGoodsGalleryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopGoodsGalleryEntity> page = this.page(
                new Query<NideshopGoodsGalleryEntity>().getPage(params),
                new QueryWrapper<NideshopGoodsGalleryEntity>()
        );

        return new PageUtils(page);
    }

}
