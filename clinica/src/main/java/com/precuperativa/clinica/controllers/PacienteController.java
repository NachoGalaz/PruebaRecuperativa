package com.precuperativa.clinica.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.precuperativa.clinica.models.Paciente;
import com.precuperativa.clinica.services.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @RequestMapping("")
    public String inicio(@ModelAttribute("paciente") Paciente paciente) {
        return "paciente.jsp";
    }

    @PostMapping("/guardar")
    public String guardarPaciente(@Valid @ModelAttribute("paciente") Paciente paciente,
            BindingResult resultado, // corroborar que las tag de model se cumplan
            Model model) {
        if (resultado.hasErrors()) {
            model.addAttribute("msgError", "Datos erroneos");
            return "paciente.jsp";
            // si el resultado tiene errores es decir hay datos mal ingresados vuelve a la
            // pagina de ingreso de datos
        } else {
            // enviar objeto a base de datos
            pacienteService.guardarPaciente(paciente);
            // lista de pacientes
            List<Paciente> listaPacientes = pacienteService.findAll();
            // lista a jsp
            model.addAttribute("pacientesCapturados", listaPacientes);
            return "mostrarPacientes.jsp"; // muestra tabla
        }
    }

    // solo mostrar el listado de autos
    @RequestMapping("/mostrar")
    public String mostrar(Model model) {
        // obtener una lista de pacientes
        List<Paciente> listaPacientes = pacienteService.findAll();
        // pasamos la lista de pacientes al jsp
        model.addAttribute("pacientesCapturados", listaPacientes);
        return "mostrarPacientes.jsp";
    }

    @RequestMapping("/editar/{id}") // editar para el despliegue
    public String editar(@PathVariable("id") Long id,
            Model model) {
        Paciente paciente = pacienteService.buscarId(id);
        model.addAttribute("paciente", paciente);// pasar al jsp

        return "editarPaciente.jsp";// redireccionar a otra url o path
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarPaciente(@PathVariable("id") Long id, @Valid @ModelAttribute("paciente") Paciente paciente,
            BindingResult resultado,
            Model model) {
        if (resultado.hasErrors()) {
            model.addAttribute("msgError", "Datos erroneos");
            return "editarPaciente.jsp";
        } else {
            paciente.setId(id); // -> agregar el id al objeto

            // enviamos el obeto a persistir en base datos
            pacienteService.guardarPaciente(paciente);

            return "redirect:/paciente/mostrar";
        }
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable("id") Long id) {

        pacienteService.eliminarPorId(id);

        return "redirect:/paciente/mostrar";

    }

}
