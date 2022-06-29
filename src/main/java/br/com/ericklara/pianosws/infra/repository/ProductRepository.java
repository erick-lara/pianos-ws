package br.com.ericklara.pianosws.infra.repository;

import br.com.ericklara.pianosws.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
