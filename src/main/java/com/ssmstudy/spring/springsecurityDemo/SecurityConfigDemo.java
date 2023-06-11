package com.ssmstudy.spring.springsecurityDemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfigDemo extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("javaboy")
                .password("{noop}123")
                .roles("ADMIN")
                .and()
                .withUser("江南一点雨")
                .password("{noop}123")
                .authorities("READ_ONLY");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/user/**")
                .access("hasRole('USER')")
                .antMatchers("/getinfo")
                .hasAuthority("READ_INFO")
                .anyRequest().access("isAuthenticated()")
                .and()
                .formLogin()
                .and()
                .csrf().disable();
    }
}
