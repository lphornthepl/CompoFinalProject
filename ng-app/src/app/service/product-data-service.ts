import {Injectable} from "@angular/core";
import {Product} from "../product/product";
import 'rxjs/add/operator/map';
import {Http,Response,Headers,URLSearchParams} from "@angular/http";

@Injectable()
export class ProductDataService {
  constructor(private http: Http) {}

  public productInCart : Product[] = [];
  getProductData() {
    let productArray: Product[];
    return this.http.get('http://localhost:8080/product')
      .map(res => res.json());
  }

  getProductIncart(){
    return this.productInCart;
  }

  getProduct(id: number) {
    let products: Product;
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

  addToCart(product: Product) {
    this.productInCart.push(product);
  }


  findProduct(search: string){
    let product: Product;
    let params: URLSearchParams = new URLSearchParams();
    params.set('search',search);
    let headers = new Headers({
      'Contenet-type': 'application/json'
      // ,'Authorization': 'Bearer'+this.authenticationService.getToken()
    });
    return this.http.get('http://localhost:8080/products/',{headers:headers,search: params}).map(res => res.json());
  }


}
