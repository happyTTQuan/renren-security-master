package io.renren.param;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by liuzx on 2020/7/20
 **/
@Data
public class AddressParam {

    private Integer id;
    private String name;

    private String mobile;
    private Integer province_id;
    private Integer city_id;
    private Integer district_id;
    private  String address;
    private  Boolean is_default;
    private Integer addressId;

    public void setIs_default(boolean is_default){
        this.is_default = is_default;
    }
    public boolean isIs_defualt(){
        return is_default;
    }

}
