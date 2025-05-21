package com.ejemplo.cuentamovimiento.infrastructure.controller;

import com.ejemplo.cuentamovimiento.application.MovimientoService;
import com.ejemplo.cuentamovimiento.domain.Movimiento;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    private final MovimientoService service;

    public MovimientoController(MovimientoService service) {
        this.service = service;
    }

    @PostMapping("/{numeroCuenta}")
    public Movimiento registrar(@PathVariable String numeroCuenta, @RequestBody Movimiento movimiento) {
        return service.registrarMovimiento(numeroCuenta, movimiento);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Movimiento> movimientosPorClienteYRango(
            @PathVariable String clienteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta
    ) {
        return service.obtenerMovimientosPorRango(clienteId, desde, hasta);
    }
}
