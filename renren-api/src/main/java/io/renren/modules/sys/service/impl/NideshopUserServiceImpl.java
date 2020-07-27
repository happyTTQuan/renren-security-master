package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.renren.common.utils.DateUtils;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopUserDao;
import io.renren.modules.sys.entity.NideshopUserEntity;
import io.renren.modules.sys.service.NideshopUserService;


@Service("nideshopUserService")
public class NideshopUserServiceImpl extends ServiceImpl<NideshopUserDao, NideshopUserEntity> implements NideshopUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopUserEntity> page = this.page(
                new Query<NideshopUserEntity>().getPage(params),
                new QueryWrapper<NideshopUserEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public NideshopUserEntity queryByOpenid(String openid) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopUserEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("weixin_openid", openid);
		List<NideshopUserEntity> users=this.list(queryWrapper);
		if(users==null||users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public NideshopUserEntity queryByMobileno(String mobileno) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopUserEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("mobile", mobileno);
		List<NideshopUserEntity> users=this.list(queryWrapper);
		if(users==null||users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public NideshopUserEntity queryByToken(String token) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopUserEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("last_login_ip", token);
		List<NideshopUserEntity> users=this.list(queryWrapper);
		if(users==null||users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public void setUserVip(Integer userid) {
		// TODO Auto-generated method stub
		NideshopUserEntity user=this.getBaseMapper().selectById(userid);
		user.setVip(1);
		Date expireTime=DateUtils.addDateMonths(new Date(), 12);
		user.setVipExpiretime(expireTime);
		this.baseMapper.updateById(user);
	}

}
