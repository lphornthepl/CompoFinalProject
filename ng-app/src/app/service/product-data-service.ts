import {Injectable} from "@angular/core";
import {Product} from "../product/product";
import 'rxjs/add/operator/map';
import {Http,Response} from "@angular/http";

@Injectable()
export class ProductDataService {
  constructor(private http: Http) {}

  getProductData() {
    let productArray: Product[];
    return this.http.get('http://localhost:8080/product')
      .map(res => res.json());
  }

  getProduct(id: number) {
    let product:Product;
    return this.http.get('http://localhost:8080/product/'+id)
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
}
