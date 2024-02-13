package thecknt.empleados.controlador;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import thecknt.empleados.modelo.Empleado;
import thecknt.empleados.servicio.EmpleadoServicio;

import java.util.List;

@Controller
public class IndexControlador {

    @Autowired
    EmpleadoServicio empleadoServicio;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo){
        List<Empleado> empleados= empleadoServicio.listarEmpleados();
        empleados.forEach(empleado -> System.out.println(empleado.toString()));
        //Compartimos el modelo con la vista
        modelo.put("empleados", empleados);
        return "index"; //index.jsp
    }

    @RequestMapping(value="/agregar", method = RequestMethod.GET)
    public String mostrarAgregar(ModelMap modelo){
        return "agregar"; // agregar.jsp
    }

    @RequestMapping(value="/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("modelForm")Empleado empleado){
        empleadoServicio.guardarEmpleado(empleado);
        System.out.println("El empleado agregado es: " + empleado.toString());
        return "redirect:/"; //redirige al path "/"
    }

    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String mostrarEditar(@RequestParam int idEmpleado, ModelMap modelo){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
        System.out.println("El empleado seleccionado es: "+ empleado.toString());
        modelo.put("empleado",empleado);
        return "editar"; //mostrar editar.jsp
    }

    @RequestMapping(value = "/editar" , method = RequestMethod.POST)
    public String editar(@ModelAttribute("empleadoForm")Empleado empleado){
        System.out.println("El empleado a guardar es: "+empleado.toString());
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/";
    }

    @RequestMapping(value = "/eliminar",method = RequestMethod.GET)
    public String eliminar(@RequestParam int idEmpleado){
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        System.out.println("empleado eliminado: " + empleado.toString());
        empleadoServicio.eliminarEmpleado(empleado);
        return "redirect:/";
    }
}
