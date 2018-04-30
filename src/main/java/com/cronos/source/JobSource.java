package com.cronos.source;

import com.cronos.dao.JobDao;
import com.cronos.dao.SessionProvider;
import com.cronos.model.Job;
import com.cronos.requestBody.CreateJobRequestBody;
import com.cronos.view.JobView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by toshikijahja on 10/18/17.
 */
@Path("/job")
public class JobSource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public JobView createJob(final CreateJobRequestBody createJobRequestBody) {
        try (final SessionProvider sessionProvider = new SessionProvider()) {
            final JobDao itemDao = new JobDao(sessionProvider);
            return itemDao.createJob(createJobRequestBody);
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public JobView getJob(@PathParam("id") final int id) {
        try (final SessionProvider sessionProvider = new SessionProvider()) {
            final JobDao jobDao = new JobDao(sessionProvider);
            final Job job = jobDao.getById(id);
            return new JobView(job);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobView> getJobByEmployerId(@QueryParam("employerId") final int employerId) {
        try (final SessionProvider sessionProvider = new SessionProvider()) {
            final JobDao jobDao = new JobDao(sessionProvider);
            return jobDao.getByEmployerId(employerId);
        }
    }
}
