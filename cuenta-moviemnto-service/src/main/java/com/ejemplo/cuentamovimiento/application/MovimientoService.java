package com.ejemplo.cuentamovimiento.application;

import com.ejemplo.cuentamovimiento.domain.Cuenta;
import com.ejemplo.cuentamovimiento.domain.Movimiento;
import com.ejemplo.cuentamovimiento.infrastructure.repository.CuentaRepository;
import com.ejemplo.cuentamovimiento.infrastructure.repository.MovimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimientoService {

    private final MovimientoRepository movimientoRepo;
    private final CuentaRepository cuentaRepo;

    public MovimientoService(MovimientoRepository movimientoRepo, CuentaRepository cuentaRepo) {
        this.movimientoRepo = movimientoRepo;
        this.cuentaRepo = cuentaRepo;
    }

    @Transactional
    public Movimiento registrarMovimiento(String numeroCuenta, Movimiento movimiento) {
        Cuenta cuenta = cuentaRepo.findById(numeroCuenta)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        BigDecimal nuevoSaldo = cuenta.getSaldoInicial().add(movimiento.getValorMovimiento());

        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Saldo no disponible");
        }

        movimiento.setFecha(LocalDateTime.now());
        movimiento.setCuenta(cuenta);
        movimiento.setSaldoInicialCuenta(cuenta.getSaldoInicial());
        movimiento.setSaldoDisponibleCuenta(nuevoSaldo);

        cuenta.setSaldoInicial(nuevoSaldo); // Actualiza saldo

        cuentaRepo.save(cuenta);
        return movimientoRepo.save(movimiento);
    }

    public List<Movimiento> obtenerMovimientosPorRango(String clienteId, LocalDateTime desde, LocalDateTime hasta) {
        return movimientoRepo.findByCuenta_ClienteIdAndFechaBetween(clienteId, desde, hasta);
    }
}
