package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopAddressDao;
import io.renren.modules.sys.entity.NideshopAddressEntity;
import io.renren.modules.sys.service.NideshopAddressService;


@Service("nideshopAddressService")
public class NideshopAddressServiceImpl extends ServiceImpl<NideshopAddressDao, NideshopAddressEntity> implements NideshopAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopAddressEntity> page = this.page(
                new Query<NideshopAddressEntity>().getPage(params),
                new QueryWrapper<NideshopAddressEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<NideshopAddressEntity> queryAddressByUserid(int userid) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopAddressEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("user_id", userid);
		return this.list(queryWrapper);
	}

	@Override
	public void updateDefaultAddress(int adressid, int userid) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopAddressEntity> updateWrapper=new QueryWrapper<>();
		updateWrapper.eq("user_id", userid);
		updateWrapper.ne("id", adressid);
		NideshopAddressEntity ent=new NideshopAddressEntity();
		ent.setIsDefault(0);
		this.update(ent, updateWrapper);
	}

	@Override
	public NideshopAddressEntity getDefaultAddress(int userid) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopAddressEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("user_id", userid);
		queryWrapper.eq("is_default", 1);
		List<NideshopAddressEntity> list=this.list(queryWrapper);
		if(list==null||list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
	}

}
