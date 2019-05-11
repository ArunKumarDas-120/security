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

	public Map<String, Object> addCategory(final CategoryDto categoryDto) {
		Map<String, Object> result = new HashMap<>();
		try {
			result.put("Data", BeanConverter.mapObject(
					categoryRepo.save(BeanConverter.mapObject(categoryDto, CategoryEntity.class)), CategoryDto.class));
			result.put(TargetConstnats.SCUCCESS, "Category Added..");
		} catch (DataIntegrityViolationException e) {
			result.put(TargetConstnats.ERROR, "Category already exists");
		} catch (Exception e) {
			result.put(TargetConstnats.ERROR, "Fail to save.System issue");
		}
		return result;
	}

	public Map<String, Object> updateCategory(final CategoryDto categoryDto) {
		Map<String, Object> result = new HashMap<>();
		try {
			categoryRepo.save(BeanConverter.mapObject(categoryDto, CategoryEntity.class));
			result.put(TargetConstnats.SCUCCESS, "Category updated");
		} catch (DataIntegrityViolationException e) {
			result.put(TargetConstnats.ERROR, "Category update failed");
		} catch (Exception e) {
			result.put(TargetConstnats.ERROR, "Fail to save. System issue");
		}
		result.put("Data", categoryDto);
		return result;
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
