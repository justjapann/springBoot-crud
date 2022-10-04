import { PacienteDetailsComponentTs } from './DetailsPaciente/paciente-details.component.ts';
import { CreatePacienteComponent } from './CreatePaciente/create-paciente.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PacienteListComponent } from './PacienteList/paciente-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'paciente', pathMatch: 'full' },
  { path: 'pacientes', component: PacienteListComponent },
  { path: 'add', component: CreatePacienteComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
