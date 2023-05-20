package com.example.apipersona.controller;

import com.example.apipersona.client.PersonaClient;
import com.example.apipersona.model.Documento;
import com.example.apipersona.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/documentos")
public class PersonaController {
    private final PersonaClient personaClient;

    public PersonaController(PersonaClient personaClient) {
        this.personaClient = personaClient;
    }

    @GetMapping
    public List<Documento> getAllDocumentos() {
        return personaClient.getAllPersonas().stream().map(
                persona -> Documento.builder()
                        .id(persona.getId())
                        .numero(Math.round(Math.random() * 1000000))
                        .persona(persona)
                        .build()).toList();
    }

    @GetMapping("/{id}")
    public Documento getDocumentoById(@PathVariable Long id) {
        Persona persona = personaClient.getPersonaById(id);
        return Documento.builder()
                .id(persona.getId())
                .numero(persona.getNombre().equals("Desconocido") ? 99999 : Math.round(Math.random() * 1000000))
                .persona(persona)
                .build();
    }
}
