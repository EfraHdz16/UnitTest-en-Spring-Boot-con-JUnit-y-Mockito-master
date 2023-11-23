package com.tutorialesvip.tutorialunittest.repositories;

import com.tutorialesvip.tutorialunittest.models.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
    Empleado findByNumeroEmpleado(String numeroEmpleado);
}
