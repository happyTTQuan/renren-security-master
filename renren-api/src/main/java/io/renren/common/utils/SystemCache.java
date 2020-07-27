package io.renren.common.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

import io.renren.modules.sys.entity.NideshopUserEntity;

public class SystemCache {
  public static final ConcurrentHashMap<Integer, String> regionMap=new ConcurrentHashMap<>();
  public static final ConcurrentHashMap<String, NideshopUserEntity> userMap=new ConcurrentHashMap<>();
}
