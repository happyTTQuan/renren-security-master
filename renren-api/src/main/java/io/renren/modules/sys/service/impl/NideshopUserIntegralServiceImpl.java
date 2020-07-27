package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopUserIntegralDao;
import io.renren.modules.sys.entity.NideshopUserIntegralEntity;
import io.renren.modules.sys.service.NideshopUserIntegralService;


@Service("nideshopUserIntegralService")
public class NideshopUserIntegralServiceImpl extends ServiceImpl<NideshopUserIntegralDao, NideshopUserIntegralEntity> implements NideshopUserIntegralService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopUserIntegralEntity> page = this.page(
                new Query<NideshopUserIntegralEntity>().getPage(params),
                new QueryWrapper<NideshopUserIntegralEntity>()
        );

        return new PageUtils(page);
    }
    @Override
    public PageUtils queryPage(Map<String, Object> params,Integer userid) {
        IPage<NideshopUserIntegralEntity> page = this.page(
                new Query<NideshopUserIntegralEntity>().getPage(params),
                new QueryWrapper<NideshopUserIntegralEntity>().eq("user_id", userid)
        );

        return new PageUtils(page);
    }
}
