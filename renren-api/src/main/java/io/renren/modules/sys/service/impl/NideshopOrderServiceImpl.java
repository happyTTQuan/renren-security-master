package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopOrderDao;
import io.renren.modules.sys.entity.NideshopOrderEntity;
import io.renren.modules.sys.service.NideshopOrderService;


@Service("nideshopOrderService")
public class NideshopOrderServiceImpl extends ServiceImpl<NideshopOrderDao, NideshopOrderEntity> implements NideshopOrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopOrderEntity> page = this.page(
                new Query<NideshopOrderEntity>().getPage(params),
                new QueryWrapper<NideshopOrderEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<NideshopOrderEntity> queryOrderByUserId(Integer userid) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopOrderEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("user_id", userid);
		List<NideshopOrderEntity> orders=this.list(queryWrapper);
		if(orders!=null&&!orders.isEmpty()) {
		Collections.sort(orders, new Comparator<NideshopOrderEntity>() {

			@Override
			public int compare(NideshopOrderEntity o1, NideshopOrderEntity o2) {
				// TODO Auto-generated method stub
				return -o1.getAddTime().compareTo(o2.getAddTime());
			}
		});
		int size=orders.size();
		if(size>10) {
		return orders.subList(size-10, size);
		}else {
			return orders;
		}
		}
		return new ArrayList<NideshopOrderEntity>();
	}

	@Override
	public void updateOrderStatus(Integer orderId) {
		// TODO Auto-generated method stub
		NideshopOrderEntity ent=new NideshopOrderEntity();
		ent.setOrderStatus(1);
		ent.setPayTime(new Long(System.currentTimeMillis()/1000).intValue());
		ent.setPayStatus(1);
		ent.setId(orderId);
		this.baseMapper.updateById(ent);
		
	}

}
