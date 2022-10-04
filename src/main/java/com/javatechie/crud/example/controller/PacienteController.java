package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Paciente;
import com.javatechie.crud.example.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping("/addPaciente")
    public Paciente addPaciente(@RequestBody Paciente paciente){
        return service.savePaciente(paciente);
    }
    @PostMapping("/addPacientes")
    public List<Paciente> addPacientes(@RequestBody List<Paciente> pacientes){
        return service.savePacientes(pacientes);
    }

    @GetMapping("/pacientes")
    public List<Paciente> findAllPacientes(){
        return service.getPacientes();
    }

    @GetMapping("/paciente/{id}")
    public Paciente findProductById(@PathVariable int id){
        return service.getPacienteById(id);
    }
    @GetMapping("/paciente/{nomePaciente}")
    public Paciente findPacienteByName(@PathVariable String nomePaciente){
        return service.getPacienteByName(nomePaciente);
    }

    @PutMapping("/update")
    public Paciente updatePaciente(@RequestBody Paciente paciente){
        return service.updatePaciente(paciente);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePaciente(@PathVariable int id){
        return service.deletePaciente(id);
    }
}
