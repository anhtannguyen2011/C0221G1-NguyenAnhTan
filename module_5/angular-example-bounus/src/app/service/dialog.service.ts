import { Injectable } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {DeleteDialogComponent} from '../product/delete-dialog/delete-dialog.component';

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(private dialog: MatDialog) { }

  openConfirm(msg) {
   return  this.dialog.open(DeleteDialogComponent, {
      width: '390px',
      panelClass: 'confirm-dialog-container',
      disableClose: true,
      position: {top: "10px"},
      data: {
        message: msg,
      }
    })
  };
}
