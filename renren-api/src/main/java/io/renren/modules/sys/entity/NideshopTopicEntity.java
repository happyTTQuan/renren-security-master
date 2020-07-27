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
 * @date 2020-06-29 17:41:52
 */
@Data
@TableName("nideshop_topic")
public class NideshopTopicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private String avatar;
	/**
	 * 
	 */
	private String itemPicUrl;
	/**
	 * 
	 */
	private String subtitle;
	/**
	 * 
	 */
	private Integer topicCategoryId;
	/**
	 * 
	 */
	private BigDecimal priceInfo;
	/**
	 * 
	 */
	private String readCount;
	/**
	 * 
	 */
	private String scenePicUrl;
	/**
	 * 
	 */
	private Integer topicTemplateId;
	/**
	 * 
	 */
	private Integer topicTagId;
	/**
	 * 
	 */
	private Integer sortOrder;
	/**
	 * 
	 */
	private Integer isShow;

}
