package com.target.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.target.entity.CompanyEntity;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyEntity, Integer> {

	public List<CompanyEntity> findByCompanyNameContaining(String companyName);
}
