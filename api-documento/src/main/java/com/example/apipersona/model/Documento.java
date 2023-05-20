package com.example.apipersona.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Documento {
    private Long id;
    private Integer numero;
    private Persona persona;
}
