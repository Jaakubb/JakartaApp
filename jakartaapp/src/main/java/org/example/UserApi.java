package org.example;

import jakarta.ejb.EJB;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.sql.SQLException;
import java.util.logging.Logger;


@Path("/user")
public class UserApi {

    private static final Logger logger = Logger.getLogger(UserApi.class.getName());

    @EJB
    private UserService userService;

    @POST
    @Path("/register")
    public String registerUser(User user) throws SQLException {
        //wywoływać serwis

        return userService.registeruser(user);
    }

    @POST
    @Path("/delete")
    public String deleteUser(User user) throws SQLException{

        return userService.deleteuser(user);
    }

}
