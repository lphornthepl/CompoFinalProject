import { Component, OnInit } from '@angular/core';
import { ProductDataService} from "../../service/product-data-service";
import {Product} from "../product";
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  constructor(private productDataService: ProductDataService,private router: Router) { }
  products: Product[];


  ngOnInit() {
    this.productDataService.getProductData()
      .subscribe(products => this.products = products);


  }
  showDetail(product: Product){
    this.router.navigate(['/detail',product.productId]);

    }



  addToCart(product: Product) {
    // var same = false;
    // for(var i=0;i++;i<this.productDataService.productInCart.length) {
    //   var string1 = this.productDataService.productInCart[i].productId;
    //   var string2 = product.productId;
    //   if (string1 == string2) {
    //     same = true ;
    //   }
    // }
    // if(same == false){
      this. productDataService.getProductIncart().push(product);

    //}
  }

}
