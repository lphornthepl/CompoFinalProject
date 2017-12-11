import {Injectable} from "@angular/core";
import {Product} from "../product/product";
import 'rxjs/add/operator/map';
import {Http,Response,Headers,URLSearchParams, RequestOptions } from "@angular/http";
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/mergeMap';
import {AuthenticationService} from './authentication.service';


@Injectable()
export class ProductDataService {
  constructor(private http: Http, private authenticationService: AuthenticationService) {}

  private headers = new Headers({
    'Content-type': 'application/json',
    'Authorization': 'Bearer '+ this.authenticationService.getToken()
  });

  public productInCart : Product[] = [];
  getProductData() {
    let productArray: Product[];
    return this.http.get('http://localhost:8080/product',{headers: this.headers})
      .map(res => res.json());
  }

  getProductIncart(){
    return this.productInCart;
  }

  getProduct(id: number) {
    let products: Product;
    return this.http.get('http://localhost:8080/product/'+id,{headers: this.headers})
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



  findProduct(search: string){
    let product: Product;
    let params: URLSearchParams = new URLSearchParams();
    params.set('search',search);
    let headers = new Headers({
      'Contenet-type': 'application/json'
      ,'Authorization': 'Bearer'+this.authenticationService.getToken()
    });

    return this.http.get('http://localhost:8080/products/',{headers: headers, search:params})
      .map(res => res.json());
  }

  addToCart(product: Product) {
    this.productInCart.push(product);

  }

  addProduct(product: Product,file:any):Observable<Product>{
    const formData = new FormData();
    let fileName: string;
    formData.append('file',file);
    let header = new Headers({'Authorization': 'Bearer ' + this.authenticationService.getToken()});
    let options = new RequestOptions({headers: header});
    return this.http.post('http://localhost:8080/upload', formData,options)
      .flatMap(filename => {
        product.image = filename.text();
        let headers = new Headers({'Content-Type': 'application/json',});
        let options = new RequestOptions({headers: this.headers});
        let body = JSON.stringify(product);
        return this.http.post('http://localhost:8080/product',body,options)
          .map(res =>{
            return res.json()
          })
      })
  }


}
