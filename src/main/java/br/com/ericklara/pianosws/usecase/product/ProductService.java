package br.com.ericklara.pianosws.usecase.product;

import br.com.ericklara.pianosws.domain.dto.ProductDTO;
import br.com.ericklara.pianosws.domain.entity.Product;
import br.com.ericklara.pianosws.domain.response.DefaultResponse;

public interface ProductService {
    DefaultResponse<Product> registerProduct(ProductDTO product);
}
