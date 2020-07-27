package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopOrderExpressDao;
import io.renren.modules.sys.entity.NideshopOrderExpressEntity;
import io.renren.modules.sys.service.NideshopOrderExpressService;


@Service("nideshopOrderExpressService")
public class NideshopOrderExpressServiceImpl extends ServiceImpl<NideshopOrderExpressDao, NideshopOrderExpressEntity> implements NideshopOrderExpressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopOrderExpressEntity> page = this.page(
                new Query<NideshopOrderExpressEntity>().getPage(params),
                new QueryWrapper<NideshopOrderExpressEntity>()
        );

        return new PageUtils(page);
    }

}
