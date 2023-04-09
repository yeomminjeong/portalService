package kr.ac.jejunu.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FindStatmentStrategy implements StatementStrategy {
    private Long id;
    public FindStatmentStrategy(Long id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select id, name, password from user where id = ?");
        preparedStatement.setLong(1,  id);

        return preparedStatement;
    }
}
