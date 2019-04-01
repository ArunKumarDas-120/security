package com.target.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.target.dao.UserRepository;
import com.target.dto.UserDto;
import com.target.entity.RoleEntity;
import com.target.util.BeanConverter;

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
			for (RoleEntity role : u.getRoles()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
			org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
					u.getUserName(), u.getPassword(), grantedAuthorities);
			return user;
		}).orElseThrow(() -> new UsernameNotFoundException(username));
	}

	@Transactional
	public List<UserDto> searchUser(final String name) {
		return userRepository.findUser(name).map(u -> {
			return u.stream().map(x -> BeanConverter.mapObject(x, UserDto.class)).collect(Collectors.toList());
		}).orElse(new ArrayList<>());
	}
}
