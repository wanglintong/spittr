package cn.com.zlqf.spittr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.com.zlqf.spittr.dao.SpitterRepository;
import cn.com.zlqf.spittr.entity.Spitter;
import cn.com.zlqf.spittr.service.SpitterService;

@Service
public class SpitterServiceImpl implements SpitterService{
	
	@Autowired
	private SpitterRepository spitterRepository;
	
	@Override
	public void addSpitter(Spitter spitter) {
		spitterRepository.saveAndFlush(spitter);
	}

	@Override
	@Cacheable("spitterCache")
	public Spitter findOne(String id) {
		return spitterRepository.findOne(id);
	}

	@Override
	public Spitter findByUsernameAndPassword(String username, String password) {
		return spitterRepository.findByUsernameAndPassword(username,password);
	}

	@Override
	public Spitter findByUsername(String username) {
		return spitterRepository.findByUsername(username);
	}
}
