package com.ejemplo.cuentamovimiento.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimiento;

    private LocalDateTime fecha;

    private String tipoMovimiento; // 'Deposito' o 'Retiro'

    private BigDecimal valorMovimiento;

    private BigDecimal saldoInicialCuenta;

    private BigDecimal saldoDisponibleCuenta;

    @ManyToOne
    @JoinColumn(name = "numero_cuenta_id", referencedColumnName = "numeroCuenta")
    private Cuenta cuenta;
}
