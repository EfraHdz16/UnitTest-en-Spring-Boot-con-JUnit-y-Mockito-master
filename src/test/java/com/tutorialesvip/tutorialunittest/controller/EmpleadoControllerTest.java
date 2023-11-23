package com.tutorialesvip.tutorialunittest.controller;

import com.tutorialesvip.tutorialunittest.models.Empleado;
import com.tutorialesvip.tutorialunittest.models.EmpleadoResponse;
import com.tutorialesvip.tutorialunittest.repositories.EmpleadoRepository;
import com.tutorialesvip.tutorialunittest.util.DiferenciaEntreFechas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

class EmpleadoControllerTest {

    EmpleadoResponse empleadoResponse;

    Optional<Empleado> empleado;

    EmpleadoRepository empleadoRepositoryMock = Mockito.mock(EmpleadoRepository.class);

    DiferenciaEntreFechas diferenciaEntreFechas = new DiferenciaEntreFechas();

    EmpleadoController empleadoController = new EmpleadoController(empleadoRepositoryMock,diferenciaEntreFechas);

    @BeforeEach
    void setUp() {
        Empleado mockEmpleado = new Empleado();
        mockEmpleado.setNumeroEmpleado("123456");
        mockEmpleado.setNombre("Juan Perez");
        mockEmpleado.setFechaIngreso("11/01/2020");

        Mockito.when(empleadoRepositoryMock.findByNumeroEmpleado("123456")).thenReturn(mockEmpleado);

    }

    @Test
    void getEmpleadoDetailsWithValidEmpleadoCode() {
        ResponseEntity<EmpleadoResponse> respuestaServicio;
        respuestaServicio = empleadoController.getEmpleadoDetalle("123456");
        Assertions.assertEquals("Juan Perez",respuestaServicio.getBody().getNombre());
    }

    @Test
    void getEmpleadoDetailsWithInvalidEmpleadoCode() {
        ResponseEntity<EmpleadoResponse> respuestaServicio;
        respuestaServicio = empleadoController.getEmpleadoDetalle("123000");
        Assertions.assertNull(respuestaServicio.getBody().getNombre());
    }


}