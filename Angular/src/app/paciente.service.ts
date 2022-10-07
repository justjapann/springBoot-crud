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
    const headers = { 'Access-Control-Allow-Origin':'*', 'Content-Type': 'application/json'}
    return this.http.get(`${this.baseUrl}`+'paciente-list');
  }

  createPaciente(paciente: object): Observable<object> {
    const headers = { 'Access-Control-Allow-Origin':'*', 'Content-Type': 'application/json'}
    return this.http.post(`${this.baseUrl}`+'save-paciente', paciente);
  }

  deletePaciente(id: number): Observable<any> {

    return this.http.delete(`${this.baseUrl}delete-paciente/${id}`, { responseType: 'text' });
  }

  getPacienteById(id: number): Observable<Object> {
    const headers = { 'Access-Control-Allow-Origin':'*', 'Content-Type': 'application/json'}
    return this.http.get(`${this.baseUrl}pacienteById/${id}`);
  }

  getPacienteByName(name: string): Observable<Object> {
    const headers = { 'Access-Control-Allow-Origin':'*', 'Content-Type': 'application/json'}
    return this.http.get(`${this.baseUrl}pacienteByName/${name}`);
  }

  updatePaciente(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}update-paciente/${id}`, value);
  }

}
