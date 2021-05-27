package controller;

import model.Customers;

import java.util.ArrayList;
import java.util.List;

public class AddCustomers {

    public static List<Customers> addEmployee(){
        List<Customers> customersList = new ArrayList<>();
        customersList.add(new Customers("Mai Văn Hoàn","1983-08-20","Hà Nội","https://image.vtc.vn/files/ctv.giaoduc/2016/11/03/nguoi-dep-xu-tuyen-1-0633.jpg"));
        customersList.add(new Customers("Nguyễn Văn Nam","1983-08-21","Bắc Giang","https://lh3.googleusercontent.com/proxy/oCvmu0DnvzFMhcdgYJyke7EzYR6ibLlxhk0_FC71_gNGlIa48opjFjLV4ySy2rIBPLBezixokM2tHzCrU6Oh6jmcls_i4pjgtsOCVemDEwJhWUCJz8a0llI7EWs0FpMcQvBuaSdIb6U"));
        customersList.add(new Customers("Nguyễn Thái Hòa","1983-08-22","Nam Định","https://lh3.googleusercontent.com/proxy/oCvmu0DnvzFMhcdgYJyke7EzYR6ibLlxhk0_FC71_gNGlIa48opjFjLV4ySy2rIBPLBezixokM2tHzCrU6Oh6jmcls_i4pjgtsOCVemDEwJhWUCJz8a0llI7EWs0FpMcQvBuaSdIb6U"));
        customersList.add(new Customers("Trần Đăng Khoa","1983-08-17","Hà Tây","https://lh3.googleusercontent.com/proxy/oCvmu0DnvzFMhcdgYJyke7EzYR6ibLlxhk0_FC71_gNGlIa48opjFjLV4ySy2rIBPLBezixokM2tHzCrU6Oh6jmcls_i4pjgtsOCVemDEwJhWUCJz8a0llI7EWs0FpMcQvBuaSdIb6U"));
        customersList.add(new Customers("Nguyễn Đình Thi","1983-08-19","Hà Nội","https://lh3.googleusercontent.com/proxy/oCvmu0DnvzFMhcdgYJyke7EzYR6ibLlxhk0_FC71_gNGlIa48opjFjLV4ySy2rIBPLBezixokM2tHzCrU6Oh6jmcls_i4pjgtsOCVemDEwJhWUCJz8a0llI7EWs0FpMcQvBuaSdIb6U"));

        return customersList;

    }
}

