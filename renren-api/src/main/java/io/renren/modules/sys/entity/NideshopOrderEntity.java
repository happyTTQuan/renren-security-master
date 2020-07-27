package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-29 17:58:46
 */
@Data
@TableName("nideshop_order")
public class NideshopOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String orderSn;
	/**
	 * 
	 */
	private Integer userId;
	/**
	 * 
	 */
	private Integer orderStatus;
	/**
	 * 
	 */
	private Integer shippingStatus;
	/**
	 * 
	 */
	private Integer payStatus;
	/**
	 * 
	 */
	private String consignee;
	/**
	 * 
	 */
	private Integer country;
	/**
	 * 
	 */
	private Integer province;
	/**
	 * 
	 */
	private Integer city;
	/**
	 * 
	 */
	private Integer district;
	/**
	 * 
	 */
	private String address;
	/**
	 * 
	 */
	private String mobile;
	/**
	 * 
	 */
	private String postscript;
	/**
	 * 
	 */
	private BigDecimal shippingFee;
	/**
	 * 
	 */
	private String payName;
	/**
	 * 
	 */
	private Integer payId;
	/**
	 * 实际需要支付的金额
	 */
	private BigDecimal actualPrice;
	/**
	 * 
	 */
	private Integer integral;
	/**
	 * 
	 */
	private BigDecimal integralMoney;
	/**
	 * 订单总价
	 */
	private BigDecimal orderPrice;
	/**
	 * 商品总价
	 */
	private BigDecimal goodsPrice;
	/**
	 * 
	 */
	private Integer addTime;
	/**
	 * 
	 */
	private Integer confirmTime;
	/**
	 * 
	 */
	private Integer payTime;
	/**
	 * 配送费用
	 */
	private Integer freightPrice;
	/**
	 * 使用的优惠券id
	 */
	private Integer couponId;
	/**
	 * 
	 */
	private Integer parentId;
	/**
	 * 
	 */
	private BigDecimal couponPrice;
	/**
	 * 
	 */
	private String callbackStatus;

}
