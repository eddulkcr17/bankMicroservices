package com.ejemplo.cuentamovimiento.infrastructure.controller;

import com.ejemplo.cuentamovimiento.application.MovimientoService;
import com.ejemplo.cuentamovimiento.domain.Movimiento;
import com.ejemplo.cuentamovimiento.dto.MovimientoDTO;
import com.ejemplo.cuentamovimiento.mapper.MovimientoMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    private final MovimientoService service;
    private final MovimientoMapper mapper;

    public MovimientoController(MovimientoService service, MovimientoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/{numeroCuenta}")
    public MovimientoDTO registrar(@PathVariable String numeroCuenta, @RequestBody MovimientoDTO dto) {
        Movimiento movimiento = mapper.toEntity(dto);
        Movimiento registrado = service.registrarMovimiento(numeroCuenta, movimiento);
        return mapper.toDto(registrado);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<MovimientoDTO> movimientosPorClienteYRango(
            @PathVariable String clienteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta
    ) {
        return service.obtenerMovimientosPorRango(clienteId, desde, hasta)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
