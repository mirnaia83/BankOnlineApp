package com.example.BankOnlineApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConf) throws Exception {
        return authConf.getAuthenticationManager();
    }




    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();

        httpSecurity.authorizeRequests()
                .mvcMatchers(HttpMethod.POST, "/create/{accountType}/{id}").hasRole("ADMIN").
                mvcMatchers(HttpMethod.DELETE, "/delete/account").hasRole("ADMIN").
                mvcMatchers(HttpMethod.GET, "/accounts/").hasRole("ACCOUNT_HOLDER").
                mvcMatchers(HttpMethod.GET, "/account/{id}").hasRole("ACCOUNT_HOLDER").
                mvcMatchers(HttpMethod.PATCH, "/modifyBalance/{amount}").hasRole("ADMIN").
                mvcMatchers(HttpMethod.POST, "/newThirdParty/").hasRole("ADMIN").
                mvcMatchers(HttpMethod.GET, "/ThirdParty/send/").hasRole("THIRD_PARTY");

        httpSecurity.csrf().disable();

        return httpSecurity.build();

    }

}
