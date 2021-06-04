package employee.model.repository;

import customers.model.bean.CustomerType;
import employee.model.bean.Division;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DivisionRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_DIVISION = "select division_name from division where division_id =?";

    public Division selectDivision(int id){
        Connection connection = baseRepository.getConnection();
        PreparedStatement statement =null;
        Division division = null;

        try {
            statement = connection.prepareStatement(SELECT_DIVISION);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString("division_name");
                division = new Division(id,name);

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
        return division;
    }
}
