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
@TableName("nideshop_product")
public class NideshopProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer goodsId;
	/**
	 * 
	 */
	private String goodsSpecificationIds;
	/**
	 * 
	 */
	private String goodsSn;
	/**
	 * 
	 */
	private Integer goodsNumber;
	/**
	 * 
	 */
	private BigDecimal retailPrice;

}
