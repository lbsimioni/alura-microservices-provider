package br.com.microservices.provider.controllers;

import br.com.microservices.provider.dtos.RequestItemDTO;
import br.com.microservices.provider.models.Request;
import br.com.microservices.provider.services.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/requests")
@AllArgsConstructor
public class RequestController {

    @Autowired
    private final RequestService requestService;

    @PostMapping
    public ResponseEntity<Request> realizeRequest(@RequestBody List<RequestItemDTO> items) {
        return ResponseEntity.ok(requestService.realizeRequest(items));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable final Long id) {
        return ResponseEntity.ok(requestService.getRequestById(id));
    }
}
