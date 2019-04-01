package com.target.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.target.dto.UserDto;
import com.target.service.UserVerificationService;

@Controller
@RequestMapping("/admin")
public class AdimController {

	private final UserVerificationService userService;

	public AdimController(final UserVerificationService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/view", method = { RequestMethod.GET })
	@PreAuthorize("hasAuthority('Admin')")
	public String getAdminPage() {
		return "admin";
	}

	@RequestMapping(value = "/searc/user", method = { RequestMethod.GET })
	@PreAuthorize("hasAuthority('Admin')")
	public ModelAndView searchUsers(@RequestParam(name = "criteria", required = false) String criteria) {
		ModelAndView mav = new ModelAndView("admin");
		mav.addObject("criteria", criteria);
		return mav;
	}

	public String unlockAccount() {
		return "admin";
	}

	public String unblockAccount() {
		return "admin";
	}

	public void addRole() {

	}
}
