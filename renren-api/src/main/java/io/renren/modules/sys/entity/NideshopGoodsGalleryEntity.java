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
@TableName("nideshop_goods_gallery")
public class NideshopGoodsGalleryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer goodsId;
	/**
	 * 
	 */
	private String imgUrl;
	/**
	 * 
	 */
	private String imgDesc;
	/**
	 * 
	 */
	private Integer sortOrder;

}
