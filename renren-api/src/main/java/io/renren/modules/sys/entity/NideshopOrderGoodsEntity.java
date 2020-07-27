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
 * @date 2020-06-29 17:41:59
 */
@Data
@TableName("nideshop_order_goods")
public class NideshopOrderGoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer orderId;
	/**
	 * 
	 */
	private Integer goodsId;
	/**
	 * 
	 */
	private String goodsName;
	/**
	 * 
	 */
	private String goodsSn;
	/**
	 * 
	 */
	private Integer productId;
	/**
	 * 
	 */
	private Integer number;
	/**
	 * 
	 */
	private BigDecimal marketPrice;
	/**
	 * 
	 */
	private BigDecimal retailPrice;
	/**
	 * 
	 */
	private String goodsSpecifitionNameValue;
	/**
	 * 
	 */
	private Integer isReal;
	/**
	 * 
	 */
	private String goodsSpecifitionIds;
	/**
	 * 
	 */
	private String listPicUrl;

}
