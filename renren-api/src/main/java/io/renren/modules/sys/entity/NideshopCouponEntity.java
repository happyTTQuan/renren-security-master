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
 * @date 2020-06-29 17:44:54
 */
@Data
@TableName("nideshop_coupon")
public class NideshopCouponEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private BigDecimal typeMoney;
	/**
	 * 
	 */
	private Integer sendType;
	/**
	 * 
	 */
	private BigDecimal minAmount;
	/**
	 * 
	 */
	private BigDecimal maxAmount;
	/**
	 * 
	 */
	private Integer sendStartDate;
	/**
	 * 
	 */
	private Integer sendEndDate;
	/**
	 * 
	 */
	private Integer useStartDate;
	/**
	 * 
	 */
	private Integer useEndDate;
	/**
	 * 
	 */
	private BigDecimal minGoodsAmount;

}
