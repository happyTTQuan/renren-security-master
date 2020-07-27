package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopAttributeCategoryDao;
import io.renren.modules.sys.entity.NideshopAttributeCategoryEntity;
import io.renren.modules.sys.service.NideshopAttributeCategoryService;


@Service("nideshopAttributeCategoryService")
public class NideshopAttributeCategoryServiceImpl extends ServiceImpl<NideshopAttributeCategoryDao, NideshopAttributeCategoryEntity> implements NideshopAttributeCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopAttributeCategoryEntity> page = this.page(
                new Query<NideshopAttributeCategoryEntity>().getPage(params),
                new QueryWrapper<NideshopAttributeCategoryEntity>()
        );

        return new PageUtils(page);
    }

}
