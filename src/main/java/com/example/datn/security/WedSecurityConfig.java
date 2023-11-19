package com.example.datn.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WedSecurityConfig {
    private final AuthenticationProvider authenticationProvider;
    private final AccounFilter accounFilter;

    @Autowired
    SecurityConfiguration securityConfiguration;

    public WedSecurityConfig(AuthenticationProvider authenticationProvider, AccounFilter accounFilter) {
        this.authenticationProvider = authenticationProvider;
        this.accounFilter = accounFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception{
        return httpSecurity
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("refresh-token").permitAll()
                .antMatchers("/src/**","/images/**","/js/**","webjars/**").permitAll()
                .antMatchers("/apo/giohang/**","/api/phan-hoi/**","api/dia-chi","/api/don-hang/**").hasAuthority("ROLE_CUSTOMER")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(accounFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
