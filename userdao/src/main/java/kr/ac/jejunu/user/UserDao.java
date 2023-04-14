package kr.ac.jejunu.user;

import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User findById(Long id) throws SQLException, ClassNotFoundException {

        Object[] params = new Object[]{id};
        String sql = "select id, name, password from user where id = ?";
        return jdbcContext.find(params, sql);
    }

    public void insert(User user) throws ClassNotFoundException, SQLException {
        String sql = "insert into user (name, password) values (?,?)";
        Object[] params = new Object[]{user.getName(), user.getPassword()};
        jdbcContext.insert(user, sql, params);
    }

    public void update(User user) throws SQLException, ClassNotFoundException {
        String sql = "update user set name = ?, password = ? where id = ?";
        Object[] params = new Object[]{user.getName(), user.getPassword(), user.getId()};
        jdbcContext.update(sql, params);
    }

    public void delete(Long id) throws SQLException, ClassNotFoundException {
        String sql = "delete from user where id = ?";
        Object[] params = new Object[]{id};
        jdbcContext.update(sql, params);
    }
}
