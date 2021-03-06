///<reference path="../../node_modules/@angular/forms/src/form_providers.d.ts"/>
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { MainMenuComponent } from './menu/main-menu/main-menu.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { ProductViewComponent } from './product/product-view/product-view.component';
import { ProductAddComponent } from './product/product-add/product-add.component';
import { ProductEditComponent } from './product/product-edit/product-edit.component';
import { ProductDeleteComponent } from './product/product-delete/product-delete.component';
import { CartListComponent } from './cart/cart-list/cart-list.component';
import { FileNotFoundComponent } from './file-not-found/file-not-found/file-not-found.component';
import { ConfirmPageComponent } from './confirm-page/confirm-page/confirm-page.component';
import { TransactionComponent } from './transection/transection/transaction.component';
import { UserComponent } from './user/user/user.component';
import { UserAddComponent } from './user/user-add/user-add.component';
import { UserDeleteComponent } from './user/user-delete/user-delete.component';
import {AppRoutingModule} from "./app-routing-module";
import {ProductDataService} from "./service/product-data-service";
import {HttpModule} from "@angular/http";
import {FormsModule} from '@angular/forms';
import { LoginComponent } from './login/login.component';
import {AuthenticationService} from './service/authentication.service';
import {TransactionService} from './service/transaction.service';
import {ConfirmationTranferComponent} from "./confirm-page/confirmation-tranfer/confirmation-tranfer.component";
import { TransectionViewComponent } from './transection/transection-view/transection-view.component';
import {ProductEditListComponent} from './product/product-edit-list/product-edit-list.component';

@NgModule({
  declarations: [
    AppComponent,
    MainMenuComponent,
    ProductListComponent,
    ProductViewComponent,
    ProductAddComponent,
    ProductEditComponent,
    ProductDeleteComponent,
    CartListComponent,
    FileNotFoundComponent,
    ConfirmPageComponent,
    TransactionComponent,
    UserComponent,
    UserAddComponent,
    UserDeleteComponent,
    LoginComponent,
    ConfirmationTranferComponent,
    TransectionViewComponent,
    ProductEditListComponent,
  ],
  imports: [
    BrowserModule, AppRoutingModule, HttpModule, FormsModule
  ],
  providers: [ProductDataService,AuthenticationService,TransactionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
