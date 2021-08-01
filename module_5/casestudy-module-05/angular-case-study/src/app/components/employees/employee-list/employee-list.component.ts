import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../../../service/employee.service';
import {Employees} from '../../../model/Employees';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import {EmployeeComponent} from '../employee/employee.component';
import {DialogService} from '../../../service/dialog.service';
import {MatSnackBar, MatSnackBarConfig} from '@angular/material/snack-bar';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Employees[] = [];
  iPopup = true ;
  employee: Employees;
  p: number = 1;
  constructor(private employeeService: EmployeeService,
              private matDialog: MatDialog,
              private snackBar: MatSnackBar,
              private dialogService: DialogService
              ) { }

  ngOnInit(): void {
    this.getAll();
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
  getAll() {
    this.employeeService.getAllEmployee().subscribe(res => {
      this.employees = res;
      console.log(res);
    }, error => {
      alert('Thất Bại Rồi Bạn Ơi')
    })
  }

  editEmployee(id){
    this.iPopup = true;
    this.employeeService.findbyId(id).subscribe(res => {
      this.employee = res;
      const dialogRef = this.matDialog.open(EmployeeComponent, {
        data : this.employee,
      });
      dialogRef.afterClosed().subscribe( res => {
        this.iPopup = true;
        this.ngOnInit();
      })
    })
  }

  addEmployee() {
    this.iPopup = true;
    const dialogRef = this.matDialog.open(EmployeeComponent,{
        data: {}
    });
   this.iPopup = false;
   dialogRef.afterClosed().subscribe(() => {
     this.iPopup = false;
     this.ngOnInit();
   })
  }

  deleteProduct(id: any) {
    // this.productService.deleteProduct(id).subscribe(() => {
    //   alert('Thanh Cong Roi Ban Oi');
    //   this.ngOnInit();
    // },error => {
    //   alert('That Bai Roi Ban Oi');
    // })
    this.dialogService.openConfirm('Bạn có mún xóa nó không')
      .afterClosed().subscribe(res => {
      if (res) {
        this.employeeService.deleteEmployee(id).subscribe(() => {
          this.success(":: Thành Công Rồi Bạn Ơi");
          this.ngOnInit();
        }, error => {
          alert('Thất Bại');
        })
      }
    })
  }
  nameSearch:string = '';
  search() {
    if(this.nameSearch == '') {
      this.ngOnInit();
    }else {
      this.employeeService.searchEmployee(this.nameSearch).subscribe( res => {
        this.employees = res;
      })
    }
  }

  key: string = 'id' ;
  reverse: boolean = false;
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }
}
