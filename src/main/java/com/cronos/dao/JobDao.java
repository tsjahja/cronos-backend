package com.cronos.dao;

import com.cronos.model.Job;
import com.cronos.model.Employer;
import com.cronos.requestBody.CreateJobRequestBody;
import com.cronos.view.JobView;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by toshikijahja on 10/18/17.
 */
public class JobDao extends BaseDao<Job> {

    private final EmployerDao employerDao;

    public JobDao(final SessionProvider sessionProvider) {
        super(sessionProvider, Job.class);
        this.employerDao = new EmployerDao(getSessionProvider());
    }

    public JobView createJob(final CreateJobRequestBody createJobRequestBody) {
        getSessionProvider().startTransaction();
        final Employer employer = employerDao.getById(createJobRequestBody.getEmployerId());
        final Job job = new Job.Builder()
                .title(createJobRequestBody.getTitle())
                .employer(employer)
                .type(createJobRequestBody.getType())
                .paid(createJobRequestBody.isPaid())
                .city(createJobRequestBody.getCity())
                .province(createJobRequestBody.getProvince())
                .requirement(createJobRequestBody.getRequirement())
                .description(createJobRequestBody.getDescription())
                .deadline(createJobRequestBody.getDeadline())
                .build();
        getSessionProvider().getSession().save(job);
        getSessionProvider().commitTransaction();
        return new JobView(job);
    }

    public List<JobView> getByEmployerId(final int employerId) {
        final Criteria criteria = getSessionProvider().getSession().createCriteria(Job.class);
        criteria.createAlias("employer", "employer");
        criteria.add(Restrictions.eq("employer.id", employerId));
        @SuppressWarnings("unchecked")
        final List<Job> items = (List<Job>) criteria.list();
        return items.stream().map(JobView::new).collect(Collectors.toList());
    }
}
