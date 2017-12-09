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

  products: Product[];

  constructor(private productDataService: ProductDataService,private router: Router) { }

  ngOnInit() {
    this.productDataService.getProductData()
      .subscribe(products => this.products = products);
  }
  showDetail(product: Product){
    this.router.navigate(['/detail',product.productId]);

    }

  upQuantity(product: Product) {
    product.amount++;
  }

  downQuantity(product: Product) {
    if (product.amount > 0)
      product.amount--;
  }
}
