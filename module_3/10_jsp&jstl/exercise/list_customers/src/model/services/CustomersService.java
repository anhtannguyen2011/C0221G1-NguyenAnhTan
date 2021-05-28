package model.services;

import model.bean.Customers;

import java.util.ArrayList;
import java.util.List;

public class CustomersService {

    public static List<Customers> addCustomers(){
        List<Customers> customersList = new ArrayList<>();
        customersList.add(new Customers("Mai Văn Hoàn","1983-08-20","Hà Nội","https://image.vtc.vn/files/ctv.giaoduc/2016/11/03/nguoi-dep-xu-tuyen-1-0633.jpg"));
        customersList.add(new Customers("Nguyễn Văn Nam","1983-08-21","Bắc Giang","https://image.vtc.vn/files/ctv.giaoduc/2016/11/03/nguoi-dep-xu-tuyen-1-0633.jpg"));
        customersList.add(new Customers("Nguyễn Thái Hòa","1983-08-22","Nam Định","https://image.vtc.vn/files/ctv.giaoduc/2016/11/03/nguoi-dep-xu-tuyen-1-0633.jpg"));
        customersList.add(new Customers("Trần Đăng Khoa","1983-08-17","Hà Tây","https://image.vtc.vn/files/ctv.giaoduc/2016/11/03/nguoi-dep-xu-tuyen-1-0633.jpg"));
        customersList.add(new Customers("Nguyễn Đình Thi","1983-08-19","Hà Nội","https://image.vtc.vn/files/ctv.giaoduc/2016/11/03/nguoi-dep-xu-tuyen-1-0633.jpg"));
        return customersList;
    }
}

