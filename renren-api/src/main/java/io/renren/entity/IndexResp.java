package io.renren.entity;

import java.io.Serializable;
import java.util.List;

import io.renren.modules.sys.entity.NideshopAdEntity;
import io.renren.modules.sys.entity.NideshopGoodsEntity;
import lombok.Data;

@Data
public class IndexResp implements Serializable{
 private List<NideshopAdEntity> banner;
 private List<NideshopGoodsEntity> hotGoods;
}
