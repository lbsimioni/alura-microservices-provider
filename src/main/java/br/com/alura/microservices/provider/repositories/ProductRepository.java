package br.com.alura.microservices.provider.repositories;

import br.com.alura.microservices.provider.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByStateIgnoringCase(final String state);
    List<Product> findByIdIn(final List<Long> ids);
}
