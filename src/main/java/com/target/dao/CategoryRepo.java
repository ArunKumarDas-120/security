package com.target.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.target.entity.CategoryEntity;

@Repository
public interface CategoryRepo extends JpaRepository< CategoryEntity, Integer> {

	public List<CategoryEntity> findByCatagoryNameContaining(String catagoryName);
}
