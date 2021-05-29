package br.com.microservices.provider.services;

import br.com.microservices.provider.dtos.RequestItemDTO;
import br.com.microservices.provider.exceptions.ResourceNotFoundException;
import br.com.microservices.provider.models.Product;
import br.com.microservices.provider.models.Request;
import br.com.microservices.provider.models.RequestItem;
import br.com.microservices.provider.models.RequestStatus;
import br.com.microservices.provider.repositories.RequestRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class RequestService {

    @Autowired
    private final RequestRepository repository;

    @Autowired
    private final ProductService productService;

    public Request realizeRequest(final List<RequestItemDTO> items) {
        if (items == null) {
            return null;
        }

        List<RequestItem> requestItems = toRequestItem(items);
        var request = new Request();
        request.setItems(requestItems);
        request.setStatus(RequestStatus.RECEIVED);
        request.setPreparationTime(items.size());
        return repository.save(request);
    }

    public Request getRequestById(final Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.warn("Request not found with id: {}", id);
            throw new ResourceNotFoundException("Request not found");
        });
    }

    private List<RequestItem> toRequestItem(final List<RequestItemDTO> items) {

        List<Long> productIds = items
                .stream()
                .map(RequestItemDTO::getId)
                .collect(Collectors.toList());

        List<Product> requestProducts = productService.findByIdIn(productIds);

        return items
                .stream()
                .map(item -> {
                    var product = requestProducts
                            .stream()
                            .filter(p -> p.getId().equals(item.getId()))
                            .findFirst()
                            .orElseGet(Product::new);

                    var requestItem = new RequestItem();
                    requestItem.setProduct(product);
                    requestItem.setAmount(item.getAmount());
                    return requestItem;
                })
                .collect(Collectors.toList());
    }

}
