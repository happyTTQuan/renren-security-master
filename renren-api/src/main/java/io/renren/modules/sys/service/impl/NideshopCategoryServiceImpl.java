package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopCategoryDao;
import io.renren.modules.sys.entity.NideshopCategoryEntity;
import io.renren.modules.sys.service.NideshopCategoryService;


@Service("nideshopCategoryService")
public class NideshopCategoryServiceImpl extends ServiceImpl<NideshopCategoryDao, NideshopCategoryEntity> implements NideshopCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopCategoryEntity> page = this.page(
                new Query<NideshopCategoryEntity>().getPage(params),
                new QueryWrapper<NideshopCategoryEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<NideshopCategoryEntity> findsubCata(int id) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopCategoryEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("parent_id", id);
		return this.list(queryWrapper);
	}

}
