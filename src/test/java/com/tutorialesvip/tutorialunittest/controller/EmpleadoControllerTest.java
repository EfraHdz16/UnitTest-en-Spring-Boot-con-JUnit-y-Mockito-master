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

    EmpleadoRepository empleadoRepositoryMock = Mockito.mock(EmpleadoRepository.class);

    DiferenciaEntreFechas diferenciaEntreFechas = new DiferenciaEntreFechas();

    EmpleadoController empleadoController = new EmpleadoController(empleadoRepositoryMock,diferenciaEntreFechas);

    @BeforeEach
    void setUp() {
        Empleado mockEmpleado = new Empleado();
        mockEmpleado.setNumeroEmpleado("123457");
        mockEmpleado.setNombre("Jose Ramirez");
        mockEmpleado.setFechaIngreso("01/07/2018");
        Mockito.when(empleadoRepositoryMock.findByNumeroEmpleado("123456")).thenReturn(mockEmpleado);
    }

    @Test
    void getEmpleadoDetailsWithValidEmpleadoCode() {
        ResponseEntity<EmpleadoResponse> respuestaServicio;
        respuestaServicio = empleadoController.getEmpleadoDetalle("123456");
        Assertions.assertEquals("123457",respuestaServicio.getBody().getNumeroEmpleado());
        Assertions.assertEquals("Jose Ramirez",respuestaServicio.getBody().getNombre());
        Assertions.assertEquals("01/07/2018",respuestaServicio.getBody().getFechaIngreso());
        Assertions.assertEquals(5,respuestaServicio.getBody().getAñosCumplidos());
        Assertions.assertEquals(4,respuestaServicio.getBody().getMesesCumplidos());
        Assertions.assertEquals(22,respuestaServicio.getBody().getDiasCumplidos());
    }

    @Test
    void getEmpleadoDetailsWithInvalidEmpleadoCode() {
        ResponseEntity<EmpleadoResponse> respuestaServicio;
        respuestaServicio = empleadoController.getEmpleadoDetalle("123000");
        Assertions.assertNull(respuestaServicio.getBody().getNombre());
    }


}