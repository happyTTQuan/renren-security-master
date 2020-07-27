package io.renren.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * create by liuzx on 2020/7/4
 **/
@Configuration
@Data
public class WechatAppConfig {
    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.appsecret}")
    private String appsecret;
    @Value("${wechat.mch_id}")
    private String mch_id;
    @Value("${wechat.notify_url}")
    private String notify_url;
    @Value("${wechat.spbill_create_ip}")
    private String spbill_create_ip;
    @Value("${wechat.mch_key}")
    private String mch_key;
}
