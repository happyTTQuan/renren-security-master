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
@TableName("nideshop_brand")
public class NideshopBrandEntity implements Serializable {
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
	private String listPicUrl;
	/**
	 * 
	 */
	private String simpleDesc;
	/**
	 * 
	 */
	private String picUrl;
	/**
	 * 
	 */
	private Integer sortOrder;
	/**
	 * 
	 */
	private Integer isShow;
	/**
	 * 
	 */
	private BigDecimal floorPrice;
	/**
	 * 
	 */
	private String appListPicUrl;
	/**
	 * 
	 */
	private Integer isNew;
	/**
	 * 
	 */
	private String newPicUrl;
	/**
	 * 
	 */
	private Integer newSortOrder;

}
