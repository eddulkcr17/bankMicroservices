package com.ejemplo.cliente_persona_service.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PersonaDTO {
    @NotBlank(message = "La identificación es obligatoria")
    private String identificacion;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El género es obligatorio")
    private String genero;

    @Min(value = 0, message = "La edad no puede ser negativa")
    private int edad;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    @Pattern(regexp = "^\\d{9,10}$", message = "Número de teléfono no válido")
    private String telefono;
}
