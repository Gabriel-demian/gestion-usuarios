package com.bci.gestionusuarios.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Configuration
@AllArgsConstructor
public class SecurityConfigurer {

	private AuthFilter authFilter;

	@Bean
	public SecurityFilterChain configSecurity(HttpSecurity http) throws Exception {
		http.csrf().disable(); // why??

		// enable request to sign-up endpoint without being authenticated
		http.authorizeHttpRequests().requestMatchers(unauthorizedEndpointsMatcher).permitAll()
				// for the rest of the requests authentication must be provided
				.anyRequest().authenticated();
		http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	private static RequestMatcher unauthorizedEndpointsMatcher = new RequestMatcher() {
		@Override
		public boolean matches(HttpServletRequest request) {
			return request.getRequestURI().contains("/sign-up");
		}
	};
}
