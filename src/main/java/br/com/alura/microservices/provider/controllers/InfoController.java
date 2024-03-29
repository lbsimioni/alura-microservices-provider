package br.com.alura.microservices.provider.controllers;

import br.com.alura.microservices.provider.models.ProviderInfo;
import br.com.alura.microservices.provider.services.InfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
@AllArgsConstructor
@Slf4j
public class InfoController {

    @Autowired
    private final InfoService infoService;

    @GetMapping("/{state}")
    public ResponseEntity<ProviderInfo> getInfoByState(@PathVariable final String state) {
        log.info("Getting info for state: {}", state);
        var info = infoService.getInfoByState(state);
        log.info("Gatted information: {}", info);
        return ResponseEntity.ok(info);
    }
}
