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
@TableName("nideshop_admin")
public class NideshopAdminEntity implements Serializable {
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
	private String passwordSalt;
	/**
	 * 
	 */
	private String lastLoginIp;
	/**
	 * 
	 */
	private Integer lastLoginTime;
	/**
	 * 
	 */
	private Integer addTime;
	/**
	 * 
	 */
	private Integer updateTime;
	/**
	 * 
	 */
	private String avatar;
	/**
	 * 
	 */
	private Integer adminRoleId;

}
