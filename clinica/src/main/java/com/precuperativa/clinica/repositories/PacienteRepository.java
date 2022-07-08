package com.precuperativa.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.precuperativa.clinica.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,Long>{
    
}
