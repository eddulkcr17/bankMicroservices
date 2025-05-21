package com.ejemplo.cliente_persona_service.infrastructure.controller;

import com.ejemplo.cliente_persona_service.application.ClienteService;
import com.ejemplo.cliente_persona_service.domain.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return service.crearCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.obtenerTodos();
    }

    @PutMapping
    public Cliente actualizar(@RequestBody Cliente cliente) {
        return service.actualizarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.eliminarCliente(id);
    }
}
