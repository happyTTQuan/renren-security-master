package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.NideshopAddressEntity;
import io.renren.modules.sys.entity.NideshopCartEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-29 17:42:05
 */
public interface NideshopCartService extends IService<NideshopCartEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<NideshopCartEntity> listcarts(Integer userid);
    List<NideshopCartEntity> queryCheckedGoods(int userid,int sessionid,int checked);
    List<NideshopCartEntity> listMyCarts(Integer userid,Integer goodid);
    void updateMyCarts(List<Integer> goodList,Integer userid,Integer ischecked);
    void deleteMyCarts(List<Integer> goodList,Integer userid);
    void clearBuyGoods(Integer userid);
}

