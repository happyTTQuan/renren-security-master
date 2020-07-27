package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopAdminDao;
import io.renren.modules.sys.entity.NideshopAdminEntity;
import io.renren.modules.sys.service.NideshopAdminService;


@Service("nideshopAdminService")
public class NideshopAdminServiceImpl extends ServiceImpl<NideshopAdminDao, NideshopAdminEntity> implements NideshopAdminService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopAdminEntity> page = this.page(
                new Query<NideshopAdminEntity>().getPage(params),
                new QueryWrapper<NideshopAdminEntity>()
        );

        return new PageUtils(page);
    }

}
