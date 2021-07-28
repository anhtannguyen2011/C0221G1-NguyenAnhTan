import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import { comparePassword } from './gte.validator';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.scss']
})
export class RegisterFormComponent implements OnInit {
  title = 'Register Form' ;
  // @ts-ignore
  // @ts-ignore
  countryList = ['Viet Nam', 'Nuoc Ngoai'];
  contractForm: FormGroup;
  // tslint:disable-next-line:variable-name
  validate_message = {
    email : [
      { type : 'required' , message : 'Email không được trống' },
      { type : 'email' , message: 'Email không đúng định dạng'}
      ],
    age : [
      { type : 'min' , message : 'Tuổi thấp nhất 18' }
    ],
    gender : [
      { type : 'required' , message : 'Gender không được trống'}
    ],
    phone : [
      { type : 'pattern' , message : 'Phone không đúng định dạnh'}
    ]
  };
  // comparePassword(c: AbstractControl): ValidationErrors | null {
  //   const v = c.value;
  //   return (v.password === v.confirmpassword) ? null : {
  //     passwordnotmatch: true
  //   };
  // }
  constructor() {
    this.contractForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      pw: new FormGroup({
        password: new FormControl('', [Validators.minLength(6)]),
        confirmpassword: new FormControl('', [Validators.minLength(6)])
      }, [comparePassword]),
      country : new FormControl('Viet Nam'),
      age: new FormControl('', [Validators.min(18)]),
      gender: new FormControl('' , [Validators.required]),
      phone: new FormControl('', [Validators.pattern(/^\+84\d{9,10}$/)]),
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.contractForm.value);
  }
}
