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
 * @date 2020-06-29 17:42:05
 */
@Data
@TableName("nideshop_cart")
public class NideshopCartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer userId;
	/**
	 * 
	 */
	private String sessionId;
	/**
	 * 
	 */
	private Integer goodsId;
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
	private String goodsName;
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
	private Integer number;
	/**
	 * 规格属性组成的字符串，用来显示用
	 */
	private String goodsSpecifitionNameValue;
	/**
	 * product表对应的goods_specifition_ids
	 */
	private String goodsSpecifitionIds;
	/**
	 * 
	 */
	private Integer checked;
	/**
	 * 
	 */
	private String listPicUrl;

}
