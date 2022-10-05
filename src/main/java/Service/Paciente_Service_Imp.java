package Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import DAO.Paciente_DAO;
import Model.Paciente;

@Service
@Transactional
public class Paciente_Service_Imp implements Paciente_Service {

    @Autowired
    private Paciente_DAO pacientedao;

    @Override
    public boolean savePaciente(Paciente paciente) {
        return pacientedao.savePaciente(paciente);
    }

    @Override
    public List<Paciente> getPacientes() {
        return pacientedao.getPacientes();
    }

    @Override
    public boolean deletePaciente(Paciente paciente) {
        return pacientedao.deletePaciente(paciente);
    }

    @Override
    public List<Paciente> getPacienteByID(Paciente paciente) {
        return pacientedao.getPacienteByID(paciente);
    }

    @Override
    public List<Paciente> getPacienteByName(Paciente paciente) {
        return pacientedao.getPacienteByName(paciente);
    }

    @Override
    public boolean updatePaciente(Paciente paciente) {
        return pacientedao.updatePaciente(paciente);
    }

}