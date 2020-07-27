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
 * @date 2020-06-29 17:44:54
 */
@Data
@TableName("nideshop_feedback")
public class NideshopFeedbackEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer msgId;
	/**
	 * 
	 */
	private Integer parentId;
	/**
	 * 
	 */
	private Integer userId;
	/**
	 * 
	 */
	private String userName;
	/**
	 * 
	 */
	private String userEmail;
	/**
	 * 
	 */
	private String msgTitle;
	/**
	 * 
	 */
	private Integer msgType;
	/**
	 * 
	 */
	private Integer msgStatus;
	/**
	 * 
	 */
	private String msgContent;
	/**
	 * 
	 */
	private Integer msgTime;
	/**
	 * 
	 */
	private String messageImg;
	/**
	 * 
	 */
	private Integer orderId;
	/**
	 * 
	 */
	private Integer msgArea;

}
