package br.com.ericklara.pianosws.infra.configuration.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfiguration.class);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        LOGGER.info("[SECURITY CONFIGURATION] Iniciando configurações de segurança da aplicação.");
        http.csrf().disable().authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .httpBasic(withDefaults());
        return http.build();
    }

}

