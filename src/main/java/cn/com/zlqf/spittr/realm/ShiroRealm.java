package cn.com.zlqf.spittr.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.zlqf.spittr.entity.Spitter;
import cn.com.zlqf.spittr.service.SpitterService;

public class ShiroRealm extends AuthorizingRealm{

	@Autowired
	private SpitterService spitterService;
	
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Spitter spitter = (Spitter) principals.getPrimaryPrincipal();
		String roles = spitter.getRoles();
		Set<String> roleSet = new HashSet<>();
		roleSet.add("user");
		if(roles.contains("admin")) {
			roleSet.add("admin");
		}
		System.out.println(roles);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleSet);
		return info;
	}
	
	
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
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
