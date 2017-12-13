import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';
import {Product} from '../../product/product';
import {TransactionService} from '../../service/transaction.service';
import {Transaction} from '../transaction';


@Component({
  selector: 'app-transection-view',
  templateUrl: './transection-view.component.html',
  styleUrls: ['./transection-view.component.css']
})
export class TransectionViewComponent implements OnInit {

  constructor(private route: ActivatedRoute, private transactionDataService: TransactionService) {}
  transactions: Transaction;
  isNoData:boolean;

  ngOnInit() {
    this.route.params
      .switchMap((params:Params) => this.transactionDataService.getTransaction(+params['id']))
      .subscribe((transaction:Transaction) => {
          if (transaction != null)
            this.transactions = transaction;
          else
            this.isNoData = true;
        }
      );
  }

}
