package com.ejemplo.cliente_persona_service.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Cliente {
    @Id
    private String clienteId;

    @OneToOne
    @JoinColumn(name = "identificacion", referencedColumnName = "identificacion", unique = true)
    private Persona persona;

    private String contrasena;
    private boolean estado;
}
