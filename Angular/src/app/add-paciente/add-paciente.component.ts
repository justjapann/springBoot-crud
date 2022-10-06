import { Component, OnInit } from '@angular/core';
import { PacienteService } from '../paciente.service';
import {FormControl,FormGroup,Validators} from '@angular/forms';
import { Paciente } from '../paciente';
@Component({
  selector: 'app-add-paciente',
  templateUrl: './add-paciente.component.html',
  styleUrls: ['./add-paciente.component.css']
})
export class AddPacienteComponent implements OnInit {

  constructor(private pacienteservice:PacienteService) { }

  paciente : Paciente=new Paciente();
  submitted = false;

  ngOnInit() {
    this.submitted=false;
  }

  pacientesaveform=new FormGroup({
    paciente_name:new FormControl('' , [Validators.required , Validators.minLength(4) ] ),
    paciente_carteiradeplano:new FormControl('',[Validators.required,Validators.email]),
    paciente_planodesaude:new FormControl(),
    paciente_especialidade:new FormControl(),
  });

  savePaciente(savePaciente){
    this.paciente=new Paciente();
    this.paciente.paciente_name=this.PacienteName.value;
    this.paciente.paciente_carteiradeplano=this.PacienteCarteiraplano.value;
    this.paciente.paciente_planodesaude=this.PacientePlanodesaude.value;
    this.paciente.paciente_especialidade=this.PacienteEspecialidade.value;
    this.submitted = true;
    this.save();
  }



  save() {
    this.pacienteservice.createPaciente(this.paciente)
      .subscribe(data => console.log(data), error => console.log(error));
    this.paciente = new Paciente();
  }

  get PacienteName(){
    return this.pacientesaveform.get('paciente_name');
  }

  get PacienteCarteiraplano(){
    return this.pacientesaveform.get('paciente_carteiradeplano');
  }

  get PacientePlanodesaude(){
    return this.pacientesaveform.get('paciente_planodesaude');
  }
  get PacienteEspecialidade(){
    return this.pacientesaveform.get('paciente_especialidade');
  }

  addPacienteForm(){
    this.submitted=false;
    this.pacientesaveform.reset();
  }
}
