package com.target.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.target.constants.TargetConstnats;
import com.target.dao.RoleRepo;
import com.target.dao.UserRepository;
import com.target.dto.UserDto;
import com.target.entity.RoleEntity;
import com.target.entity.UserEntity;
import com.target.util.BeanConverter;

@Service
public class UserVerificationService implements UserDetailsService {

	private final UserRepository userRepository;
	private final RoleRepo roleRepo;

	public UserVerificationService(final UserRepository userRepository, final RoleRepo roleRepo) {
		this.userRepository = userRepository;
		this.roleRepo = roleRepo;
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

	public Map<String, String> registerUser(final UserDto userDto) {
		Map<String, String> result = new HashMap<>();
		return userRepository.findByUserName(userDto.getUserName()).map(e -> {
			result.put("Error", "Please select differnt username");
			return result;
		}).orElseGet(() -> {
			try {
				UserEntity entity = BeanConverter.mapObject(userDto, UserEntity.class);
				entity.setEnabled(true);
				Set<RoleEntity> role = new HashSet<>();
				roleRepo.findByIsActiveRoleTrue().stream().filter(r -> r.getRoleName().equals("User")).findFirst()
						.ifPresent(ro -> role.add(ro));
				userRepository.saveAndFlush(entity);
				result.put(TargetConstnats.SCUCCESS, "Registered Successfuly");
			} catch (Exception e) {
				result.put(TargetConstnats.ERROR, "system is not able to register now. Please try after some time");
			}
			return result;
		});

	}
}
