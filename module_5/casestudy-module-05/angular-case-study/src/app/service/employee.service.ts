import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private EMP_API =  'http://localhost:3000/employees';
  constructor(private http: HttpClient) { }

  getAllEmployee(): Observable<any> {
    return this.http.get(this.EMP_API);
  }

  saveEmployee(employee) : Observable<any> {
    return this.http.post(this.EMP_API,employee);
  }

  findbyId(id: number) : Observable<any> {
    return this.http.get(`${this.EMP_API}/${id}`);
  }

  editEamployee(id: number, employee): Observable<any> {
    return this.http.put(`${this.EMP_API}/${id}`,employee);
  }

  deleteEmployee(id: number) : Observable<any> {
    return this.http.delete(`${this.EMP_API}/${id}`);
  }

  searchEmployee(name: string) : Observable<any> {
    return this.http.get(`${this.EMP_API}/?name_like=${name}`);
  }
}
