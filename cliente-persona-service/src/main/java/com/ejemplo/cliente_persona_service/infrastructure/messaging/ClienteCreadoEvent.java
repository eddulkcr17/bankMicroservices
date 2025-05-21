package com.ejemplo.cliente_persona_service.infrastructure.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCreadoEvent {
    private String clienteId;
    private String identificacion;
    private String nombre;
    private String telefono;
}
