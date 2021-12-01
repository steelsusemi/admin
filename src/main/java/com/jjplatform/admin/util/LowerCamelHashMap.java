package com.jjplatform.admin.util;

import java.util.HashMap;

import com.google.common.base.CaseFormat;

@SuppressWarnings("serial")
public class LowerCamelHashMap extends HashMap<String, Object> {
	public Object put(String key, Object value) {
	    return super.put(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, key), value);
	  }
}
