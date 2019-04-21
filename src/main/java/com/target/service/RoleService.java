package com.target.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.target.dao.RoleRepo;
import com.target.dto.RoleDto;
import com.target.util.BeanConverter;

@Service
public class RoleService {

	private final RoleRepo roleRepo;

	public RoleService(final RoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}

	public List<RoleDto> getRole() {
		return roleRepo.findByIsActiveRoleTrue().stream().map(e -> BeanConverter.mapObject(e, RoleDto.class))
				.collect(Collectors.toList());
	}
}
