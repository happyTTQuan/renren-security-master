package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.NideshopAddressEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-29 17:42:05
 */
public interface NideshopAddressService extends IService<NideshopAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    List<NideshopAddressEntity> queryAddressByUserid(int userid);
    
    void updateDefaultAddress(int adressid,int userid);
    
    NideshopAddressEntity getDefaultAddress(int userid);
}

