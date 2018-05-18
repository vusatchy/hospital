package com.hospital.core.security;

import com.hospital.core.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
	throws Exception {
	auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http
	    .authorizeRequests()
	    .mvcMatchers(HttpMethod.GET , "/meeting/**").hasAnyAuthority(Role.DOCTOR.toString(),Role.PATIENT.toString())
	    .mvcMatchers(HttpMethod.POST , "/meeting/**").hasAuthority(Role.DOCTOR.toString())
	    .mvcMatchers(HttpMethod.PUT , "/meeting/**").hasAuthority(Role.DOCTOR.toString())
	    .mvcMatchers(HttpMethod.DELETE , "/meeting/**").hasAuthority(Role.DOCTOR.toString())
	    .and()
	    .formLogin();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider authProvider
	    = new DaoAuthenticationProvider();
	authProvider.setUserDetailsService(userDetailsService);
	authProvider.setPasswordEncoder(new CustomEncoder());
	return authProvider;
    }

}