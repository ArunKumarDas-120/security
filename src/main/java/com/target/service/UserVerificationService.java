package com.target.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.target.dao.UserRepository;
import com.target.entity.Role;

@Service
public class UserVerificationService implements UserDetailsService {

	private final UserRepository userRepository;

	public UserVerificationService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return userRepository.findByUserName(username).map(u -> {
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
			for (Role role : u.getRoles()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
			org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
					u.getUserName(), u.getPassword(), grantedAuthorities);
			return user;
		}).orElseThrow(() -> new UsernameNotFoundException(username));
	}

}
