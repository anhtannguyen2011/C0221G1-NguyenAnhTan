import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { EmployeeListComponent } from './components/employees/employee-list/employee-list.component';
import {CustomerComponent} from './components/customer/customer/customer.component';
import {CustomerListComponent} from './components/customer/customer-list/customer-list.component';


const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "employee-list", component: EmployeeListComponent},
  {path: "customer-list", component: CustomerListComponent},



  {path: '**', component: PageNotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
