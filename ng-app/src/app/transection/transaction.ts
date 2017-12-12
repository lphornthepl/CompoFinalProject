import {Product} from '../product/product';

export class Transaction {
  id : number;
  date : string;
  typeOfPayment: string;

  productList?:Product[];
}
