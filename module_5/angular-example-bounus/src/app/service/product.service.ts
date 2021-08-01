import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL_API = 'http://localhost:3000/product';
  constructor(private http: HttpClient) { }

  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(this.URL_API) ;
  }
  saveProduct(product): Observable<Product> {
    return this.http.post<Product>(this.URL_API, product);
  }

  findById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.URL_API}/${id}`);
  }
  editProduct(id: number, product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.URL_API}/${id}` , product);
  }
  deleteProduct(id: number): Observable<Product> {
    return this.http.delete<Product>(`${this.URL_API}/${id}`);
  }

  searchProductDate(name: any): Observable<any> {
    return this.http.get(this.URL_API+"/?name_like="+name) ;
  }

  searchDate(dateOne: any, dateTwo:any): Observable<any> {
    return this.http.get(`${this.URL_API}/?date_gte=${dateOne}&date_lte=${dateTwo}`);
  }
    searchDate1(dateOne: any): Observable<any> {
      return this.http.get(`${this.URL_API}/?date_gte=${dateOne}`);
  }
  searchDate2(dateTwo:any): Observable<any> {
    return this.http.get(`${this.URL_API}/?date_lte=${dateTwo}`);
  }
}
