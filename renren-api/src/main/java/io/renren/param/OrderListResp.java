package io.renren.param;

import java.util.List;

import io.renren.modules.sys.entity.NideshopOrderEntity;
import io.renren.modules.sys.entity.NideshopOrderGoodsEntity;
import lombok.Data;

@Data
public class OrderListResp extends NideshopOrderEntity{
   private List<NideshopOrderGoodsEntity> goodsList;
   private Integer goodsCount;
   private String order_status_text;
   private HandleOption handleOption;
   private String expressNo;
   private String expressName;
}
