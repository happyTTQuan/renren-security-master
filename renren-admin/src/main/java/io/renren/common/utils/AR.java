package io.renren.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class AR extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public AR() {
		put("code", 0);
		put("msg", "success");
	}
	public static AR error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static AR error(String msg) {
		return error(500, msg);
	}
	
	public static AR error(int code, String msg) {
		AR r = new AR();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static AR ok(String msg) {
		AR r = new AR();
		r.put("msg", msg);
		return r;
	}
	
	public static AR ok(Map<String, Object> map) {
	    AR r= new AR();
		r.putAll(map);
		return r;
	}
	
	public static AR ok() {
		return new AR();
	}

	@Override
	public AR put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
