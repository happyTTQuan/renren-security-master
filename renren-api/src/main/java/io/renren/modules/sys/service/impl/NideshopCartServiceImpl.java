package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.NideshopCartDao;
import io.renren.modules.sys.entity.NideshopCartEntity;
import io.renren.modules.sys.service.NideshopCartService;


@Service("nideshopCartService")
public class NideshopCartServiceImpl extends ServiceImpl<NideshopCartDao, NideshopCartEntity> implements NideshopCartService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NideshopCartEntity> page = this.page(
                new Query<NideshopCartEntity>().getPage(params),
                new QueryWrapper<NideshopCartEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<NideshopCartEntity> listcarts(Integer userid) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopCartEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("user_id",userid );
		queryWrapper.eq("session_id", "1");
		return this.list(queryWrapper);
	}

	@Override
	public List<NideshopCartEntity> listMyCarts(Integer userid,Integer goodid) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopCartEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("user_id",userid );
		queryWrapper.eq("goods_id", goodid);
		return this.list(queryWrapper);
	}

	@Override
	public void updateMyCarts(List<Integer> goodList, Integer userid, Integer ischecked) {
		// TODO Auto-generated method stub
		UpdateWrapper<NideshopCartEntity> updateWrapper=new UpdateWrapper<>();
		updateWrapper.in("goods_id", goodList);
		updateWrapper.eq("user_id", userid);
		updateWrapper.set("checked", ischecked);
		this.update(updateWrapper);
	}

	@Override
	public void deleteMyCarts(List<Integer> goodList, Integer userid) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopCartEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("user_id",userid );
		queryWrapper.in("goods_id", goodList);
		this.remove(queryWrapper);
	}

	@Override
	public List<NideshopCartEntity> queryCheckedGoods(int userid, int sessionid, int checked) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopCartEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("user_id",userid );
		queryWrapper.eq("session_id", sessionid);
		queryWrapper.eq("checked", checked);
		return this.list(queryWrapper);
	}

	@Override
	public void clearBuyGoods(Integer userid) {
		// TODO Auto-generated method stub
		QueryWrapper<NideshopCartEntity> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("user_id",userid );
		queryWrapper.in("checked", 1);
		queryWrapper.eq("session_id", 1);
		this.remove(queryWrapper);
	}

}
