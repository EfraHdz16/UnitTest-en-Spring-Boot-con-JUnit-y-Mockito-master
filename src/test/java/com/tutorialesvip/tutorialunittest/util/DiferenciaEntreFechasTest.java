package com.tutorialesvip.tutorialunittest.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class DiferenciaEntreFechasTest {

    DiferenciaEntreFechas diferenciaEntreFechas;

    @Test
    void calculateYearsOfIndependency() {
        diferenciaEntreFechas = new DiferenciaEntreFechas();
        String fechaIngreso = "11/01/2020";

        Period resultado = diferenciaEntreFechas.calcularAntiguedad(fechaIngreso);

        Assertions.assertEquals(10,resultado.getMonths() );
        Assertions.assertEquals(2,resultado.getDays() );
        Assertions.assertEquals(3,resultado.getYears() );
    }
}