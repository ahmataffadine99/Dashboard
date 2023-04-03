import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const apiUrl = 'http://api.currencylayer.com';
const key = 'd7a6bcdb3c6117ffd3b904cbe8e7c5df';

@Injectable({
  providedIn: 'root'
})
export class ExchangeService {

  constructor(private http: HttpClient) { }

  getCurrencies(): any {
    return this.http.get<any>(`${apiUrl}/list?access_key=${key}`);
  }

  getLatestRate(from, to): any {
    return this.http.get<any>(`https://api.exchangeratesapi.io/latest?base=${from}&symbols=${to}`);
  }
}


