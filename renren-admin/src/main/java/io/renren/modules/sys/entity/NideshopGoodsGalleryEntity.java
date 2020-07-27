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
 * @date 2020-07-23 13:44:46
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
	 * 商品ID
	 */
	private Integer goodsId;
	/**
	 * 图片路径
	 */
	private String imgUrl;
	/**
	 * 图片描述
	 */
	private String imgDesc;
	/**
	 * 
	 */
	private Integer sortOrder;

}
