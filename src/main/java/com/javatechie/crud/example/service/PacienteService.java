package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Paciente;
import com.javatechie.crud.example.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    public Paciente savePaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> savePacientes(List<Paciente> pacientes) {
        return repository.saveAll(pacientes);
    }

    public List<Paciente> getPacientes() {
        return repository.findAll();
    }

    public Paciente getPacienteById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Paciente getPacienteByName(String nomePaciente) {
        return repository.findByNomePaciente(nomePaciente);
    }

    public String deletePaciente(int id) {
        repository.deleteById(id);
        return "ficha removida com sucesso !! " + id;
    }

    public Paciente updatePaciente(Paciente paciente) {
        Paciente existingPaciente = repository.findById(paciente.getId()).orElse(null);
        existingPaciente.setNomePaciente(paciente.getNomePaciente());
        existingPaciente.setNumeroCarteiraPlano(paciente.getNumeroCarteiraPlano());
        existingPaciente.setIdPlanoDeSaude(paciente.getIdPlanoDeSaude());
        existingPaciente.setIdEspecialidade(paciente.getIdEspecialidade());
        return repository.save(existingPaciente);
    }


}
