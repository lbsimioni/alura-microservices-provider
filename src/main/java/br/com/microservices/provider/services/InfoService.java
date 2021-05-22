package br.com.microservices.provider.services;

import br.com.microservices.provider.exceptions.ResourceNotFoundException;
import br.com.microservices.provider.models.ProviderInfo;
import br.com.microservices.provider.repositories.InfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InfoService {

    @Autowired
    private final InfoRepository infoRepository;

    public ProviderInfo getInfoByState(String state) {
        return infoRepository.findByState(state).orElseThrow(ResourceNotFoundException::new);
    }
}
