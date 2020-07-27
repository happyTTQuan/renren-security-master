package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopAdDao;
import io.renren.modules.sys.entity.NideshopAdEntity;
import io.renren.modules.sys.service.NideshopAdService;


@Service("nideshopAdService")
public class NideshopAdServiceImpl extends ServiceImpl<NideshopAdDao, NideshopAdEntity> implements NideshopAdService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopAdEntity> page = this.page(
                new Query<NideshopAdEntity>().getPage(params),
                new QueryWrapper<NideshopAdEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<NideshopAdEntity> queryAd() {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopAdEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("ad_position_id", 1);
		return this.list(queryWrapper);
	}

}
