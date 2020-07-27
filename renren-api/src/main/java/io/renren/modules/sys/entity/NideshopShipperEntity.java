package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 快递公司
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-06-29 17:41:59
 */
@Data
@TableName("nideshop_shipper")
public class NideshopShipperEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 快递公司名称
	 */
	private String name;
	/**
	 * 快递公司代码
	 */
	private String code;
	/**
	 * 排序
	 */
	private Integer sortOrder;

}
