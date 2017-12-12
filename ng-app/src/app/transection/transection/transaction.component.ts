import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {TransactionService} from '../../service/transaction.service';
import {Transaction} from '../transaction';

@Component({
  selector: 'app-transection',
  templateUrl: './transection.component.html',
  styleUrls: ['./transection.component.css']
})
export class TransactionComponent implements OnInit {


  constructor(private transactionService: TransactionService, private router: Router) {
  }

  transactions: Transaction[];


  ngOnInit() {
    this.transactionService.getTransactionData()
      .subscribe(transactions => this.transactions = transactions);

  }
  search: string;
  onSearch() {
    this.transactionService.findTransaction(this.search).subscribe(transactions => this.transactions = transactions, (error) => {
      if (error.status === 401) {
        this.router.navigate(['login'], {queryParams: {source: 'product'}})
      }
    })
  }



}
