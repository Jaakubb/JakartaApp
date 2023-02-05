package org.example;

import jakarta.ejb.Local;

import java.sql.SQLException;

@Local
public interface UserRepositoryIn {
    void addUser(User username) throws SQLException;

    void removeUser(String username) throws SQLException;
}
