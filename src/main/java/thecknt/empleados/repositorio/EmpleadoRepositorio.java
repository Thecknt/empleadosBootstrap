package thecknt.empleados.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import thecknt.empleados.modelo.Empleado;

import java.util.Optional;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {

}
