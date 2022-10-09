import { Component, OnInit } from '@angular/core';
import { PacienteService } from '../paciente.service';
import { Paciente } from '../paciente';
import { Observable,Subject } from "rxjs";

import {FormControl,FormGroup,Validators} from '@angular/forms';

@Component({
  selector: 'app-paciente-list',
  templateUrl: './paciente-list.component.html',
  styleUrls: ['./paciente-list.component.css']
})
export class PacienteListComponent implements OnInit {

 constructor(private pacienteservice:PacienteService) { }

  pacientesArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any>= new Subject();
  msg: string;


  pacientes: any;
  paciente : Paciente=new Paciente();
  deleteMessage=false;
  pacientelist:any;
  isupdated = false;


  ngOnInit() {
    this.isupdated=false;
    this.dtOptions = {
      pageLength: 6,
      stateSave:true,
      lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],
      processing: true
    };
    this.pacienteservice.getPacienteList().subscribe(data =>{
    this.pacientes =data;
    this.dtTrigger.next();
    })
  }

  deletePaciente(id: number) {
    this.pacienteservice.deletePaciente(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage=true;
          this.pacienteservice.getPacienteList().subscribe(data =>{
            this.pacientes =data
            })
        },
        error => console.log(error));
  }


  updatePaciente(id: number){
    this.pacienteservice.getPacienteById(id)
      .subscribe(
        data => {
          this.pacientelist=data
        },
        error => {
          console.log(error)
        });
  }

  pacienteupdateform=new FormGroup({
    paciente_id:new FormControl(),
    paciente_name:new FormControl(),
    paciente_carteiradeplano:new FormControl(),
    paciente_planodesaude:new FormControl(),
    paciente_especialidade:new FormControl()
  });

  updatePac(updpac){
    this.paciente=new Paciente();
   this.paciente.paciente_id=this.PacienteId.value;
   this.paciente.paciente_name=this.PacienteName.value;
   this.paciente.paciente_carteiradeplano=this.PacienteCarteiraplano.value;
   this.paciente.paciente_planodesaude=this.PacientePlanodesaude.value;
   this.paciente.paciente_especialidade=this.PacienteEspecialidade.value;
   console.log(this.PacienteCarteiraplano.value);


   this.pacienteservice.updatePaciente(this.paciente.paciente_id,this.paciente).subscribe(
    data => {
      this.isupdated=true;
      this.pacienteservice.getPacienteList().subscribe(data =>{
        this.pacientes =data
        })
    },
    error => {
      console.log(error)
    });
  }

  get PacienteName(){
    return this.pacienteupdateform.get('paciente_name');
  }

  get PacienteCarteiraplano(){
    return this.pacienteupdateform.get('paciente_carteiradeplano');
  }

  get PacientePlanodesaude(){
    return this.pacienteupdateform.get('paciente_planodesaude');
  }

  get PacienteEspecialidade(){
    return this.pacienteupdateform.get('paciente_especialidade');
  }

  get PacienteId(){
    return this.pacienteupdateform.get('paciente_id');
  }

  changeisUpdate(){
    this.isupdated=false;
  }
}
