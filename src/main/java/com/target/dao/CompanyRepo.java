package com.target.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.target.entity.CompanyEntity;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyEntity, Integer> {

}
