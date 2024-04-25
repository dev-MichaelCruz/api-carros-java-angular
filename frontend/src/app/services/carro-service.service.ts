import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarroServiceService {

  apiUrl = "http://localhost:8080/api/v1/carros";

  constructor(private http: HttpClient,
              private router: Router) {
  }

  carregarTabela(): any {
    this.http.get(this.apiUrl);
  }
}
