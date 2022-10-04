import { PacienteService } from '../PacienteList/paciente.service';
import { Paciente } from '../paciente';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-paciente.component.html',
})
export class CreatePacienteComponent implements OnInit {

  paciente: Paciente = new Paciente();
  submitted = false;

  constructor(private pacienteService: PacienteService) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.paciente = new Paciente();
  }

  save() {
    this.pacienteService.createPaciente(this.paciente)
      .subscribe(data => console.log(data), error => console.log(error));
    this.paciente = new Paciente();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
