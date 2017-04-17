package cn.com.zlqf.spittr.service;

import cn.com.zlqf.spittr.entity.Spitter;

public interface SpitterService {
	void addSpitter(Spitter spitter);
	Spitter findOne(String id);
	Spitter findByUsernameAndPassword(String username,String password);
	Spitter findByUsername(String username);
}
