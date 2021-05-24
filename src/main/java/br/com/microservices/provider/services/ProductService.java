package br.com.microservices.provider.services;

import br.com.microservices.provider.models.Product;
import br.com.microservices.provider.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProductsByState(final String state) {
        return repository.findByStateIgnoringCase(state);
    }

    public List<Product> findByIdIn(final List<Long> ids) {
        return repository.findByIdIn(ids);
    }

}
