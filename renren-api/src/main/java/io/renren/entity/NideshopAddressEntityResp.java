package io.renren.entity;

import java.io.Serializable;

import io.renren.modules.sys.entity.NideshopAddressEntity;
import io.renren.modules.sys.entity.NideshopRegionEntity;
import lombok.Data;

@Data
public class NideshopAddressEntityResp extends NideshopAddressEntity implements Serializable{
  private String province_name;
  private String city_name;
  private String district_name;
  private String full_region;
}
