package io.renren.param;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;
import weixin.popular.bean.wxa.WxaUserInfoResult;

/**
 * create by liuzx on 2020/7/9
 **/
@Data
public class LoginParam {
    WxaUserInfoResult userInfo;
    String code;
}
