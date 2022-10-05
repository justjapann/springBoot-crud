import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class PacienteService {

  private baseUrl = 'http://localhost:8080/api/';

  constructor(private http:HttpClient) { }

  getPacienteList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+'paciente-list');
  }

  createPaciente(paciente: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`+'save-paciente', paciente);
  }

  deletePaciente(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete-paciente/${id}`, { responseType: 'text' });
  }

  getPaciente(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/pacienteById/${id}`);
  }

  getPacienteByName(name: string): Observable<Object> {
    return this.http.get(`${this.baseUrl}/pacienteByName/${name}`);
  }

  updatePaciente(id: number, value: any): Observable<Object> {
    return this.http.post(`${this.baseUrl}/update-paciente/${id}`, value);
  }

}
