package services.model.repository;

import services.model.bean.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String INSERT_SERVICES = "insert into service" + "(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,strandard_room,description_other_convenience,pool_area,number_of_floor) values"
                                                    +" (?,?,?,?,?,?,?,?,?,?);";

    public void insertService(Service service) {
        Connection connection = baseRepository.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_SERVICES);
            statement.setString(1,service.getServiceName());
            statement.setInt(2,service.getServiceAre());
            statement.setDouble(3,service.getServiceCost());
            statement.setInt(4,service.getServiceMaxPeople());
            statement.setInt(5,service.getServiceRentTypeId().getRentTypeId());
            statement.setInt(6,service.getServiceTypeId().getServiceTypeId());
            statement.setString(7,service.getStandardRoom());
            statement.setString(8,service.getDescription());
            statement.setDouble(9,service.getPoolArea());
            statement.setInt(10,service.getNumberOfFloor());
            statement.executeUpdate();
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
    }
}
