package br.com.ericklara.pianosws.usecase.onboarding.impl;

import br.com.ericklara.pianosws.domain.dto.NewUserDTO;
import br.com.ericklara.pianosws.domain.entity.User;
import br.com.ericklara.pianosws.domain.exception.BusinessException;
import br.com.ericklara.pianosws.domain.response.DefaultResponse;
import br.com.ericklara.pianosws.infra.repository.UserRepository;
import br.com.ericklara.pianosws.usecase.onboarding.OnboardingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OnboardingServiceImpl implements OnboardingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnboardingServiceImpl.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public OnboardingServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public DefaultResponse<String> newUser(NewUserDTO userDTO) {
        LOGGER.info("[NEW USER] Iniciando novo cadastro");
        if(userRepository.findByEmail(userDTO.getEmail()).isPresent()){
            throw new BusinessException("Esse email já está em uso.", HttpStatus.CONFLICT);
        }

        User dtoToUser = User.Builder
                .create()
                .withCpf(userDTO.getCpf())
                .withEmail(userDTO.getEmail())
                .withName(userDTO.getName())
                .withPassword(passwordEncoder.encode(userDTO.getPassword()))
                .withRegistrationDate(new Date())
                .build();

        userRepository.save(dtoToUser);
        LOGGER.info("[NEW USER] Novo usuário cadastrado! E-MAIL: {}", dtoToUser.getEmail());

        return new DefaultResponse<>(
                true,
                "Usuário criado com Sucesso!"
        );
    }
}
