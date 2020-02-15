import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../employee';
import { Departement } from '../Departement';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private url = "http://localhost:8080/listEmployes/";
  constructor(private http: HttpClient) { }
  getEmployeesListR(motCle: string): Observable<Employee[]> {
    return this.http.get<Employee[]>("http://localhost:8080/chercherEmployes?x="+ motCle );
  }
  getEmployeesList(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.url);
  }
  getEmployee(id: number): Observable<Employee>{
    return this.http.get<Employee>(this.url + id);
  }
  
  saveEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.url, employee);
  }

  updateEmployee(id: number, employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(this.url + id, employee);
  }
  deleteEmployee(id: number): Observable<string> {
    return this.http.delete<string>(this.url + id);
  } 

  saveEmpDep(nbremp: number, nbrdep: number, employee: Employee, departement : Departement): Observable<Employee> {
    return this.http.post<Employee>(this.url + nbremp +"/"+ nbrdep, employee );
  }
  deleteAll(): Observable<string> {
    return this.http.delete<string>(this.url);
  } 
}
