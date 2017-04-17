package cn.com.zlqf.spittr.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.zlqf.spittr.entity.Spitter;
import cn.com.zlqf.spittr.service.SpitterService;

public class ShiroRealm2 extends AuthorizingRealm{

	@Autowired
	private SpitterService spitterService;
	
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//1.从PrincipalCollection中来获取登录用户的信息
		
		//2.利用登录用户的信息来查询权限信息
		
		//3.创建SimpleAuthorizationInfo,并设置其reles
		
		return null;
	}
	
	
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("realm2....");
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		Spitter spitter = spitterService.findByUsername(username);
		if(spitter==null) {
			throw new UnknownAccountException();
		}
		//盐
		ByteSource salt = ByteSource.Util.bytes(spitter.getUsername());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(spitter,spitter.getPassword(),salt,getName());
		
		return info;
	}

}
