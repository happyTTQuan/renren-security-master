package io.renren.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import io.renren.common.utils.SystemCache;
import io.renren.modules.sys.entity.NideshopRegionEntity;
import io.renren.modules.sys.service.NideshopRegionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CacheDataProcess implements ApplicationRunner{
	@Autowired
	private NideshopRegionService nideshopRegionService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		List<NideshopRegionEntity> entis=nideshopRegionService.query().list();
		for(NideshopRegionEntity ent:entis) {
			SystemCache.regionMap.put(ent.getId(), ent.getName()+"---"+ent.getParentId());
		}
		new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
				try {
					SystemCache.userMap.clear();
					Thread.sleep(30*60*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		};
	}

}
