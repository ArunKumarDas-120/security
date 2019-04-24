package com.target.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.target.dto.CategoryDto;
import com.target.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(final CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@ResponseBody
	@PostMapping(value = { "/add" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@PreAuthorize("hasAuthority('Admin')")
	public Map<String, String> addCategory(@ModelAttribute("categoryDto") final CategoryDto categoryDto) {
		return categoryService.addCategory(categoryDto);
	}

	@PostMapping(value = { "/update" })
	@PreAuthorize("hasAuthority('Admin')")
	public void updateCategory(@ModelAttribute("categoryDto") final CategoryDto categoryDto) {
		categoryService.updateCategory(categoryDto);
	}

	@PostMapping(value = { "/search" })
	public ModelAndView search(@ModelAttribute("categoryDto") final CategoryDto categoryDto) {
		ModelAndView mav = new ModelAndView("categorySearchresult");
		mav.addObject("result", categoryService.searchCategory(categoryDto));
		return mav;
	}

	@GetMapping(value = { "/{id}" })
	public void getCategory(@PathVariable("id") final Integer id) {
		categoryService.getCategory(id);
	}

	@GetMapping(value = { "/all" })
	public void getAllCategory() {
		categoryService.getAllCategory();
	}
}
