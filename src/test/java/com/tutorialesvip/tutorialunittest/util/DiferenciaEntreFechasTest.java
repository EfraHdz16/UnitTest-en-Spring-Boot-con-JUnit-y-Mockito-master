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
        String fechaIngreso = "01/07/2018";

        Period resultado = diferenciaEntreFechas.calcularAntiguedad(fechaIngreso);

        Assertions.assertEquals(4,resultado.getMonths() );
        Assertions.assertEquals(22,resultado.getDays() );
        Assertions.assertEquals(5,resultado.getYears() );
    }
}