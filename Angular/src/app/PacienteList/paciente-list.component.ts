import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {from, Observable} from 'rxjs';
import {Paciente} from '../paciente';
import { PacienteService } from "./paciente.service";

@Component({
  selector: 'app-root',
  templateUrl: './paciente-list.component.html',
})
export class PacienteListComponent implements OnInit {
  paciente: Observable<Paciente[]>;
  title = 'app';
  data:any;
  constructor(private pacienteService: PacienteService) {}
  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.paciente = this.pacienteService.getPacientesList();
  }

  deletePaciente(id: number) {
    this.pacienteService.deletePaciente(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

}
