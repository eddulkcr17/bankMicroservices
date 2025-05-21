package com.ejemplo.cliente_persona_service.infrastructure.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarClienteCreado(ClienteCreadoEvent event) {
        rabbitTemplate.convertAndSend("cliente.exchange", "cliente.creado", event);
    }
}
