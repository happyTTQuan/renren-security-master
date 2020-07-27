package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopBrandDao;
import io.renren.modules.sys.entity.NideshopBrandEntity;
import io.renren.modules.sys.service.NideshopBrandService;


@Service("nideshopBrandService")
public class NideshopBrandServiceImpl extends ServiceImpl<NideshopBrandDao, NideshopBrandEntity> implements NideshopBrandService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopBrandEntity> page = this.page(
                new Query<NideshopBrandEntity>().getPage(params),
                new QueryWrapper<NideshopBrandEntity>()
        );

        return new PageUtils(page);
    }

}
