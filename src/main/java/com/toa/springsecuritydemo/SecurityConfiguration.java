package com.toa.springsecuritydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // set your configuration on the auth object

    auth.inMemoryAuthentication().withUser("thetooaung").password("thetooaung").roles("ADMIN").and().withUser("toa2")
        .password("toa2").roles("USER");
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
  
    http.authorizeRequests()
    .antMatchers("/admin").hasRole("ADMIN")
    .antMatchers("/user").hasAnyRole("USER", "ADMIN")
    .antMatchers("/").permitAll()
    .and().formLogin();
  }

  
    
}