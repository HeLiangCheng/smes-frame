package com.hlc.styd.smes.oauth2.service;

import com.hlc.styd.smes.oauth2.ldap.LdapRemoteCall;
import com.hlc.styd.smes.oauth2.model.OURegisterResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * 用户信息验证接口
 */
public class MyUserDetailsService implements UserDetailsService {

	//从Ldap服务器中获取用户信息
	//@Autowired
	//private LdapPersonService ldapPersonService;

	//获取人员权限信息
	//@Autowired
	//private URoleService rRoleService;

	/**
	 * 根据用户名称获取人员详细信息
	 *
	 * @param userName
	 * @return
	 * @throws UsernameNotFoundException
	 */
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {

		User userDetails = null;
		try {
			//List<Person> persons = ldapPersonService.getPerson(userName, "");
			OURegisterResponse request = LdapRemoteCall.remoteCallAccount(userName);
			if (request.getUser_name() == null) {
				throw new Exception("帐号：" + userName + " 不存在！");
			}
			System.out.println(request);
			Collection<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(request.getLogin_name());
			boolean enables = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			userDetails = new User(request.getLogin_name(), request.getUser_password(), enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
		} catch (Exception e) {
			//log.error(e.getMessage());
			e.printStackTrace();
		}
		return userDetails;
	}

	/**
	 * 根据用户获取该用户拥有的角色
	 *
	 * @param userid
	 * @return
	 */
	private Set<GrantedAuthority> getGrantedAuthorities(String userid) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
//		URole uRole=rRoleService.getURole(userid);
//        if(uRole != null) {
//        	for(String role : uRole.getRoleNames()) {  
//        		grantedAuthorities.add(new SimpleGrantedAuthority(role));
//            }  
//        }
		return grantedAuthorities;
	}

}
