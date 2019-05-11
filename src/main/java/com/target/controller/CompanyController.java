package com.target.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.target.constants.TargetConstnats;
import com.target.dto.CompanyDto;
import com.target.dto.ResponseData;
import com.target.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {

	private final CompanyService companyService;

	public CompanyController(final CompanyService companyService) {
		this.companyService = companyService;
	}

	@ResponseBody
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping(value = { "/add" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseData<CompanyDto> addCompany(@ModelAttribute("companyDto") final CompanyDto companyDto) {
		Map<String, Object> result = companyService.addCompany(companyDto);
		ResponseData<CompanyDto> responseData = extractStatus(result);
		result.computeIfPresent("Data", (K, V) -> {
			responseData.setData((CompanyDto) V);
			return V;
		});
		return responseData;
	}

	@PostMapping(value = { "/update" })
	@PreAuthorize("hasAuthority('Admin')")
	public ModelAndView updateCompany(@ModelAttribute("companyDto") final CompanyDto companyDto) {
		Map<String, Object> result = companyService.updateCompany(companyDto);
		ModelAndView mav = new ModelAndView("companySearchresult");
		ResponseData<CompanyDto> responseData = extractStatus(result);
		result.computeIfPresent("Data", (K, V) -> {
			List<CompanyDto> data = new ArrayList<>();
			data.add((CompanyDto) V);
			responseData.setListOfData(data);
			return V;
		});
		mav.addObject("result", responseData);
		return mav;
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
		ResponseData<CompanyDto> responseData = new ResponseData<>();
		responseData.setStaus(TargetConstnats.SCUCCESS);
		responseData.setListOfData(companyService.searchCompany(companyDto));
		mav.addObject("result", responseData);
		return mav;
	}

	private ResponseData<CompanyDto> extractStatus(Map<String, Object> payload) {
		return new ResponseData<>(
				payload.containsKey(TargetConstnats.SCUCCESS) ? TargetConstnats.SCUCCESS : TargetConstnats.ERROR,
				(payload.containsKey(TargetConstnats.SCUCCESS) ? (String) payload.get(TargetConstnats.SCUCCESS)
						: (String) payload.get(TargetConstnats.ERROR)));
	}
}
