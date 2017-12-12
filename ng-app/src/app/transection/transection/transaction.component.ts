import {Component, OnInit} from '@angular/core';
import {ProductDataService} from "../../service/product-data-service";
import {Router} from '@angular/router';
import {Product} from "../../product/product";

@Component({
  selector: 'app-transection',
  templateUrl: './transection.component.html',
  styleUrls: ['./transection.component.css']
})
export class TransactionComponent implements OnInit {


  constructor(private productDataService: ProductDataService, private router: Router) {
  }



  products: Product[];


  ngOnInit() {
    this.productDataService.getProductData()
      .subscribe(products => this.products = products);


  }

  showDetail(product: Product) {
    this.router.navigate(['/detail', product.productId]);

  }



  addToCart(product: Product) {
      this.productDataService.getProductIncart().push(product);
    //}
  }

  search: string;

  onSearch() {
    this.productDataService.findProduct(this.search).subscribe(products => this.products = products, (error) => {
      if (error.status === 401) {
        this.router.navigate(['product'], {queryParams: {source: 'product'}})
      }
    })
  }


}
