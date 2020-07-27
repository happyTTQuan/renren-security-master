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
@TableName("nideshop_address")
public class NideshopAddressEntity implements Serializable {
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
	private Integer userId;
	/**
	 * 
	 */
	private Integer countryId;
	/**
	 * 
	 */
	private Integer provinceId;
	/**
	 * 
	 */
	private Integer cityId;
	/**
	 * 
	 */
	private Integer districtId;
	/**
	 * 
	 */
	private String address;
	/**
	 * 
	 */
	private String mobile;
	/**
	 * 
	 */
	private Integer isDefault;

}
