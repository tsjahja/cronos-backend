package com.cronos.source;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.cronos.dao.SessionProvider;
import com.cronos.dao.UserDao;
import com.cronos.model.User;
import com.cronos.requestBody.CreateUserRequestBody;
import com.cronos.view.UserView;

@Path("/user")
public class UserSource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserView createUser(final CreateUserRequestBody createUserRequestBody) {
        try (final SessionProvider sessionProvider = new SessionProvider()) {
            final UserDao userDao = new UserDao(sessionProvider);
            return userDao.createUser(createUserRequestBody);
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserView getUser(@PathParam("id") final int id) {
        try (final SessionProvider sessionProvider = new SessionProvider()) {
            final UserDao userDao = new UserDao(sessionProvider);
            System.out.println("userDao:" + userDao);
            System.out.println("sessionProvider:" + sessionProvider);
            System.out.println("id:" + id);

            final User user = userDao.getById(id);
            System.out.println("user:" + user);
            return new UserView(user);
        }
    }
}