import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DivisionService {
  private DVS_API = 'http://localhost:3000/division';
  constructor(private http: HttpClient) { }

  getAllDivision(): Observable<any> {
    return this.http.get(this.DVS_API);
  }
}
