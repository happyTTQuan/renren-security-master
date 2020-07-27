package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.NideshopGoodsGalleryEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-29 17:44:54
 */
public interface NideshopGoodsGalleryService extends IService<NideshopGoodsGalleryEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<NideshopGoodsGalleryEntity> findByGoodsId(int goodsid);
}

