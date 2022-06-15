package br.com.ericklara.pianosws.infra.configuration.encoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(PasswordEncoderConfiguration.class);

    @Bean
    public PasswordEncoder encoder(){
        LOGGER.info("[PASSWORD ENCODER CONFIGURATION] Iniciando configurações de criptografia de senha.");
        return new BCryptPasswordEncoder(10);
    }
}
