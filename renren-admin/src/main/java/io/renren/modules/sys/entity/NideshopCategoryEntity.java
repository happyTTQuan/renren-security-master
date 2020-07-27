package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-07-23 13:44:46
 */
@Data
@TableName("nideshop_category")
public class NideshopCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Integer id;
	/**
	 * 目录名称
	 */
	private String name;
	/**
	 * 
	 */
	private String keywords;
	/**
	 * 
	 */
	private String frontDesc;
	/**
	 * 父目录ID
	 */
	private Integer parentId;
	/**
	 * 
	 */
	private Integer sortOrder;
	/**
	 * 
	 */
	private Integer showIndex;
	/**
	 * 
	 */
	private Integer isShow;
	/**
	 * 
	 */
	private String bannerUrl;
	/**
	 * 
	 */
	private String iconUrl;
	/**
	 * 
	 */
	private String imgUrl;
	/**
	 * URL
	 */
	private String wapBannerUrl;
	/**
	 * 
	 */
	private String level;
	/**
	 * 
	 */
	private Integer type;
	/**
	 * 
	 */
	private String frontName;

}
