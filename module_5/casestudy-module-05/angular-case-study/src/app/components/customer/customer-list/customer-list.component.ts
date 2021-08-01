import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../../service/customer.service';
import {Customer} from '../../../model/Customer';
import {MatDialog} from '@angular/material/dialog';
import {MatSnackBar, MatSnackBarConfig} from '@angular/material/snack-bar';
import {DialogService} from '../../../service/dialog.service';
import {EmployeeComponent} from '../../employees/employee/employee.component';
import {CustomerComponent} from '../customer/customer.component';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customer: Customer[] = [];
  p: number = 1;
  isPopup = true ;
  constructor(private customerService: CustomerService,
              private matDialog: MatDialog,
              private snackBar: MatSnackBar,
              private dialogService: DialogService
              ) { }

  ngOnInit(): void {
    this.getAllCustomer();
  }

  config: MatSnackBarConfig ={
    duration: 3000,
    horizontalPosition: 'right',
    verticalPosition: 'top'
  }

  success(msg) {
    this.config['panelClass'] = ['notification', 'success'];
    this.snackBar.open(msg, '',this.config);
  }


  getAllCustomer() {
    this.customerService.getAllCustomer().subscribe(res => {
      this.customer = res;
    })
  }

  key: string = 'id' ;
  reverse: boolean = false;
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }

  addCustomer() {
    this.isPopup = true;
    const dialogRef = this.matDialog.open(CustomerComponent,{
      data: {}
    });
    this.isPopup = false;
    dialogRef.afterClosed().subscribe(() => {
      this.isPopup = false;
      this.ngOnInit();
    })
  }

  editCustomer(id){
    this.isPopup = true;
    this.customerService.findAllById(id).subscribe(res => {
      this.customer = res;
      const dialogRef = this.matDialog.open(CustomerComponent, {
        data : this.customer,
      });
      dialogRef.afterClosed().subscribe( res => {
        this.isPopup = true;
        this.ngOnInit();
      })
    })
  }

  nameSearch:string = '';
  search() {
    if(this.nameSearch == '') {
      this.ngOnInit();
    }else {
      this.customerService.searchByName(this.nameSearch).subscribe( res => {
        this.customer = res;
      })
    }
  }

  deleteCustomer(id: any) {
    // this.productService.deleteProduct(id).subscribe(() => {
    //   alert('Thanh Cong Roi Ban Oi');
    //   this.ngOnInit();
    // },error => {
    //   alert('That Bai Roi Ban Oi');
    // })
    this.dialogService.openConfirm('Bạn có mún xóa nó không')
      .afterClosed().subscribe(res => {
      if (res) {
        this.customerService.deleteCustomer(id).subscribe(() => {
          this.success(":: Thành Công Rồi Bạn Ơi");
          this.ngOnInit();
        }, error => {
          alert('Thất Bại');
        })
      }
    })
  }

}
