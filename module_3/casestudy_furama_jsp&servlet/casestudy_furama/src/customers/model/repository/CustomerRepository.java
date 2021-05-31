package customers.model.repository;

import customers.model.bean.CustomerType;
import customers.model.bean.Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_CUSTOMERS = "select * from khach_hang";

    public List<Customers> selectAllCustomers() {
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        List<Customers> customers = new ArrayList<>();
        try{
            preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id_khach_hang");
                String name = rs.getString("ho_ten");
                String dayOfBirth = rs.getString("ngay_sinh");
                int idCard = rs.getInt("cmnd");
                int phone = rs.getInt("so_dien_thoai");
                String email = rs.getString("email");
                String diachi = rs.getString("dia_chi");
                CustomerType nameType = CustomerTypeRepository.selectCustomerType(rs.getInt("id_loai_khach"));
                customers.add(new Customers(id,name,dayOfBirth,idCard,phone,email,diachi,nameType));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customers;
    }
}
