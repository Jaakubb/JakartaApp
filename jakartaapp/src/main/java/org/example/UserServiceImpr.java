package org.example;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.sql.SQLException;

@Stateless
public class UserServiceImpr implements UserService{
    @EJB
    private UserRepositoryIn userRepository;

    @Override
    public String registeruser(User user) throws SQLException {
        userRepository.addUser(user);
        return "Zarejstrowano użytkownika";
    }

    @Override
    public String deleteuser(User user) throws SQLException{
        userRepository.removeUser(user.getUsername());
        return "Usunięto użytkownika";
    }
}
