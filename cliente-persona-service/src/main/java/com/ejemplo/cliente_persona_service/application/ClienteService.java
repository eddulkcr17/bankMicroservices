package com.ejemplo.cliente_persona_service.application;

import com.ejemplo.cliente_persona_service.domain.Cliente;
import com.ejemplo.cliente_persona_service.infraestructure.repository.ClienteRepository;
import com.ejemplo.cliente_persona_service.infraestructure.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepo;
    private final PersonaRepository personaRepo;

    public ClienteService(ClienteRepository clienteRepo, PersonaRepository personaRepo) {
        this.clienteRepo = clienteRepo;
        this.personaRepo = personaRepo;
    }

    public Cliente crearCliente(Cliente cliente) {
        personaRepo.save(cliente.getPersona());
        return clienteRepo.save(cliente);
    }

    public List<Cliente> obtenerTodos() {
        return clienteRepo.findAll();
    }

    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public void eliminarCliente(String id) {
        clienteRepo.deleteById(id);
    }
}
