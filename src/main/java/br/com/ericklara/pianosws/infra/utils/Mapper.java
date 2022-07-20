package br.com.ericklara.pianosws.infra.utils;

import br.com.ericklara.pianosws.domain.dto.ProductDTO;
import br.com.ericklara.pianosws.domain.entity.Product;
import br.com.ericklara.pianosws.domain.entity.Usuario;
import br.com.ericklara.pianosws.domain.response.UsuarioResponse;

import static br.com.ericklara.pianosws.infra.enums.ExceptionType.NO_INSTANCE_ALLOWED;

public class Mapper {

    private Mapper(){
        throw new AssertionError(NO_INSTANCE_ALLOWED);
    }

    public static UsuarioResponse userToResponse(Usuario usuario) {
        return UsuarioResponse.Builder
                .create()
                .withCpf(usuario.getCpf())
                .withEmail(usuario.getEmail())
                .withName(usuario.getName())
                .withIdUser(usuario.getIdUser())
                .build();
    }

    public static Product productDtoToProduct(ProductDTO productDTO){
        return Product.Builder
                .create()
                .withProductName(productDTO.getProductName())
                .withProductType(productDTO.getProductType())
                .withPrice(productDTO.getPrice())
                .withQuantityInStock(productDTO.getQuantityInStock())
                .build();
    }
}
