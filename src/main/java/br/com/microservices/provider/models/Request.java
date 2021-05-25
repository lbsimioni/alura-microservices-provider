package br.com.microservices.provider.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer preparationTIme;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "requestId")
    private List<RequestItem> items;
}
