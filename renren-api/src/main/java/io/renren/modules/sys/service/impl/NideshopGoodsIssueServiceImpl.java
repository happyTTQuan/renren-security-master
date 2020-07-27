package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopGoodsIssueDao;
import io.renren.modules.sys.entity.NideshopGoodsIssueEntity;
import io.renren.modules.sys.service.NideshopGoodsIssueService;


@Service("nideshopGoodsIssueService")
public class NideshopGoodsIssueServiceImpl extends ServiceImpl<NideshopGoodsIssueDao, NideshopGoodsIssueEntity> implements NideshopGoodsIssueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopGoodsIssueEntity> page = this.page(
                new Query<NideshopGoodsIssueEntity>().getPage(params),
                new QueryWrapper<NideshopGoodsIssueEntity>()
        );

        return new PageUtils(page);
    }

}
