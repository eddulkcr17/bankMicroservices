package com.ejemplo.cuentamovimiento.mapper;

import com.ejemplo.cuentamovimiento.domain.Movimiento;
import com.ejemplo.cuentamovimiento.dto.MovimientoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    @Mapping(source = "cuenta.numeroCuenta", target = "numeroCuenta")
    MovimientoDTO toDto(Movimiento movimiento);

    @Mapping(source = "numeroCuenta", target = "cuenta.numeroCuenta")
    Movimiento toEntity(MovimientoDTO dto);
}
