package br.com.ericklara.pianosws.infra.mapper;

import br.com.ericklara.pianosws.domain.entity.Usuario;
import br.com.ericklara.pianosws.domain.response.UsuarioResponse;

public class UsuarioMapper {

    public UsuarioResponse userToResponse(Usuario usuario) {
        return UsuarioResponse.Builder
                .create()
                .withCpf(usuario.getCpf())
                .withEmail(usuario.getEmail())
                .withName(usuario.getName())
                .withIdUser(usuario.getIdUser())
                .build();
    }
}
