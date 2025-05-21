package com.ejemplo.cliente_persona_service.infrastructure.controller;

import com.ejemplo.cliente_persona_service.application.ClienteService;
import com.ejemplo.cliente_persona_service.domain.Cliente;
import com.ejemplo.cliente_persona_service.dto.ClienteDTO;
import com.ejemplo.cliente_persona_service.dto.PersonaDTO;
import com.ejemplo.cliente_persona_service.mapper.ClienteMapper;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;
    private final ClienteMapper mapper;

    public ClienteController(ClienteService service, ClienteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ClienteDTO crear(@Valid @RequestBody ClienteDTO dto) {
        Cliente cliente = mapper.toEntity(dto);
        Cliente creado = service.crearCliente(cliente);
        return mapper.toDto(creado);
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
