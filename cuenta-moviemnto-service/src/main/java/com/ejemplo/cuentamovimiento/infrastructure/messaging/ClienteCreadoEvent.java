package com.ejemplo.cuentamovimiento.infrastructure.messaging;

import lombok.Data;

@Data
public class ClienteCreadoEvent {
    private String clienteId;
    private String identificacion;
    private String nombre;
    private String telefono;
}
