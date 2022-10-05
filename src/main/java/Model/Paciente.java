package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int paciente_id;
    private String paciente_name;
    private int paciente_carteiradeplano;
    private String paciente_planodesaude;
    private String paciente_especialidade;

    public int getPaciente_id() {
        return paciente_id;
    }
    public void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
    }
    public String getPaciente_name() {
        return paciente_name;
    }
    public void setPaciente_name(String paciente_name) {
        this.paciente_name = paciente_name;
    }
    public int getPaciente_carteiradeplano() {
        return paciente_carteiradeplano;
    }
    public void setPaciente_carteiradeplano(int paciente_carteiradeplano) {
        this.paciente_carteiradeplano = paciente_carteiradeplano;
    }
    public String getPaciente_planodesaude() {
        return paciente_planodesaude;
    }
    public void setPaciente_planodesaude(String paciente_planodesaude) {
        this.paciente_planodesaude = paciente_planodesaude;
    }
    public String getPaciente_especialidade() {
        return paciente_especialidade;
    }
    public void setStudent_branch(String paciente_especialidade) {
        this.paciente_especialidade = paciente_especialidade;
    }


}