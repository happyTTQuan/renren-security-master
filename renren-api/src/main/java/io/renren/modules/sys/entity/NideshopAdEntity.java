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
@TableName("nideshop_ad")
public class NideshopAdEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer adPositionId;
	/**
	 * 
	 */
	private Integer mediaType;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String link;
	/**
	 * 
	 */
	private String imageUrl;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private Integer endTime;
	/**
	 * 
	 */
	private Integer enabled;

}
