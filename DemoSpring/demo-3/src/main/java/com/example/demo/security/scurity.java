package com.example.demo.security;

import com.example.demo.servicelmp.LoginServiceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class scurity {
    @Autowired
    LoginServiceImp loginServiceImp;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider());
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers( "/logout").permitAll()
                .antMatchers("/khach-hang/**").access("hasRole('KHACHHANG')")
                .antMatchers("/thong-ke/**","/hang-hoa/**","/xuat-nhap/**","/ho-so/**","/Quan-Ly-Ban/**").access("hasAnyRole('ADMIN','NHANVIEN')")
                .antMatchers("/quan-ly/**").access("hasRole('ADMIN')")
                .and()
                .formLogin()
                .loginPage("/")
                .permitAll()
                .defaultSuccessUrl("/trang-chu")
                .failureUrl("/?success=fail")
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("userName")
                .passwordParameter("passWord")
                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/404");
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(loginServiceImp);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
