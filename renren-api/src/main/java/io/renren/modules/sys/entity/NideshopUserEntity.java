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
 * @date 2020-07-04 19:31:22
 */
@Data
@TableName("nideshop_user")
public class NideshopUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private Integer gender;
	/**
	 * 
	 */
	private Integer birthday;
	/**
	 * 
	 */
	private Integer registerTime;
	/**
	 * 
	 */
	private Integer lastLoginTime;
	/**
	 * 
	 */
	private String lastLoginIp;
	/**
	 * 
	 */
	private Integer userLevelId;
	/**
	 * 
	 */
	private String nickname;
	/**
	 * 
	 */
	private String mobile;
	/**
	 * 
	 */
	private String registerIp;
	/**
	 * 
	 */
	private String avatar;
	/**
	 * 
	 */
	private String weixinOpenid;
	/**
	 * 是否为VIP用户  0 否 1 是
	 */
	private Integer vip;
	/**
	 * 积分
	 */
	private Integer integral;
	/**
	 * VIP过期时间
	 */
	private Date vipExpiretime;

}
