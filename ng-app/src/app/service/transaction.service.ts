import { Injectable } from '@angular/core';
import {Http,Response,Headers,URLSearchParams, RequestOptions } from "@angular/http";
import {AuthenticationService} from './authentication.service';
import {Transaction} from '../transection/transaction';

@Injectable()
export class TransactionService {

  constructor(private http: Http, private authenticationService: AuthenticationService) {}

  private headers = new Headers({
    'Content-type': 'application/json',
    'Authorization': 'Bearer '+ this.authenticationService.getToken()
  });

  getTransactionData() {
    let transactionArray: Transaction[];
    return this.http.get('http://localhost:8080/transaction',{headers: this.headers})
      .map(res => res.json());
  }

  getTransaction(id: number) {
    let transaction: Transaction;
    return this.http.get('http://localhost:8080/transaction/'+id,{headers: this.headers})
      .map((res:Response) => {
        if (res){
          if (res.status === 200){
            return res.json();
          }
          if (res.status === 204){
            return null;
          }
        }
      });
  }



  findTransaction(search: string){
    let transaction: Transaction;
    let params: URLSearchParams = new URLSearchParams();
    params.set('search',search);
    let headers = new Headers({
      'Contenet-type': 'application/json'
      ,'Authorization': 'Bearer'+this.authenticationService.getToken()
    });
    return this.http.get('http://localhost:8080/transactions/',{headers: headers, search:params})
      .map(res => res.json());
  }



}
