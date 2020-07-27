package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopGoodsDao;
import io.renren.modules.sys.entity.NideshopGoodsEntity;
import io.renren.modules.sys.service.NideshopGoodsService;


@Service("nideshopGoodsService")
public class NideshopGoodsServiceImpl extends ServiceImpl<NideshopGoodsDao, NideshopGoodsEntity> implements NideshopGoodsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopGoodsEntity> page = this.page(
                new Query<NideshopGoodsEntity>().getPage(params),
                new QueryWrapper<NideshopGoodsEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<NideshopGoodsEntity> queryHotGoods() {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopGoodsEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("is_hot", 1);
		queryWrapper.last("limit 3");
		return this.list(queryWrapper);
	}

	@Override
	public String queryGoodsPicUrl(int goodid) {
		// TODO Auto-generated method stub
		NideshopGoodsEntity ent=this.getById(goodid);
		return ent.getListPicUrl();
	}

	@Override
	public PageUtils listByCataLog(Map<String, Object> params,int catalogid) {
		// TODO Auto-generated method stub
		IPage<NideshopGoodsEntity> page = this.page(
                new Query<NideshopGoodsEntity>().getPage(params),
                new QueryWrapper<NideshopGoodsEntity>().eq("category_id", catalogid)
        );
        return new PageUtils(page);
	}

	@Override
	public PageUtils queryPageByCataLogs(Map<String, Object> params,List<Integer> catalogs) {
		// TODO Auto-generated method stub
		IPage<NideshopGoodsEntity> page = this.page(
                new Query<NideshopGoodsEntity>().getPage(params),
                new QueryWrapper<NideshopGoodsEntity>().in("category_id", catalogs)
        );

        return new PageUtils(page);
	}

}
