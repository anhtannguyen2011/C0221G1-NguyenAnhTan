package services.model.repository;

import employee.model.bean.*;
import services.model.bean.RentType;
import services.model.bean.Service;
import services.model.bean.ServiceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    RentTypeRepository rentTypeRepository = new RentTypeRepository();
    ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepository();
    private static final String INSERT_SERVICES = "insert into service" + "(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,strandard_room,description_other_convenience,pool_area,number_of_floor) values"
            + " (?,?,?,?,?,?,?,?,?,?);";

    private static final String SELECT_ALL_SERVICES = "select * from service";

    public void insertService(Service service) {
        Connection connection = baseRepository.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_SERVICES);
            statement.setString(1, service.getServiceName());
            statement.setInt(2, service.getServiceAre());
            statement.setDouble(3, service.getServiceCost());
            statement.setInt(4, service.getServiceMaxPeople());
            statement.setInt(5, service.getServiceRentTypeId().getRentTypeId());
            statement.setInt(6, service.getServiceTypeId().getServiceTypeId());
            statement.setString(7, service.getStandardRoom());
            statement.setString(8, service.getDescription());
            statement.setDouble(9, service.getPoolArea());
            statement.setInt(10, service.getNumberOfFloor());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public List<Service> selectAllService() {
        Connection connection = baseRepository.getConnection();
        PreparedStatement statement = null;
        List<Service> serviceList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(SELECT_ALL_SERVICES);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("service_id");
                String name = rs.getString("service_name");
                int area = rs.getInt("service_area");
                double cost = rs.getDouble("service_cost");
                int maxPeople = rs.getInt("service_max_people");
                RentType idRent = rentTypeRepository.findByRentType(rs.getInt("rent_type_id"));
                ServiceType idServiceType = serviceTypeRepository.findByIdType(rs.getInt("service_type_id"));
                String standard = rs.getString("strandard_room");
                String des = rs.getString("description_other_convenience");
                double poolArea = rs.getDouble("pool_area");
                int numberOfFloor = rs.getInt("number_of_floor");
                serviceList.add(new Service(id,name,area,cost,maxPeople,idRent,idServiceType,standard,des,poolArea,numberOfFloor));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return serviceList;
    }

}