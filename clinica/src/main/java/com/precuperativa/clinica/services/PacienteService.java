package com.precuperativa.clinica.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.precuperativa.clinica.models.Paciente;
import com.precuperativa.clinica.repositories.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;
//Guardar un paciente
    public void guardarPaciente(@Valid Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    //lista pacientes
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
        
    }

    public Paciente buscarId(Long id) {
		return pacienteRepository.findById(id).get();//.get() especifica el tipo de datos que necesitamop
	}
	
	public void eliminarPorId(Long id) {
		
		pacienteRepository.deleteById(id);
	}

    
}

