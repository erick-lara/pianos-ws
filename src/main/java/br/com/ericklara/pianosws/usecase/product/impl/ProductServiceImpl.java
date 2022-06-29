package br.com.ericklara.pianosws.usecase.product.impl;

import br.com.ericklara.pianosws.domain.dto.ProductDTO;
import br.com.ericklara.pianosws.domain.entity.Product;
import br.com.ericklara.pianosws.domain.response.DefaultResponse;
import br.com.ericklara.pianosws.infra.repository.ProductRepository;
import br.com.ericklara.pianosws.infra.utils.Mapper;
import br.com.ericklara.pianosws.usecase.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public DefaultResponse<Product> registerProduct(ProductDTO product) {
        LOGGER.info("[REGISTER PRODUCT] Registrando novo produto na base.");
        Product convertedProduct = Mapper.productDtoToProduct(product);
        productRepository.save(convertedProduct);
        return new DefaultResponse<>(
                true,
                convertedProduct
        );
    }
}
