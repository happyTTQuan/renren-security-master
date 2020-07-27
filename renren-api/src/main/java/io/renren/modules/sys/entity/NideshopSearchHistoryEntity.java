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
 * @date 2020-06-29 17:41:59
 */
@Data
@TableName("nideshop_search_history")
public class NideshopSearchHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String keyword;
	/**
	 * 搜索来源，如PC、小程序、APP等
	 */
	private String from;
	/**
	 * 搜索时间
	 */
	private Integer addTime;
	/**
	 * 
	 */
	private String userId;

}
