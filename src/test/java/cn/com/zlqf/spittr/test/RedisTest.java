package cn.com.zlqf.spittr.test;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.zlqf.spittr.config.RootConfig;
import cn.com.zlqf.spittr.entity.Spitter;
import cn.com.zlqf.spittr.service.SpitterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
public class RedisTest {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private SpitterService spitterService;
	
	
	@Test
	public void testOpsForValueSet() {
		Spitter spitter = new Spitter("001","越","胡","hy","123456");
		redisTemplate.opsForValue().set("user", spitter);
	}
	
	@Test
	public void testOpsForValueGet() {
		Spitter spitter = spitterService.findOne("1");
		System.out.println(spitter);
	}
	
	@Test
	public void testOpsForList() {
		redisTemplate.opsForList().rightPush("userList", new Spitter("001","越","胡","hy","123456"));
		redisTemplate.opsForList().rightPush("userList", new Spitter("002","麟童","王","wlt","123456"));
		redisTemplate.opsForList().leftPush("userList", new Spitter("003","帅","王","ws","123456"));
		List userList = redisTemplate.opsForList().range("userList", 0, 3);
		System.out.println(userList);
	}
	
	@Test
	public void testOpsForSet() {
		/*redisTemplate.opsForSet().add("userSet1", new Spitter("001","越","胡","hy","123456"));
		redisTemplate.opsForSet().add("userSet1", new Spitter("002","麟童","王","wlt","123456"));
		redisTemplate.opsForSet().add("userSet2", new Spitter("001","越","胡","hy","123456"));
		redisTemplate.opsForSet().add("userSet2", new Spitter("003","帅","王","ws","123456"));
		Set<Object> difference = redisTemplate.opsForSet().difference("userSet1", "userSet2");
		Set<Object> union = redisTemplate.opsForSet().union("userSet1", "userSet2");
		Set<Object> intersect = redisTemplate.opsForSet().intersect("userSet1","userSet2");
		System.out.println(difference);
		System.out.println(union);
		System.out.println(intersect);*/
		Set<Object> members = redisTemplate.opsForSet().members("userSet1");
		System.out.println(members);
	}
}
