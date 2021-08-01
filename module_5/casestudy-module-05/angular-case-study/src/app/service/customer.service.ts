import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private CUS_API = 'http://localhost:3000/customer';
  constructor(private http: HttpClient) { }

  getAllCustomer() : Observable<any> {
    return this.http.get(this.CUS_API)
  }

  findAllById(id: number) : Observable<any> {
    return this.http.get(`${this.CUS_API}/${id}`);
  }

  saveCustomer(customer) : Observable<any> {
    return this.http.post(this.CUS_API, customer);
  }

  editCustomer(id: number, customer) : Observable<any> {
    return this.http.put(`${this.CUS_API}/${id}`,customer);
  }

  deleteCustomer(id:number) : Observable<any> {
    return this.http.delete(`${this.CUS_API}/${id}`);
  }

  searchByName(name: string) : Observable<any> {
    return this.http.get(`${this.CUS_API}/?name_like=${name}`)
  }
}
