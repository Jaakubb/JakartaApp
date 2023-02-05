package org.example;

import jakarta.ejb.Local;

import java.sql.SQLException;

@Local
public interface UserService {

    public String registeruser (User user) throws SQLException;

    public String deleteuser(User user) throws SQLException;

}
