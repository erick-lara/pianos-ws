package br.com.ericklara.pianosws.rest.controller.authentication;

import br.com.ericklara.pianosws.domain.dto.LoginDTO;
import br.com.ericklara.pianosws.domain.response.DefaultResponse;
import br.com.ericklara.pianosws.domain.response.UsuarioResponse;
import br.com.ericklara.pianosws.usecase.authentication.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@SuppressWarnings("unused")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<DefaultResponse<UsuarioResponse>> login(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(authService.login(loginDTO));
    }
}
