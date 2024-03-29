package br.com.alura.microservices.provider.services;

import br.com.alura.microservices.provider.models.Product;
import br.com.alura.microservices.provider.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    private final ProductRepository repository;

    public List<Product> getProductsByState(final String state) {
        return repository.findByStateIgnoringCase(state);
    }

    public List<Product> findByIdIn(final List<Long> ids) {
        return repository.findByIdIn(ids);
    }

}
