package br.com.ericklara.pianosws.infra.configuration.security;

import br.com.ericklara.pianosws.infra.configuration.handler.AccessFailureHandler;
import br.com.ericklara.pianosws.infra.configuration.handler.AuthenticationFailureHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;


@Configuration
public class SecurityConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfiguration.class);
    private static final String[] WHITELIST = {
            "/onboard/**","/authentication/login"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        LOGGER.info("[SECURITY CONFIGURATION] Iniciando configurações de segurança da aplicação.");
        http.csrf().disable().authorizeRequests(
                auth -> auth.antMatchers(WHITELIST)
                        .permitAll()
                        .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults())
                .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPoint())
                    .accessDeniedHandler(accessDeniedHandler());
        return http.build();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        return new AuthenticationFailureHandler();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new AccessFailureHandler();
    }
}