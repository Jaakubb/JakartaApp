package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Stateless
public class UserRepository implements UserRepositoryIn {
    @Resource(name = "jdbc/mysql")
    private DataSource dataSource;

    private Connection connection;

    @PostConstruct
    public void init() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addUser(User username) throws SQLException {
        connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO `user`(`username`, `password`) VALUES (?,?)");
        statement.setString(1, username.getUsername());
        statement.setString(2, username.getPassword());

        statement.executeUpdate();
    }

    @Override
    public void removeUser(String username) throws SQLException{
        connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement("DELETE FROM user WHERE username = ?");
        statement.setString(1, username);

        statement.executeUpdate();

    }
}
