package io.renren.param;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;
import weixin.popular.bean.wxa.WxaUserInfoResult;

/**
 * create by liuzx on 2020/7/9
 **/
@Data
public class CartParam {
    private int goodsId;
    private int number;
    private int cartid;
    private int productId;
    private String goodsIdList;
    private  int ischecked;
    private Integer addressId;
}
