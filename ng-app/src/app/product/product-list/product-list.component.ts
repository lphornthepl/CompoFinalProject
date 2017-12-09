import { Component, OnInit } from '@angular/core';
import { ProductDataService} from "../../service/product-data-service";
import {Product} from "../product";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];

  constructor(private productDataService: ProductDataService) { }

  ngOnInit() {
    this.productDataService.getProductsData().subscribe( products => this.products = products);
  }

}
