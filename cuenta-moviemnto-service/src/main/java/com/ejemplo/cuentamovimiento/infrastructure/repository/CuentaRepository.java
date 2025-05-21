package com.ejemplo.cuentamovimiento.infrastructure.repository;

import com.ejemplo.cuentamovimiento.domain.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, String> {}
