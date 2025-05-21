package com.ejemplo.cliente_persona_service.infrastructure.repository;

import com.ejemplo.cliente_persona_service.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {}
