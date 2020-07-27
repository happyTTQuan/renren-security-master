package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.NideshopKeywordsEntity;

import java.util.Map;

/**
 * 热闹关键词表
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-29 17:58:46
 */
public interface NideshopKeywordsService extends IService<NideshopKeywordsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

