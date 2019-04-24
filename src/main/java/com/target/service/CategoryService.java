package com.target.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.target.constants.TargetConstnats;
import com.target.dao.CategoryRepo;
import com.target.dto.CategoryDto;
import com.target.entity.CategoryEntity;
import com.target.util.BeanConverter;

@Service
public class CategoryService {

	private final CategoryRepo categoryRepo;

	public CategoryService(final CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	public Map<String, String> addCategory(final CategoryDto categoryDto) {
		Map<String, String> result = new HashMap<>();
		try {
			categoryRepo.save(BeanConverter.mapObject(categoryDto, CategoryEntity.class));
			result.put(TargetConstnats.SCUCCESS, "Category Added..");
		} catch (DataIntegrityViolationException e) {
			result.put(TargetConstnats.ERROR, "Category already exists");
		} catch (Exception e) {
			result.put(TargetConstnats.ERROR, "Fail to save. System issue");
		}
		return result;
	}

	public void updateCategory(final CategoryDto categoryDto) {
		categoryRepo.save(BeanConverter.mapObject(categoryDto, CategoryEntity.class));
	}

	public CategoryDto getCategory(int id) {
		return categoryRepo.findById(id).map(cat -> BeanConverter.mapObject(cat, CategoryDto.class))
				.orElseGet(() -> new CategoryDto());
	}

	public List<CategoryDto> searchCategory(final CategoryDto categoryDto) {
		return categoryRepo.findByCatagoryNameContaining(categoryDto.getCatagoryName()).stream()
				.map(cat -> BeanConverter.mapObject(cat, CategoryDto.class)).collect(Collectors.toList());
	}
	
	public List<CategoryDto> getAllCategory() {
		return categoryRepo.findAll().stream().map(cat -> BeanConverter.mapObject(cat, CategoryDto.class))
				.collect(Collectors.toList());
	}
}
