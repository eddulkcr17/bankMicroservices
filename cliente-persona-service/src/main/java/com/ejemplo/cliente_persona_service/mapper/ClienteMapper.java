package com.ejemplo.cliente_persona_service.mapper;

import com.ejemplo.cliente_persona_service.domain.Cliente;
import com.ejemplo.cliente_persona_service.domain.Persona;
import com.ejemplo.cliente_persona_service.dto.ClienteDTO;
import com.ejemplo.cliente_persona_service.dto.PersonaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteDTO dto);

    ClienteDTO toDto(Cliente entity);

    Persona toEntity(PersonaDTO dto);

    PersonaDTO toDto(Persona entity);
}
