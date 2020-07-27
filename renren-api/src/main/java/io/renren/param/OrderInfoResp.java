package io.renren.param;

import io.renren.modules.sys.entity.NideshopOrderEntity;
import lombok.Data;

@Data
public class OrderInfoResp extends NideshopOrderEntity{
 private String province_name;
 private String city_name;
 private String district_name;
 private String full_region;
 private String order_status_text;
 private String add_time;
 private String final_pay_time;
 private String expressNo;
 private String expressName;
}
