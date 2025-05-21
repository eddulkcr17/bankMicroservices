package com.ejemplo.cuentamovimiento.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MovimientoDTO {
    private Long idMovimiento;
    private LocalDateTime fecha;
    private String tipoMovimiento;
    private BigDecimal valorMovimiento;
    private BigDecimal saldoInicialCuenta;
    private BigDecimal saldoDisponibleCuenta;
    private String numeroCuenta;
}
