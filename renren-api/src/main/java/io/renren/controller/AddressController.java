package io.renren.controller;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import io.renren.entity.NideshopAddressEntityResp;

import io.renren.param.AddressParam;
import io.renren.param.LoginParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.renren.modules.sys.entity.NideshopAddressEntity;
import io.renren.modules.sys.service.NideshopAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.renren.common.utils.R;
import io.renren.common.utils.R;
import io.renren.common.utils.SystemCache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/address/")
@Api(tags="收获地址管理")
public class AddressController extends BaseController{
    @Autowired
    private NideshopAddressService nideshopAddressService;

    /**
         * 列表
     */	
    @GetMapping("list")
    @ApiOperation(value="获取地址信息", response=NideshopAddressEntity.class)
    public R list(HttpServletRequest  request){
    	Integer userid=this.getUserID(request);
    	if(userid==null) {
    		return R.error(10001, "请先登录");
    	}
        List<NideshopAddressEntity> list = nideshopAddressService.queryAddressByUserid(userid);
        List<NideshopAddressEntityResp> retlist=new ArrayList<>();
        for(NideshopAddressEntity ent:list) {
        	NideshopAddressEntityResp resp=new NideshopAddressEntityResp();
        	BeanUtils.copyProperties(ent, resp);
        	resp.setProvince_name(SystemCache.regionMap.get(ent.getProvinceId()).split("---")[0]);
        	resp.setCity_name(SystemCache.regionMap.get(ent.getCityId()).split("---")[0]);
        	resp.setDistrict_name(SystemCache.regionMap.get(ent.getDistrictId()).split("---")[0]);
        	resp.setFull_region(resp.getProvince_name()+resp.getCity_name()+resp.getDistrict_name());
        	retlist.add(resp);
        }
        return R.ok().put("data", retlist);
    }


    /**
     * 信息 
     */
    @PostMapping("save")
    @ApiOperation(value="更新收获地址信息", response=NideshopAddressEntity.class)
    public R save(HttpServletRequest  request,@RequestBody AddressParam addressParam){
    	Integer userid=this.getUserID(request);
    	if(userid==null) {
    		return R.error(10001, "请先登录");
    	}
    	log.info("addressParam:"+ JSON.toJSONString(addressParam));
    	NideshopAddressEntity ent=new NideshopAddressEntity();
		ent.setUserId(getUserID(request));
		ent.setAddress(addressParam.getAddress());
		ent.setName(addressParam.getName());
		ent.setMobile(addressParam.getMobile());
		ent.setProvinceId(addressParam.getProvince_id());
		ent.setCityId(addressParam.getCity_id());
		ent.setDistrictId(addressParam.getDistrict_id());
		ent.setIsDefault((addressParam.isIs_defualt()?1:0));
		ent.setCountryId(1);
		int id=0;
    	if(addressParam.getId()==null||addressParam.getId()==0) {
    		nideshopAddressService.save(ent);
    		id=ent.getId();
    	}else {
    		ent.setId(addressParam.getId());
    		nideshopAddressService.updateById(ent);
    		id=ent.getId();
    	}
    	if(addressParam.isIs_defualt()) {
    		nideshopAddressService.updateDefaultAddress(id, userid);
    	}
        return R.ok().put("data", ent);
    }
    
    /**
     * 信息
     */
    @GetMapping("/detail")
    @ApiOperation(value="获取地址详情")
    public R detail(@RequestParam(required=true) Integer id){
    	if(id == null|| id == 0){
    		R.error("id is null");
		}
        NideshopAddressEntity nideshopAddress = nideshopAddressService.getById(id);
		if(nideshopAddress == null){
			R.error("未找到对象！");
		}
        NideshopAddressEntityResp resp=new NideshopAddressEntityResp();
        BeanUtils.copyProperties(nideshopAddress, resp);
    	resp.setProvince_name(SystemCache.regionMap.get(nideshopAddress.getProvinceId()).split("---")[0]);
    	resp.setCity_name(SystemCache.regionMap.get(nideshopAddress.getCityId()).split("---")[0]);
    	resp.setDistrict_name(SystemCache.regionMap.get(nideshopAddress.getDistrictId()).split("---")[0]);
    	resp.setFull_region(resp.getProvince_name()+resp.getCity_name()+resp.getDistrict_name());
        return R.ok().put("data", resp);
    }
    /**
     * 信息
     */
    @PostMapping("/delete")
    @ApiOperation(value="获取地址详情")
    public R delete(HttpServletRequest  request,@RequestBody AddressParam addressParam){
    	Integer userid=this.getUserID(request);
    	if(userid==null) {
    		return R.error(10001, "请先登录");
    	}
    	NideshopAddressEntity ent=nideshopAddressService.getById(addressParam.getId());
    	if(ent.getIsDefault()==1) {
    		List<NideshopAddressEntity> ents= nideshopAddressService.queryAddressByUserid(userid);
    		NideshopAddressEntity newdefault=null;
    		for(NideshopAddressEntity en:ents) {
    			if(en.getId()!=ent.getId()) {
    				newdefault=en;
    			}
    		}
    		if(newdefault==null) {
    			return R.error(10001, "请务必保留一个有效的收货地址");
    		}
    		nideshopAddressService.updateDefaultAddress(newdefault.getId(),userid);
    	}
        nideshopAddressService.removeById(addressParam.getId());
        return R.ok("删除成功");
    }
    
}
