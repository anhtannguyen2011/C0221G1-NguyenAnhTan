package contract.model.repository;

import contract.model.bean.Contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContractRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String INSERT_CONTRACT_SQL = "insert into contract" + "(contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id) values"
                                        + "(?,?,?,?,?,?,?)";

    public void insertContract(Contract contract){
        Connection connection = baseRepository.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(INSERT_CONTRACT_SQL);
            statement.setString(1,contract.getContractStartDate());
            statement.setString(2,contract.getContractEndDate());
            statement.setDouble(3,contract.getDeposit());
            statement.setDouble(4,contract.getTotalMoney());
            statement.setInt(5,contract.getEmployeeId().getEmployeeId());
            statement.setInt(6,contract.getCustomersId().getCustomerId());
            statement.setInt(7,contract.getServiceId().getServiceId());
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
