import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  private baseUrl = 'http://localhost:9191';

  constructor(private http: HttpClient) { }

  getPaciente(): Observable<Object> {
    const headers = { 'Access-Control-Allow-Origin':'*', 'Content-Type': 'application/json', 'Access-Control-Allow-Methods':'TRUE', 'Access-Control-Allow-Headers':'Accept, X-Requested-With'}
    return this.http.get(`${this.baseUrl}/pacientes`, {headers});
  }

  createPaciente(paciente: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/addPaciente`, paciente);
  }

  deletePaciente(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`, { responseType: 'text' });
  }

  getPacientesList(): Observable<any> {
    const headers = { 'Access-Control-Allow-Origin':'*', 'Content-Type': 'application/json', 'Access-Control-Allow-Methods':'TRUE', 'Access-Control-Allow-Headers':'Accept, X-Requested-With'}
    return this.http.get(`${this.baseUrl}/pacientes`, {headers});
  }
}
