package com.target.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.target.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	public Optional<UserEntity> findByUserName(final String userName);

	@Query(value = "Select u from UserEntity u where u.userName = :name")
	public Optional<List<UserEntity>> findUser(@Param("name") String name);
}
