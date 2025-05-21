package com.ejemplo.cliente_persona_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ClienteDTO {
    @NotBlank(message = "El ID del cliente es obligatorio")
    private String clienteId;

    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasena;

    @NotNull(message = "El estado es obligatorio")
    private Boolean estado;

    @Valid
    @NotNull(message = "La información de la persona es requerida")
    private PersonaDTO persona;
}
