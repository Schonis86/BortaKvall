package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .permitAll()
                    .defaultSuccessUrl("/home")
                    .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login")
                    .permitAll()
                    .and()
                .authorizeRequests()
                    .antMatchers( "/webjars/**", "/css/**", "/js/**", "/img/**").permitAll()
                    //.antMatchers("/**", "redirect:/**").hasRole("USER")
                    .anyRequest().authenticated()
                .and()
                    .csrf().disable();



    }


    @Bean
    protected UserDetailsService userDetailsService() {
        User.UserBuilder builder =
                User.withDefaultPasswordEncoder();

        InMemoryUserDetailsManager manager =
                new InMemoryUserDetailsManager();
        manager.createUser(
                builder
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build()
        );

                return manager;
    }


}
