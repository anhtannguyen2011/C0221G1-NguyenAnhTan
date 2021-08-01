import {Component, Inject, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {EmployeeService} from '../../../service/employee.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {PositionService} from '../../../service/position.service';
import {EducationService} from '../../../service/education.service';
import {DivisionService} from '../../../service/division.service';
import {Position} from '../../../model/Position';
import {Education} from '../../../model/Education';
import {Division} from '../../../model/Division';
import {Employees} from '../../../model/Employees';
import {validateDate} from '../../../validation/datevalidate';
import validate = WebAssembly.validate;

//
// export function validateDate(control: AbstractControl) {
//   let currentDay = new Date();
//   let date = new Date(control.value);
//   if (date > currentDay) {
//     return { dateValid : true };
//   }
//   return false;
// }
@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  employeeForm: FormGroup;
  positionList: Position;
  educationList: Education;
  divisionList: Division;

  constructor(private dialogRef: MatDialogRef<EmployeeComponent>,
              private employeeService: EmployeeService,
              private positionService: PositionService,
              private educationService: EducationService,
              private divisionService: DivisionService,
              private snackBar: MatSnackBar,
              @Inject(MAT_DIALOG_DATA) private data) {
  }

  ngOnInit(): void {
    // @ts-ignore
    this.employeeForm = new FormGroup({
      name: new FormControl(this.data.name,[Validators.required]),
      position: new FormControl(this.data.position),
      education: new FormControl(this.data.education),
      division: new FormControl(this.data.division),
      dateOfBirth: new FormControl(this.data.dateOfBirth,[validateDate]),
      idCard: new FormControl(this.data.idCard),
      salary: new FormControl(this.data.salary),
      phone: new FormControl(this.data.phone),
      email: new FormControl(this.data.email),
      address: new FormControl(this.data.address)
    });
    this.getAllDivision();
    this.getAllEducation();
    this.getAllPosition();
  }


  getAllDivision() {
    this.divisionService.getAllDivision().subscribe(res => {
      this.divisionList = res;
    })
  }

  getAllEducation() {
    this.educationService.getAllEducation().subscribe(res => {
      this.educationList = res;
    })
  }

  getAllPosition() {
    this.positionService.getAllPosition().subscribe(res => {
      this.positionList = res;
    })
  }

  onNoClick() {
    this.dialogRef.close();
  }

  onSubmit() {
    const employee = this.employeeForm.value;
    if (isNaN(this.data.id)) {
      this.employeeService.saveEmployee(employee).subscribe(() => {
        this.employeeForm.reset();
        this.snackBar.open('Thành Công Rồi Bạn Ơi','', {
          duration: 3000,
          horizontalPosition: 'right',
          verticalPosition: 'top'
        });
        this.dialogRef.close();
      })
    } else {
      this.employeeService.editEamployee(this.data.id, employee).subscribe(() => {
        this.employeeForm.reset();
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

  compareFn(c1: Employees, c2: Employees): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
