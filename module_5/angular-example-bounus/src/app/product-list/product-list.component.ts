import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {ProductService} from '../service/product.service';
import {Product} from '../model/product';
import {ProductComponent} from '../product/product.component';
import {Router} from '@angular/router';
import {DialogService} from '../service/dialog.service';
import {MatSnackBar, MatSnackBarConfig} from '@angular/material/snack-bar';


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
  product: Product;
  iPopup = true ;
  productList: Product[] = [] ;
  name: any ;
  p: number = 1 ;
  constructor(private dialog: MatDialog,
              private productService: ProductService,
              private router: Router,
              private snackBar: MatSnackBar,
              private dialogService: DialogService) { }

  ngOnInit(): void {
    this.getProductList();
  }
  getProductList() {
    this.productService.getAll().subscribe(prodcut => {
      this.productList = prodcut;
    });
  }

  addProduct() {
    this.iPopup = true ;
    const dialogRef = this.dialog.open(ProductComponent, {
      data: {}
    });
    dialogRef.afterClosed().subscribe(result => {
      this.iPopup = false;
      this.getProductList();
    });
  }

  editProduct(id: number) {
    this.iPopup = true;
    this.productService.findById(id).subscribe(product => {
      this.product = product;
      console.log(this.product);
      const dialogRef = this.dialog.open(ProductComponent, {
        data : this.product,
      });
      dialogRef.afterClosed().subscribe(result => {
        this.iPopup = false;
        this.getProductList();
      });
    });
    // console.log(this.product.id);
    //
    // dialogRef.afterClosed().subscribe(result => {
    //   this.iPopup = false;
    //   this.getProductList();
    // });
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
  search() {
      if(this.name == '') {
        this.ngOnInit();
      }else {
        this.productList = this.productList.filter(res => {
          return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
        })
      }
  }
  key: string = 'id' ;
  reverse: boolean = false;
  sort(key) {
      this.key = key;
      this.reverse = !this.reverse;
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
      if(res) {
        this.productService.deleteProduct(id).subscribe(()=> {
          this.success(":: Thành Công Rồi Bạn Ơi");
          this.ngOnInit();
        },error => {
          alert('Thất Bại');
        })
      }
    })

  }

  nameSearch: string = "";
  searchProduct() {
    if(this.nameSearch == ""){
      this.ngOnInit()
    }else {
      this.productService.searchProductDate(this.nameSearch).subscribe(res => {
        this.productList = res;
        alert('thành công');
      }, error => {
        alert('thất bại')
      });
    }
  }

  dateOne: any;
  dateTwo: any;
  searchDate(){
    if(this.dateOne == "" && this.dateTwo == "") {
      this.ngOnInit();
    }else if(this.dateOne == "") {
      this.productService.searchDate2(this.dateTwo).subscribe(res => {
        this.productList = res;
        alert('thành công');
      }, error => {
        alert('thất bại')
      })
    }else if(this.dateTwo == ""){
      this.productService.searchDate1(this.dateOne).subscribe(res => {
        this.productList = res;
        alert('thành công');
      }, error => {
        alert('thất bại')
      })
    }else{
      this.productService.searchDate(this.dateOne,this.dateTwo).subscribe(res => {
        this.productList = res;
        alert('thành công');
      }, error => {
        alert('thất bại')
      })
    }
  }

}
