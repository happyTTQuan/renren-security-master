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
 * @date 2020-06-29 17:42:05
 */
@Data
@TableName("nideshop_category")
public class NideshopCategoryEntity implements Serializable {
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
	private String keywords;
	/**
	 * 
	 */
	private String frontDesc;
	/**
	 * 
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
	 * 
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
