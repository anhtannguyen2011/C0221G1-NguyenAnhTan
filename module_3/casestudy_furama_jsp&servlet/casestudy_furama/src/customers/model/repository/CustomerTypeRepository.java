package customers.model.repository;

import customers.model.bean.CustomerType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerTypeRepository {
   static BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_CUSTOMER_TYPE = "select ten_loai_khach from loai_khach where id_loai_khach = ?";

    public CustomerType selectCustomerType(int id){
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        CustomerType customerType = null;
            try {
                preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE);
                preparedStatement.setInt(1,id);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    String name = rs.getString("ten_loai_khach");
                    customerType = new CustomerType(id,name);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        return customerType;
    }
}
