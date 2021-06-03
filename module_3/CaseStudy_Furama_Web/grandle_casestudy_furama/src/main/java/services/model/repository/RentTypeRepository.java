package services.model.repository;

import services.model.bean.RentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RentTypeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_BY_RENT_TYPEID = "select * from rent_type where rent_type_id=?";

    public RentType findByRentType(int id){
        Connection connection = baseRepository.getConnection();
        PreparedStatement statement = null;
        RentType rentType =null;

        try {
            statement = connection.prepareStatement(SELECT_BY_RENT_TYPEID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString("rent_type_name");
                double cost = rs.getDouble("rent_type_cost");
                rentType = new RentType(id,name,cost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return rentType;
    }
}
