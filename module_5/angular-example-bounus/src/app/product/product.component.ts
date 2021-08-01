import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ProductService} from '../service/product.service';

import {MatSnackBar, MatSnackBarConfig} from '@angular/material/snack-bar';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  productForm: FormGroup;
  constructor(private dialogRef: MatDialogRef<ProductComponent>,
              private productService: ProductService,
              private snackBar: MatSnackBar,
              @Inject(MAT_DIALOG_DATA) public data: any ) { }

  ngOnInit(): void {
    this.productForm = new FormGroup({
      name: new FormControl(this.data.name),
      manufacture: new FormControl(this.data.manufacture),
      price: new FormControl(this.data.price),
      date: new FormControl(this.data.date),
    });
  }

  onNoClick() {
    this.dialogRef.close();
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

  onSubmit() {
    const product = this.productForm.value;
    if(isNaN(this.data.id)){
      this.productService.saveProduct(product).subscribe(() => {
        this.productForm.reset();
        // this.snackBar.open('Thành Công Rồi Bạn Ơi','', {
        //   duration: 3000,
        //   horizontalPosition: 'right',
        //   verticalPosition: 'top'
        // });
        this.success(':: Add New Product Success !!!');
        this.dialogRef.close();
      }, error => {
        alert(' Thất Bại ! ! !');
      });
    }else {
      this.productService.editProduct(this.data.id, product).subscribe(() => {
        alert('cap nhap thanh cong');
        this.productForm.reset();
        this.dialogRef.close();
      }, error => {
        alert('Khong Bó tay') ;
      });
    }
    }



}
