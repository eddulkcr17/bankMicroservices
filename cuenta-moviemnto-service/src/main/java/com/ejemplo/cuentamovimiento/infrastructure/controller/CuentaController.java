package com.ejemplo.cuentamovimiento.infrastructure.controller;

import com.ejemplo.cuentamovimiento.application.CuentaService;
import com.ejemplo.cuentamovimiento.domain.Cuenta;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    private final CuentaService service;

    public CuentaController(CuentaService service) {
        this.service = service;
    }

    @PostMapping
    public Cuenta crearCuenta(@RequestBody Cuenta cuenta) {
        return service.crearCuenta(cuenta);
    }

    @GetMapping
    public List<Cuenta> listarCuentas() {
        return service.obtenerCuentas();
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
