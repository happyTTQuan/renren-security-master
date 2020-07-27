package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopOrderGoodsDao;
import io.renren.modules.sys.entity.NideshopOrderGoodsEntity;
import io.renren.modules.sys.service.NideshopOrderGoodsService;


@Service("nideshopOrderGoodsService")
public class NideshopOrderGoodsServiceImpl extends ServiceImpl<NideshopOrderGoodsDao, NideshopOrderGoodsEntity> implements NideshopOrderGoodsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopOrderGoodsEntity> page = this.page(
                new Query<NideshopOrderGoodsEntity>().getPage(params),
                new QueryWrapper<NideshopOrderGoodsEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<NideshopOrderGoodsEntity> queryByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopOrderGoodsEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("order_id", orderId);
		return baseMapper.selectList(queryWrapper);
	}

}
