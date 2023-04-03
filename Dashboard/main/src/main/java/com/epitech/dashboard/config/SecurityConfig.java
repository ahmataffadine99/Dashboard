package com.epitech.dashboard.config;


import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;


@Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Autowired
        private JwtTokens jwtTokens;
    /*
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("fred").password("{noop}fred").roles("USER")
                    .and()
                    .withUser("admin").password("{noop}admin").roles("USER","ADMIN");
            {bcrypt} for BCryptPasswordEncoder,
            {noop} for NoOpPasswordEncoder,
            {pbkdf2} for Pbkdf2PasswordEncoder,
            {scrypt} for SCryptPasswordEncoder,
            {sha256} for StandardPasswordEncoder.
        }
    */

        @Bean
        @Override
        protected UserDetailsService userDetailsService() {
            /**
             UserDetails fred = User.builder()
             .username("fred").password("{noop}fred").roles("USER").build();
             UserDetails yoh = User.builder()
             .username("yoh").password("{noop}yoh").roles("USER").build();
             return new InMemoryUserDetailsManager(fred,yoh);
             **/
            return new CustomUserDetailsService();
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .addFilter(new JwtAuthenticationFilter(authenticationManager(),jwtTokens))
                    .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtTokens))
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST,"/dashboard/user").permitAll()
                    .antMatchers(HttpMethod.POST,"/dashboard/login").permitAll()
                    .anyRequest().permitAll()
                    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        }

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }


       @Bean
        public SecretKey getSecretKey() {
            return Keys.secretKeyFor(SignatureAlgorithm.HS256);
        }



    }
