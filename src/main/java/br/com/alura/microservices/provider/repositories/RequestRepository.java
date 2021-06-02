package br.com.alura.microservices.provider.repositories;

import br.com.alura.microservices.provider.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}
