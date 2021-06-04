package employee.model.repository;

import employee.model.bean.EducationDegree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EducationDegreeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_EDUCATION = "select education_degree_name from education_degree where education_degree_id =?";

    public EducationDegree selectEducation(int id){
        Connection connection = baseRepository.getConnection();
        PreparedStatement statement = null;
        EducationDegree educationDegree = null;

        try {
            statement = connection.prepareStatement(SELECT_EDUCATION);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString("education_degree_name");
                educationDegree = new EducationDegree(id,name);
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
            ;

        }
        return educationDegree;
    }

}
