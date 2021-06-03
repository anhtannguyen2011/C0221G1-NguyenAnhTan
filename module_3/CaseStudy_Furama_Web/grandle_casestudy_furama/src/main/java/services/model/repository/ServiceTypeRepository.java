package services.model.repository;

import services.model.bean.ServiceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceTypeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_BY_TYPE_SERVICEID = "select * from service_type where id =?";

    public ServiceType findByIdType(int id){
        Connection connection = baseRepository.getConnection();
        ServiceType serviceType = null;
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(SELECT_BY_TYPE_SERVICEID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString("service_type_name");
                serviceType = new ServiceType(id,name);
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
        return serviceType;
    }
}
