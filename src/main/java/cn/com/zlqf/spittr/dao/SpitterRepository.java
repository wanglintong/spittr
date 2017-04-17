package cn.com.zlqf.spittr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import cn.com.zlqf.spittr.entity.Spitter;

public interface SpitterRepository extends JpaRepository<Spitter, String>{
	
	@Query(value="select * from t_spitter where username=?1",nativeQuery=true)
	Spitter findByUsername(String username);
	
	@Query(value="select * from t_spitter where username=?1 and password=?2",nativeQuery=true)
	Spitter findByUsernameAndPassword(String username,String password);
}
