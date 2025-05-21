package com.ejemplo.cuentamovimiento.infrastructure.messaging;

import com.ejemplo.cuentamovimiento.application.CuentaService;
import com.ejemplo.cuentamovimiento.domain.Cuenta;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RabbitMQConsumer {

    private final CuentaService cuentaService;

    public RabbitMQConsumer(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @RabbitListener(queues = "cliente.creado.queue")
    public void recibirClienteCreado(ClienteCreadoEvent event) {
        System.out.println("📩 Cliente recibido desde RabbitMQ: " + event.getNombre());

        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("AUTO-" + event.getClienteId());
        cuenta.setTipoCuenta("Corriente");
        cuenta.setSaldoInicial(BigDecimal.ZERO);
        cuenta.setEstado(true);
        cuenta.setClienteId(event.getClienteId());

        cuentaService.crearCuenta(cuenta);
    }
}
