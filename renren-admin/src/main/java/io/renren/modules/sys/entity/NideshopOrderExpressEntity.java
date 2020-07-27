package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 快递信息表
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-07-26 17:58:36
 */
@Data
@TableName("nideshop_order_express")
public class NideshopOrderExpressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 快递单ID
	 */
	@TableId
	private Long id;
	/**
	 * 订单ID
	 */
	private Integer orderId;
	/**
	 * 商品详情
	 */
	private String goodsDetail;
	/**
	 * 收获人地址
	 */
	private String recvAddress;
	/**
	 * 收获人名称
	 */
	private String recvUsername;
	/**
	 * 收货人手机号码
	 */
	private String recvMobile;
	/**
	 * 快递单号
	 */
	private String expressNo;
	/**
	 * 快递公司名称
	 */
	private String expressName;
	/**
	 * 订单金额
	 */
	private BigDecimal orderPrice;

}
