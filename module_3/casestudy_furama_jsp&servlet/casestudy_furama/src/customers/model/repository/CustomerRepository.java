package customers.model.repository;

import customers.model.bean.CustomerType;
import customers.model.bean.Customers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
    private static final String SELECT_ALL_CUSTOMERS = "select * from khach_hang";
    private static final String INSERT_CUSTOMERS_SQL = "insert into khach_hang" + "(id_khach_hang,ho_ten,ngay_sinh,cmnd,so_dien_thoai,email,dia_chi,id_loai_khach) values" +
            "(?,?,?,?,?,?,?,?);";

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
                CustomerType nameType = customerTypeRepository.selectCustomerType(rs.getInt("id_loai_khach"));
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
    public void insertCustomer(Customers customers) throws SQLException {
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL);
            preparedStatement.setInt(1,customers.getId());
            preparedStatement.setString(2,customers.getName());
            preparedStatement.setString(3,customers.getDayOfBirth());
            preparedStatement.setInt(4,customers.getIdCard());
            preparedStatement.setInt(5,customers.getPhone());
            preparedStatement.setString(6,customers.getEmail());
            preparedStatement.setString(7,customers.getAddress());
            preparedStatement.setInt(8,customers.getCustomerType().getCustomerTypeId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            preparedStatement.close();
            connection.close();
        }
    }
}
