package br.com.microservices.provider.controllers;

import br.com.microservices.provider.models.ProviderInfo;
import br.com.microservices.provider.services.InfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
@AllArgsConstructor
public class InfoController {

    @Autowired
    private final InfoService infoService;

    @GetMapping("/{state}")
    public ResponseEntity<ProviderInfo> getInfoByState(@PathVariable String state) {
        return ResponseEntity.ok(infoService.getInfoByState(state));
    }
}
