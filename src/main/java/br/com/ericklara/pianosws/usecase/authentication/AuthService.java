package br.com.ericklara.pianosws.usecase.authentication;

import br.com.ericklara.pianosws.domain.dto.LoginDTO;
import br.com.ericklara.pianosws.domain.response.DefaultResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthService extends UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    DefaultResponse login(LoginDTO loginDTO);

}
