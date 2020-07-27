package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.NideshopUserEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-07-04 19:31:22
 */
public interface NideshopUserService extends IService<NideshopUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
    NideshopUserEntity queryByOpenid(String openid);
    NideshopUserEntity queryByMobileno(String mobileno);
    NideshopUserEntity queryByToken(String token);
    void setUserVip(Integer userid);
}

