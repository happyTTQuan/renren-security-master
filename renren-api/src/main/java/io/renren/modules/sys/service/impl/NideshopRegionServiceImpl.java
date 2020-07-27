package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopRegionDao;
import io.renren.modules.sys.entity.NideshopRegionEntity;
import io.renren.modules.sys.service.NideshopRegionService;


@Service("nideshopRegionService")
public class NideshopRegionServiceImpl extends ServiceImpl<NideshopRegionDao, NideshopRegionEntity> implements NideshopRegionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopRegionEntity> page = this.page(
                new Query<NideshopRegionEntity>().getPage(params),
                new QueryWrapper<NideshopRegionEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<NideshopRegionEntity> queryByParentid(int parentid) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopRegionEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("parent_id", parentid);
		return this.list(queryWrapper);
	}

}
