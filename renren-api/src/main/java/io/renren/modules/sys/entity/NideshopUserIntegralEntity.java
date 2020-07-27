package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户积分表
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-07-04 19:31:22
 */
@Data
@TableName("nideshop_user_integral")
public class NideshopUserIntegralEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 用户名称
	 */
	private String userId;
	/**
	 * 快递公司代码
	 */
	private Date createTime;
	/**
	 * 积分数量
	 */
	private Integer num;
	/**
	 * 商品名称
	 */
	private String goodsName;

}
