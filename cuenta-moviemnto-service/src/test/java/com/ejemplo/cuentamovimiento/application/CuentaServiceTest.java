package com.ejemplo.cuentamovimiento.application;

import com.ejemplo.cuentamovimiento.domain.Cuenta;
import com.ejemplo.cuentamovimiento.infrastructure.repository.CuentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CuentaServiceTest {

    @Mock
    private CuentaRepository cuentaRepository;

    @InjectMocks
    private CuentaService cuentaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearCuenta_debeGuardarCuentaCorrectamente() {
        // Arrange
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("123456");
        cuenta.setSaldoInicial(BigDecimal.valueOf(1000));
        cuenta.setClienteId("Test-CLI001");

        when(cuentaRepository.save(any())).thenReturn(cuenta);

        // Act
        Cuenta resultado = cuentaService.crearCuenta(cuenta);

        // Assert
        assertNotNull(resultado);
        assertEquals("123456", resultado.getNumeroCuenta());
        verify(cuentaRepository).save(cuenta);
    }
}

