import { Component, OnInit } from '@angular/core';
import {ProductDataService} from '../../service/product-data-service';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {Product} from '../product';

@Component({
  selector: 'app-product-edit-list',
  templateUrl: './product-edit-list.component.html',
  styleUrls: ['./product-edit-list.component.css']
})
export class ProductEditListComponent implements OnInit {

  constructor(private route: ActivatedRoute, private productService:ProductDataService, private router: Router) {}
  product:Product;
  isNoData:boolean;

  ngOnInit() {
    this.route.params
      .switchMap((params:Params) => this.productService.getProduct(+params['id']))
      .subscribe((product:Product) => {
          if (product != null)
            this.product = product;
          else
            this.isNoData = true;
        }
      );
  }

  updateProduct(product: Product){
    this.productService.updateProduct(product).subscribe( (product)=> {
      console.log(product);
      this.router.navigate(['/edit_product'])
    })
  }

  deleteProduct(product: Product){
    product.show = false ;
    this.productService.updateProduct(product).subscribe( (product)=> {
      console.log(product);
      this.router.navigate(['/edit_product'])
    })
  }

}
