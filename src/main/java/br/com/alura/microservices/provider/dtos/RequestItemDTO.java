package br.com.alura.microservices.provider.dtos;

import lombok.Data;

@Data
public class RequestItemDTO {
    private Long id;
    private int amount;
}
