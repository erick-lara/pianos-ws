package br.com.ericklara.pianosws.usecase.authentication.impl;

import br.com.ericklara.pianosws.domain.dto.LoginDTO;
import br.com.ericklara.pianosws.domain.entity.Usuario;
import br.com.ericklara.pianosws.domain.exception.BusinessException;
import br.com.ericklara.pianosws.domain.response.DefaultResponse;
import br.com.ericklara.pianosws.domain.response.UsuarioResponse;
import br.com.ericklara.pianosws.infra.utils.Mapper;
import br.com.ericklara.pianosws.infra.repository.UserRepository;
import br.com.ericklara.pianosws.usecase.authentication.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.ericklara.pianosws.infra.enums.ExceptionResponses.USER_NOT_FOUND;

@Service
public class AuthServiceImpl implements AuthService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public DefaultResponse<UsuarioResponse> login(LoginDTO loginDTO) {
        UserDetails user = loadUserByUsername(loginDTO.getEmail().toLowerCase());
        boolean passwordMatch = passwordEncoder.matches(loginDTO.getPassword(), user.getPassword());

        if(passwordMatch) {
            Optional<Usuario> foundUser = userRepository.findByEmail(loginDTO.getEmail().toLowerCase());

            if(foundUser.isPresent()){
                UsernamePasswordAuthenticationToken auth = new
                        UsernamePasswordAuthenticationToken(user,
                        null,
                        user.getAuthorities());

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(auth);

                LOGGER.info("[LOGIN] Iniciando sessão do usuário {}", foundUser.get().getIdUser());
                return new DefaultResponse<>(
                        true,
                        Mapper.userToResponse(foundUser.get())
                );
            }
        }
        throw new BusinessException(USER_NOT_FOUND, HttpStatus.NOT_FOUND);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> foundUser = userRepository.findByEmail(username);
        if(foundUser.isEmpty())
            throw new BusinessException(USER_NOT_FOUND, HttpStatus.NOT_FOUND);

        Usuario usuario = foundUser.get();

        return User
                .builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }
}
