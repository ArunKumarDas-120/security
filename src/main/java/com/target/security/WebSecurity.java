package com.target.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passWordEncoder;
	private final DataBaseAuthenticationProvider dbAuthenticationProvider;

	public WebSecurity(final UserDetailsService userDetailsService, final PasswordEncoder passWordEncoder,
			final DataBaseAuthenticationProvider dbAuthenticationProvider) {
		this.userDetailsService = userDetailsService;
		this.passWordEncoder = passWordEncoder;
		this.dbAuthenticationProvider = dbAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passWordEncoder);
		auth.authenticationProvider(dbAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/","/resources/**", "/registrationUI/**", "/register/**").permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/login").usernameParameter("userName")
				.passwordParameter("password").permitAll();

	}

}
