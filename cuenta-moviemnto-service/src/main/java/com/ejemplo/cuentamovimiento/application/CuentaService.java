package com.ejemplo.cuentamovimiento.application;

import com.ejemplo.cuentamovimiento.domain.Cuenta;
import com.ejemplo.cuentamovimiento.infrastructure.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {

    private final CuentaRepository repo;

    public CuentaService(CuentaRepository repo) {
        this.repo = repo;
    }

    public Cuenta crearCuenta(Cuenta cuenta) {
        return repo.save(cuenta);
    }

    public List<Cuenta> obtenerCuentas() {
        return repo.findAll();
    }

    public Cuenta obtenerCuenta(String numeroCuenta) {
        return repo.findById(numeroCuenta)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }

    public Cuenta actualizarCuenta(Cuenta cuenta) {
        return repo.save(cuenta);
    }

    public void eliminarCuenta(String numeroCuenta) {
        repo.deleteById(numeroCuenta);
    }
}
