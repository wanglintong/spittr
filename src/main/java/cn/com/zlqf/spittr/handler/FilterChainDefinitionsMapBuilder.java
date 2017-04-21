package cn.com.zlqf.spittr.handler;

import java.util.LinkedHashMap;

public class FilterChainDefinitionsMapBuilder {
	public LinkedHashMap<String,String> buildFilterChainDefinitionMap() {
		LinkedHashMap<String,String> map = new LinkedHashMap<>();
		//从数据库中查询...
		map.put("/resources/**", "anon");
		map.put("/spitter.service", "anon");
		map.put("/", "anon");
		map.put("/login", "anon");
		map.put("/logout", "logout");
		map.put("/**", "authc");
		return map;
	}
}
