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

import com.target.dto.CompanyDto;
import com.target.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {

	private final CompanyService companyService;

	public CompanyController(final CompanyService companyService) {
		this.companyService = companyService;
	}

	@PostMapping(value = { "/add" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@PreAuthorize("hasAuthority('Admin')")
	public Map<String, String> addCompany(@ModelAttribute("companyDto") final CompanyDto companyDto) {
		return companyService.addCompany(companyDto);
	}

	@PostMapping(value = { "/update" })
	@PreAuthorize("hasAuthority('Admin')")
	public void updateCompany(@ModelAttribute("company") final CompanyDto companyDto) {
		companyService.updateCompany(companyDto);
	}

	@GetMapping(value = { "/{id}" })
	public void getCompany(@PathVariable("id") final Integer companyid) {
		companyService.getCompany(companyid);
	}

	@GetMapping(value = { "/all" })
	public void getAllCompany() {
		companyService.getAllCompany();
	}

	@PostMapping(value = { "/search" })
	public ModelAndView searchCompany(@ModelAttribute("companyDto") final CompanyDto companyDto) {
		ModelAndView mav = new ModelAndView("companySearchresult");
		mav.addObject("result", companyService.searchCompany(companyDto));
		return mav;
	}
}
