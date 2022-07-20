package br.com.ericklara.pianosws.rest.controller.product;

import br.com.ericklara.pianosws.domain.dto.ProductDTO;
import br.com.ericklara.pianosws.domain.entity.Product;
import br.com.ericklara.pianosws.domain.response.DefaultResponse;
import br.com.ericklara.pianosws.usecase.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new-product")
    public ResponseEntity<DefaultResponse<Product>> newProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.registerProduct(productDTO));
    }
}
