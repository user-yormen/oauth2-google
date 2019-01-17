package com.oauth.oauth.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/fonts/**", "/assets/**", "/images/**",
                "/js2/**", "/login-static/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) //
                .and() //
                .authorizeRequests() //
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated() //
                .mvcMatchers("/dashboard/index", "/dashboard/**").hasRole("USER")
//                .anyRequest().authenticated()
/*                .and()
                .formLogin()
                .loginPage("login")
                .permitAll()*/
                .and()
                .oauth2Login()
                .loginPage("/login");
    }
}
