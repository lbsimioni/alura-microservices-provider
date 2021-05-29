package br.com.microservices.provider.services;

import br.com.microservices.provider.exceptions.ResourceNotFoundException;
import br.com.microservices.provider.models.ProviderInfo;
import br.com.microservices.provider.repositories.InfoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class InfoService {

    @Autowired
    private final InfoRepository infoRepository;

    public ProviderInfo getInfoByState(final String state) {
        return infoRepository.findByState(state).orElseThrow(() -> {
            log.warn("Info not found for state: {}", state);
            throw new ResourceNotFoundException("Info not found");
        });
    }
}
