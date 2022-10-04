package com.javatechie.crud.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FichaCliente")
public class Paciente {

    @Id
    @GeneratedValue
    private int id;
    private String nomePaciente;
    private int numeroCarteiraPlano;
    private int idPlanoDeSaude;
    private int idEspecialidade;
}