package employee.model.repository;

import employee.model.bean.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PositonRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_POSITION = "select position_name from `position` where position_id =?";

    public Position selectPosition(int id){
        Connection connection = baseRepository.getConnection();
        PreparedStatement statement = null;
        Position position = null;

        try {
            statement = connection.prepareStatement(SELECT_POSITION);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                String name = rs.getString("position_name");
                position = new Position(id,name);
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
        return position;
    }
}
