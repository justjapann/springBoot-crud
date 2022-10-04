import { Paciente } from '../paciente';
import { Component, OnInit, Input } from '@angular/core';
import { PacienteService } from '../PacienteList/paciente.service';
import { PacienteListComponent } from '../PacienteList/paciente-list.component';

@Component({
  selector: 'app-employee-details',
  templateUrl: './paciente-details.component.html',
})
export class PacienteDetailsComponentTs implements OnInit {

  @Input() paciente: Paciente;

  constructor(private pacienteService: PacienteService, private listComponent: PacienteListComponent) { }

  ngOnInit() {
  }
}
