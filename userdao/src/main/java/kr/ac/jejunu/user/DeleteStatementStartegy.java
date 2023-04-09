package kr.ac.jejunu.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatementStartegy implements StatementStrategy {
    private Long id;

    public DeleteStatementStartegy(Long id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException, SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id = ?");
        preparedStatement.setLong(1, id);
        return preparedStatement;

    }
}
