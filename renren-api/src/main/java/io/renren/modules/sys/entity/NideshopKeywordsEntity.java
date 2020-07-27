package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 热闹关键词表
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-29 17:58:46
 */
@Data
@TableName("nideshop_keywords")
public class NideshopKeywordsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String keyword;
	/**
	 * 
	 */
	private Integer isHot;
	/**
	 * 
	 */
	private Integer isDefault;
	/**
	 * 
	 */
	private Integer isShow;
	/**
	 * 
	 */
	private Integer sortOrder;
	/**
	 * 关键词的跳转链接
	 */
	private String schemeUrl;
	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer type;

}
