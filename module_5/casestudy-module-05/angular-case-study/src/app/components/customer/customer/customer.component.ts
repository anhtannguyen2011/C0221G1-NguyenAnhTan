import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CustomerType} from '../../../model/CustomerType';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {MatSnackBar} from '@angular/material/snack-bar';
import {CustomerService} from '../../../service/customer.service';
import {CustomertypeService} from '../../../service/customertype.service';
import {Employees} from '../../../model/Employees';
import {Customer} from '../../../model/Customer';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customerForm: FormGroup;
  customerType: CustomerType;
  constructor(private dialogRef: MatDialogRef<CustomerComponent>,
              private snackBar: MatSnackBar,
              private customerService: CustomerService,
              private customertypeService: CustomertypeService,
              @Inject(MAT_DIALOG_DATA) public data) { }

  ngOnInit(): void {
    this.customerForm = new FormGroup({
      id: new FormControl(this.data.id),
      customerType: new FormControl(this.data.customerType),
      name: new FormControl(this.data.name),
      dateOfBirth: new FormControl(this.data.dateOfBirth),
      idCard: new FormControl(this.data.idCard),
      phone: new FormControl(this.data.phone),
      email: new FormControl(this.data.email),
      address: new FormControl(this.data.address),
    })
    this.getAllCustomerType();
  }


  getAllCustomerType() {
    this.customertypeService.getAllCustomerType().subscribe(res => {
        this.customerType = res
    })
  }

  onNoClick() {
    this.dialogRef.close();
  }

  onSubmit() {
    const customer = this.customerForm.value;
    if (isNaN(this.data.id)) {
      this.customerService.saveCustomer(customer).subscribe(() => {
        this.customerForm.reset();
        this.snackBar.open('Thành Công Rồi Bạn Ơi','', {
          duration: 3000,
          horizontalPosition: 'right',
          verticalPosition: 'top'
        });
        this.dialogRef.close();
      })
    } else {
      this.customerService.editCustomer(this.data.id, customer).subscribe(() => {
        this.customerForm.reset();
        this.snackBar.open('Cập Nhập Thành Công','', {

          duration: 3000,
          horizontalPosition: 'right',
          verticalPosition: 'top'
        });
        this.dialogRef.close();
      }, error => {
        alert('Khong Bó tay');
      });

    }
  }

  compareFn(c1: Customer, c2: Customer): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }


}
