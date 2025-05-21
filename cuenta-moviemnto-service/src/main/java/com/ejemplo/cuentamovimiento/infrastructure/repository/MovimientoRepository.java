package com.ejemplo.cuentamovimiento.infrastructure.repository;

import com.ejemplo.cuentamovimiento.domain.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByCuenta_ClienteIdAndFechaBetween(String clienteId, LocalDateTime start, LocalDateTime end);
}
