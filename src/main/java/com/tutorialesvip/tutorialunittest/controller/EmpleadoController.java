package com.tutorialesvip.tutorialunittest.controller;

import com.tutorialesvip.tutorialunittest.models.Empleado;
import com.tutorialesvip.tutorialunittest.models.EmpleadoResponse;
import com.tutorialesvip.tutorialunittest.repositories.EmpleadoRepository;
import com.tutorialesvip.tutorialunittest.util.DiferenciaEntreFechas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.util.Optional;

/**
 * Author: VIP
 */
@RestController()
public class EmpleadoController {

    EmpleadoResponse empleadoResponse;
    Optional<Empleado> empleado;
    EmpleadoRepository empleadoRepository;
    DiferenciaEntreFechas diferenciaEntreFechas;

    public EmpleadoController(EmpleadoRepository empleadoRepository, DiferenciaEntreFechas diferenciaEntreFechas) {
        this.empleadoRepository = empleadoRepository;
        this.diferenciaEntreFechas = diferenciaEntreFechas;
    }

    @GetMapping(path = "/empleado/{numeroEmpleado}")
    public ResponseEntity<EmpleadoResponse> getEmpleadoDetalle(@PathVariable("numeroEmpleado") String numeroEmpleado) {
        empleado = Optional.of(new Empleado());
        empleadoResponse = new EmpleadoResponse();

        empleado = Optional.ofNullable(empleadoRepository.findByNumeroEmpleado(numeroEmpleado));

        if (empleado.isPresent()) {
            Period period = diferenciaEntreFechas.calcularAntiguedad(empleado.get().getFechaIngreso());
            empleadoResponse.setNombre(empleado.get().getNombre());
            empleadoResponse.setNumeroEmpleado(empleado.get().getNumeroEmpleado());
            empleadoResponse.setFechaIngreso(empleado.get().getFechaIngreso());
            empleadoResponse.setDiasCumplidos(period.getDays());
            empleadoResponse.setMesesCumplidos(period.getMonths());
            empleadoResponse.setAñosCumplidos(period.getYears());
        }
        return ResponseEntity.ok(empleadoResponse);
    }
}