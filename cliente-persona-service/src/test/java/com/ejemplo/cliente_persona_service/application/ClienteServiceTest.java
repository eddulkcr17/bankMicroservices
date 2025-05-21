package com.ejemplo.cliente_persona_service.application;

import com.ejemplo.cliente_persona_service.domain.Cliente;
import com.ejemplo.cliente_persona_service.domain.Persona;
import com.ejemplo.cliente_persona_service.infrastructure.messaging.RabbitMQProducer;
import com.ejemplo.cliente_persona_service.infrastructure.repository.ClienteRepository;
import com.ejemplo.cliente_persona_service.infrastructure.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private PersonaRepository personaRepository;

    @Mock
    private RabbitMQProducer producer;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearCliente_debeGuardarClienteYEnviarEvento() {
        // Arrange
        Persona persona = new Persona();
        persona.setIdentificacion("123");
        persona.setNombre("Test");

        Cliente cliente = new Cliente();
        cliente.setClienteId("CLI001");
        cliente.setPersona(persona);

        when(personaRepository.save(any())).thenReturn(persona);
        when(clienteRepository.save(any())).thenReturn(cliente);

        // Act
        Cliente resultado = clienteService.crearCliente(cliente);

        // Assert
        assertNotNull(resultado);
        assertEquals("CLI001", resultado.getClienteId());
        verify(personaRepository).save(persona);
        verify(clienteRepository).save(cliente);
        verify(producer).enviarClienteCreado(any());
    }
}
