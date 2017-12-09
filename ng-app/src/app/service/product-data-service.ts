import {Injectable} from "@angular/core";
import {Product} from "../product/product";
import {Observable} from "rxjs/Observable";
import {Subscriber} from "rxjs/Subscriber";
import 'rxjs/add/operator/map';

@Injectable()
export class ProductDataService {
  products: Product[] = [
    {
      productId: "1",
      productName: "Laap",
      Amount: 5,
      description: "Best food ever!!!",
      price: 100,
      image: "Laap mu.jpg"
    },
    {
      productId: "2",
      productName: "Lu",
      Amount: 10,
      description: "Blood sup!!!",
      price: 100,
      image: "Lu mu.jpg"
    },
    {
      productId: "3",
      productName: "App mu",
      Amount: 5,
      description: "The good one!!!",
      price: 100,
      image: "App mu.jpg"
    },
    {
      productId: "4",
      productName: "Coke",
      Amount: 5,
      description: "Bigbang!!!",
      price: 100,
      image: "App mu.jpg"
    }

  ];

  getProductsData(){
    return Observable.create((subscriber:Subscriber<Product[]>)=>subscriber.next(this.products));
  }
}
