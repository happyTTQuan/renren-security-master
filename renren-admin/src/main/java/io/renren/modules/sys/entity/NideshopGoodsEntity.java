package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
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
@TableName("nideshop_goods")
public class NideshopGoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 目录ID
	 */
	private Integer categoryId;
	/**
	 * 
	 */
	private String goodsSn;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 
	 */
	private Integer brandId;
	/**
	 * 
	 */
	private Integer goodsNumber;
	/**
	 * 
	 */
	private String keywords;
	/**
	 * 商品描述
	 */
	private String goodsBrief;
	/**
	 * 
	 */
	private String goodsDesc;
	/**
	 * 
	 */
	private Integer isOnSale;
	/**
	 * 
	 */
	private Integer addTime;
	/**
	 * 
	 */
	private Integer sortOrder;
	/**
	 * 
	 */
	private Integer isDelete;
	/**
	 * 
	 */
	private Integer attributeCategory;
	/**
	 * 专柜价格
	 */
	private BigDecimal counterPrice;
	/**
	 * 附加价格
	 */
	private BigDecimal extraPrice;
	/**
	 * 
	 */
	private Integer isNew;
	/**
	 * 商品单位
	 */
	private String goodsUnit;
	/**
	 * 商品主图
	 */
	private String primaryPicUrl;
	/**
	 * 商品列表图
	 */
	private String listPicUrl;
	/**
	 * VIP价格
	 */
	private BigDecimal retailPrice;
	/**
	 * 销售量
	 */
	private Integer sellVolume;
	/**
	 * 主sku　product_id
	 */
	private Integer primaryProductId;
	/**
	 * 市场价格
	 */
	private BigDecimal unitPrice;
	/**
	 * 
	 */
	private String promotionDesc;
	/**
	 * 
	 */
	private String promotionTag;
	/**
	 * APP专享价
	 */
	private BigDecimal appExclusivePrice;
	/**
	 * 是否是APP专属
	 */
	private Integer isAppExclusive;
	/**
	 * 
	 */
	private Integer isLimited;
	/**
	 * 
	 */
	private Integer isHot;

}
