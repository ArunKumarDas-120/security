package com.target.controller;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.target.constants.TargetConstnats;
import com.target.dto.UserDto;
import com.target.service.UserVerificationService;

@Controller
public class AccessController {

	private final UserVerificationService userService;
	private final PasswordEncoder passWordEncoder;

	public AccessController(final UserVerificationService userService, final PasswordEncoder passWordEncoder) {
		this.userService = userService;
		this.passWordEncoder = passWordEncoder;
	}

	@RequestMapping(value = { "/target" }, method = { RequestMethod.GET })
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = { "/login" }, method = { RequestMethod.GET })
	public String login() {
		return "login";
	}

	@RequestMapping(value = { "/registrationUI" }, method = { RequestMethod.GET })
	public String registrationUI() {
		return "register";
	}
	
	@RequestMapping(value = { "/inventory" }, method = { RequestMethod.POST })
	public String manageInventoryUI() {
		return "manageinventory";
	}

	@PostMapping(value = { "/register" })
	public ModelAndView registerUser(@ModelAttribute("userDto") final UserDto userDto, HttpServletRequest request) {
		userDto.setPassword(passWordEncoder.encode(userDto.getPassword()));
		Map<String, String> result = userService.registerUser(userDto);
		ModelAndView mav = new ModelAndView();
		return Optional.ofNullable(result.get(TargetConstnats.ERROR)).map(m -> {
			mav.addObject("msg", m);
			mav.addObject(userDto);
			mav.setViewName("register");
			return mav;
		}).orElseGet(() -> {
			mav.setViewName("redirect:/login");
			return mav;
		});
	}
}
