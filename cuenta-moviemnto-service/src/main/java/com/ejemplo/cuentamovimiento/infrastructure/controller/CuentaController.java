package com.ejemplo.cuentamovimiento.infrastructure.controller;

import com.ejemplo.cuentamovimiento.application.CuentaService;
import com.ejemplo.cuentamovimiento.domain.Cuenta;
import com.ejemplo.cuentamovimiento.dto.CuentaDTO;
import com.ejemplo.cuentamovimiento.mapper.CuentaMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    private final CuentaService service;
    private final CuentaMapper mapper;

    public CuentaController(CuentaService service, CuentaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public CuentaDTO crear(@RequestBody CuentaDTO dto) {
        Cuenta cuenta = mapper.toEntity(dto);
        Cuenta creada = service.crearCuenta(cuenta);
        return mapper.toDto(creada);
    }

    @GetMapping
    public List<CuentaDTO> listar() {
        return service.obtenerCuentas()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/{numeroCuenta}")
    public Cuenta obtenerPorNumero(@PathVariable String numeroCuenta) {
        return service.obtenerCuenta(numeroCuenta);
    }

    @PutMapping
    public Cuenta actualizarCuenta(@RequestBody Cuenta cuenta) {
        return service.actualizarCuenta(cuenta);
    }

    @DeleteMapping("/{numeroCuenta}")
    public void eliminarCuenta(@PathVariable String numeroCuenta) {
        service.eliminarCuenta(numeroCuenta);
    }
}
