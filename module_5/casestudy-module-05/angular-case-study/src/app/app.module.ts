import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {EmployeeListComponent} from './components/employees/employee-list/employee-list.component';
import {EmployeeComponent} from './components/employees/employee/employee.component';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';
import {DeleteDialogComponent} from './components/employees/delete-dialog/delete-dialog.component';
import {MatButtonModule} from '@angular/material/button';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2OrderModule} from 'ng2-order-pipe';

import { CustomerListComponent } from './components/customer/customer-list/customer-list.component';
import { CustomerComponent } from './components/customer/customer/customer.component';


@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeComponent,
    DeleteDialogComponent,
    CustomerListComponent,
    CustomerComponent
  ],
  imports: [
    BrowserModule,
    MatIconModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    MatDialogModule,
    MatCardModule,
    MatToolbarModule,
    ReactiveFormsModule,
    MatSnackBarModule,
    MatButtonModule,
    NgxPaginationModule,
    FormsModule,
    Ng2OrderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
