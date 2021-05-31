package customers.model.repository;

import customers.model.bean.Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy_furama?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static final String SELECT_ALL_CUSTOMERS = "select * from khach_hang";

    public CustomerRepository(){

    }

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }


    public List<Customers> selectAllCustomers(){
        List<Customers> customers = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS)){
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id_khach_hang");
                String name = rs.getString("ho_ten");
                String dayOfBirth = rs.getString("ngay_sinh");
                int idCard = rs.getInt("cmnd");
                int phone = rs.getInt("so_dien_thoai");
                String email = rs.getString("email");
                String diachi = rs.getString("dia_chi");
                int id_typeOfCus = rs.getInt("id_loai_khach");
                customers.add(new Customers(id,name,dayOfBirth,idCard,phone,email,diachi,id_typeOfCus));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }
}
