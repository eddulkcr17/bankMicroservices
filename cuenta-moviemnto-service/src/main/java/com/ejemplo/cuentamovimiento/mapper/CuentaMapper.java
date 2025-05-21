package com.ejemplo.cuentamovimiento.mapper;

import com.ejemplo.cuentamovimiento.domain.Cuenta;
import com.ejemplo.cuentamovimiento.dto.CuentaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CuentaMapper {
    Cuenta toEntity(CuentaDTO dto);
    CuentaDTO toDto(Cuenta entity);
}
