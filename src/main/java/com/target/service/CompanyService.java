package com.target.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.target.constants.TargetConstnats;
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

	public Map<String, Object> addCompany(final CompanyDto companyDto) {
		Map<String, Object> result = new HashMap<>();
		try {
			result.put("Data", BeanConverter.mapObject(
					companyRepo.save(BeanConverter.mapObject(companyDto, CompanyEntity.class)), CompanyDto.class));
			result.put(TargetConstnats.SCUCCESS, "Company Added..");
		} catch (DataIntegrityViolationException e) {
			result.put(TargetConstnats.ERROR, "Company already exists");
		} catch (Exception e) {
			result.put(TargetConstnats.ERROR, "Fail to save.System issue");
		}
		return result;
	}

	public Map<String, Object> updateCompany(final CompanyDto companyDto) {
		Map<String, Object> result = new HashMap<>();
		try {
			companyRepo.save(BeanConverter.mapObject(companyDto, CompanyEntity.class));
			result.put(TargetConstnats.SCUCCESS, "Company updated");
		} catch (DataIntegrityViolationException e) {
			result.put(TargetConstnats.ERROR, "Company update failed");
		} catch (Exception e) {
			result.put(TargetConstnats.ERROR, "Fail to save. System issue");
		}
		result.put("Data", companyDto);
		return result;
	}

	public CompanyDto getCompany(final Integer companyid) {
		return companyRepo.findById(companyid).map(c -> BeanConverter.mapObject(c, CompanyDto.class)).orElseGet(() -> {
			CompanyDto comp = new CompanyDto();
			return comp;
		});
	}

	public List<CompanyDto> searchCompany(final CompanyDto companyDto) {
		return companyRepo.findByCompanyNameContaining(companyDto.getCompanyName()).stream()
				.map(c -> BeanConverter.mapObject(c, CompanyDto.class)).collect(Collectors.toList());
	}

	public List<CompanyDto> getAllCompany() {
		return companyRepo.findAll().stream().map(c -> BeanConverter.mapObject(c, CompanyDto.class))
				.collect(Collectors.toList());
	}

}
