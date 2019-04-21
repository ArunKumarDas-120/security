package com.target.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.target.entity.RoleEntity;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {

	public List<RoleEntity> findByIsActiveRoleTrue();
}
