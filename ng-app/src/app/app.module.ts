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
import { LoginComponent } from './login/login/login.component';
import { ConfirmPageComponent } from './confirm-page/confirm-page/confirm-page.component';
import { TransactionComponent } from './transection/transection/transaction.component';
import { RegisterComponent } from './register/register/register.component';
import { UserComponent } from './user/user/user.component';
import { UserAddComponent } from './user/user-add/user-add.component';
import { UserDeleteComponent } from './user/user-delete/user-delete.component';
import {AppRoutingModule} from "./app-routing-module";

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
    LoginComponent,
    ConfirmPageComponent,
    TransactionComponent,
    RegisterComponent,
    UserComponent,
    UserAddComponent,
    UserDeleteComponent
  ],
  imports: [
    BrowserModule,AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
