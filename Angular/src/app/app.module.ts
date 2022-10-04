import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { CreatePacienteComponent } from './CreatePaciente/create-paciente.component';
import { PacienteDetailsComponentTs } from './DetailsPaciente/paciente-details.component.ts';
import { PacienteListComponent } from './PacienteList/paciente-list.component';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent,
    CreatePacienteComponent,
    PacienteDetailsComponentTs,
    PacienteListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
