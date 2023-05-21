package com.example.apipersona.client;

import com.example.apipersona.model.Persona;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "api-persona")
public interface PersonaClient {
    @GetMapping(path = "/personas")
    ResponseEntity<List<Persona>> getAllPersonas ();

    @GetMapping(path = "/personas/{id}")
    ResponseEntity<Persona> getPersonaById (@PathVariable Long id);
}
