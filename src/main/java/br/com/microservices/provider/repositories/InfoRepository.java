package br.com.microservices.provider.repositories;

import br.com.microservices.provider.models.ProviderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InfoRepository extends JpaRepository<ProviderInfo, Long> {
    Optional<ProviderInfo> findByState(final String state);
}
