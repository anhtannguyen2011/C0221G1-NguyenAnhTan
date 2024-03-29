import {AbstractControl, Validators} from '@angular/forms';

export function validateDate(control: AbstractControl): Validators {
  let currentDay = new Date();
  let date = new Date(control.value);
  if (date > currentDay) {
    return { dateValid : true };
  }
  return false;
}
