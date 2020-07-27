package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopKeywordsDao;
import io.renren.modules.sys.entity.NideshopKeywordsEntity;
import io.renren.modules.sys.service.NideshopKeywordsService;


@Service("nideshopKeywordsService")
public class NideshopKeywordsServiceImpl extends ServiceImpl<NideshopKeywordsDao, NideshopKeywordsEntity> implements NideshopKeywordsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopKeywordsEntity> page = this.page(
                new Query<NideshopKeywordsEntity>().getPage(params),
                new QueryWrapper<NideshopKeywordsEntity>()
        );

        return new PageUtils(page);
    }

}
