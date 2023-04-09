package kr.ac.jejunu.user;

import java.sql.*;
import javax.sql.DataSource;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User findById(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new FindStatmentStrategy(id);
        return jdbcContext.jdbcContextForFind(statementStrategy);
    }

    public void insert(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new InsertStatementStrategy(user);
        jdbcContext.jdbcContextForInsert(user, statementStrategy);
    }

    public void update(User user) throws SQLException, ClassNotFoundException {
        StatementStrategy statementStrategy = new UpdateStatementStrategy(user);
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

    public void delete(Long id) throws SQLException, ClassNotFoundException {
        StatementStrategy statementStrategy = new DeleteStatementStartegy(id);
        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

//    abstract public Connection getConnection() throws ClassNotFoundException, SQLException;
//    public Connection getConnection() throws ClassNotFoundException, SQLException {
//        //데이터 어딨어? mysql
//        //mysql 클래스 로딩
//        //Connection 맺고
//        //쿼리 만들고
//        return connectionMaker.getConnection();
//    }

}
