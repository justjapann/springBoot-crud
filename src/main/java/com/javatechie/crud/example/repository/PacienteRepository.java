package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

    Paciente findByNomePaciente(String nomePaciente);
}
