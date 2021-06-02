package br.com.alura.microservices.provider.controllers;

import br.com.alura.microservices.provider.dtos.RequestItemDTO;
import br.com.alura.microservices.provider.models.Request;
import br.com.alura.microservices.provider.services.RequestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/requests")
@AllArgsConstructor
@Slf4j
public class RequestController {

    @Autowired
    private final RequestService requestService;

    @PostMapping
    public ResponseEntity<Request> realizeRequest(
            @RequestBody final List<RequestItemDTO> items,
            UriComponentsBuilder uriBuilder) {
        log.info("Creating request for items: {}", items);
        var request = requestService.realizeRequest(items);
        log.info("Created request {}", request);

        var uri = uriBuilder.path("/requests/{id}").buildAndExpand(request.getId()).toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable final Long id) {
        log.info("Getting request with id: {}", id);
        var request = requestService.getRequestById(id);
        log.info("Getted request: {}", request);
        return ResponseEntity.ok(request);
    }
}
