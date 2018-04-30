package com.cronos.source;

import com.cronos.dao.EmployerDao;
import com.cronos.dao.SessionProvider;
import com.cronos.model.Employer;
import com.cronos.requestBody.CreateEmployerRequestBody;
import com.cronos.view.EmployerView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by toshikijahja on 10/18/17.
 */
@Path("/employer")
public class EmployerSource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public EmployerView createEmployer(final CreateEmployerRequestBody createEmployerRequestBody) {
        try (final SessionProvider sessionProvider = new SessionProvider()) {
            final EmployerDao employerDao = new EmployerDao(sessionProvider);
            return employerDao.createEmployer(createEmployerRequestBody);
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmployerView getEmployer(@PathParam("id") final int id) {
        try (final SessionProvider sessionProvider = new SessionProvider()) {
            final EmployerDao employerDao = new EmployerDao(sessionProvider);
            final Employer employer = employerDao.getById(id);
            return new EmployerView(employer);
        }
    }
}
