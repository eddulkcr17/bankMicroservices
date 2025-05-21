package com.ejemplo.cliente_persona_service.application;

import com.ejemplo.cliente_persona_service.domain.Cliente;
import com.ejemplo.cliente_persona_service.infrastructure.messaging.ClienteCreadoEvent;
import com.ejemplo.cliente_persona_service.infrastructure.messaging.RabbitMQProducer;
import com.ejemplo.cliente_persona_service.infrastructure.repository.ClienteRepository;
import com.ejemplo.cliente_persona_service.infrastructure.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepo;
    private final PersonaRepository personaRepo;
    private final RabbitMQProducer producer;

    public ClienteService(ClienteRepository clienteRepo, PersonaRepository personaRepo, RabbitMQProducer producer) {
        this.clienteRepo = clienteRepo;
        this.personaRepo = personaRepo;
        this.producer = producer;
    }

    public Cliente crearCliente(Cliente cliente) {
        personaRepo.save(cliente.getPersona());
        Cliente creado = clienteRepo.save(cliente);

        ClienteCreadoEvent event = new ClienteCreadoEvent(
                creado.getClienteId(),
                creado.getPersona().getIdentificacion(),
                creado.getPersona().getNombre(),
                creado.getPersona().getTelefono()
        );
        producer.enviarClienteCreado(event);

        return creado;
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
