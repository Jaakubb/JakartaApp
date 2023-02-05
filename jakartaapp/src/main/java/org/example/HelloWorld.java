package org.example;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Path("/")
@Stateless
public class HelloWorld {



    private  Connection connection;
    private DataSource dataSource;



    @GET
    public String getData() {
        return "data";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addUser(User username) throws SQLException {
        connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO `user`(`username`, `password`) VALUES (?,?)");
        statement.setString(1, username.getUsername());
        statement.setString(2, username.getPassword());

        statement.executeUpdate();


        return username.getUsername() + username.getPassword();

    }
}
