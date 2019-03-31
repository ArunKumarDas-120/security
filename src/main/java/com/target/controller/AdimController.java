package com.target.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdimController {

	@RequestMapping(value = "/view", method = { RequestMethod.GET })
	@PreAuthorize("hasAuthority('Admin')")
	public String getAdminPage() {
		return "admin";
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
