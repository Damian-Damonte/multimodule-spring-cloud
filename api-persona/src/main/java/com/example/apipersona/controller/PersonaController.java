package com.example.apipersona.controller;

import com.example.apipersona.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final List<Persona> personas = List.of(
            Persona.builder().id(1L).nombre("Juan").edad(34).build(),
                Persona.builder().id(2L).nombre("Carlos").edad(57).build(),
                Persona.builder().id(3L).nombre("Martin").edad(26).build()
        );

    @GetMapping
    public List<Persona> getAllPersonas() {
        System.out.println("---- peticion recibida ----");
        return personas;
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        System.out.println("---- peticion recibida ----");
        return personas.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(Persona.builder().id(99999L).nombre("Desconocido").edad(0).build());
    }
}
