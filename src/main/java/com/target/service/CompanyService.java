package com.target.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.target.dao.CompanyRepo;
import com.target.dto.CompanyDto;
import com.target.entity.CompanyEntity;
import com.target.util.BeanConverter;

@Service
public class CompanyService {

	private final CompanyRepo companyRepo;

	public CompanyService(final CompanyRepo companyRepo) {
		this.companyRepo = companyRepo;
	}

	@Transactional
	public void addCompany(final CompanyDto companyDto) {
		companyRepo.save(BeanConverter.mapObject(companyDto, CompanyEntity.class));
	}

	@Transactional
	public void updateCompany(final CompanyDto companyDto) {
		companyRepo.save(BeanConverter.mapObject(companyDto, CompanyEntity.class));
	}

	public CompanyDto getCompany(final Integer companyid) {
		return companyRepo.findById(companyid).map(c -> BeanConverter.mapObject(c, CompanyDto.class)).orElseGet(() -> {
			CompanyDto comp = new CompanyDto();
			return comp;
		});
	}

	public List<CompanyDto> getAllCompany() {
		return companyRepo.findAll().stream().map(c -> BeanConverter.mapObject(c, CompanyDto.class))
				.collect(Collectors.toList());
	}

}
