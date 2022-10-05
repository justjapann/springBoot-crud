import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PacienteListComponent } from './paciente-list/paciente-list.component';
import { AddPacienteComponent } from './add-paciente/add-paciente.component';

const routes: Routes = [
  { path: '', redirectTo: 'view-paciente', pathMatch: 'full' },
  { path: 'view-paciente', component: PacienteListComponent },
  { path: 'add-paciente', component: AddPacienteComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
