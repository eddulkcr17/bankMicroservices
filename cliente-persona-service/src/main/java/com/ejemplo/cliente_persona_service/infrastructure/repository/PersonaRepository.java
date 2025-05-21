package com.ejemplo.cliente_persona_service.infrastructure.repository;

import com.ejemplo.cliente_persona_service.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, String> {}
