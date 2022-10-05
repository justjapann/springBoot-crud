package DAO;

import java.util.List;

import Model.Paciente;

public interface Paciente_DAO {

    public boolean savePaciente(Paciente paciente);
    public List<Paciente> getPacientes();
    public boolean deletePaciente(Paciente paciente);
    public List<Paciente> getPacienteByID(Paciente paciente);

    public List<Paciente> getPacienteByName(Paciente paciente);
    public boolean updatePaciente(Paciente paciente);
}