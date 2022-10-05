package Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Paciente;
import Service.Paciente_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class Controller {

    @Autowired
    private Paciente_Service pacienteservice;

    @PostMapping("save-paciente")
    public boolean savePaciente(@RequestBody Paciente paciente) {
        return pacienteservice.savePaciente(paciente);

    }

    @GetMapping("paciente-list")
    public List<Paciente> allpacientes() {
        return pacienteservice.getPacientes();

    }

    @DeleteMapping("delete-paciente/{paciente_id}")
    public boolean deleteStudent(@PathVariable("paciente_id") int paciente_id,Paciente paciente) {
        paciente.setPaciente_id(paciente_id);
        return pacienteservice.deletePaciente(paciente);
    }

    @GetMapping("pacienteById/{paciente_id}")
    public List<Paciente> allpacienteByID(@PathVariable("paciente_id") int paciente_id,Paciente paciente) {
        paciente.setPaciente_id(paciente_id);
        return pacienteservice.getPacienteByID(paciente);

    }

    @GetMapping("pacienteByName/{paciente_name}")
    public List<Paciente> allpacienteByName(@PathVariable("paciente_name") String paciente_name,Paciente paciente) {
        paciente.setPaciente_name(paciente_name);
        return pacienteservice.getPacienteByName(paciente);

    }

    @PostMapping("update-paciente/{paciente_id}")
    public boolean updatePaciente(@RequestBody Paciente paciente,@PathVariable("paciente_id") int paciente_id) {
        paciente.setPaciente_id(paciente_id);
        return pacienteservice.updatePaciente(paciente);
    }
}