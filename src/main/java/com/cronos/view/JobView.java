package com.cronos.view;

import com.cronos.model.Job;

import java.util.Date;

/**
 * Created by toshikijahja on 10/18/17.
 */
public class JobView {

    private final Job job;

    public JobView(final Job job) {
        this.job = job;
    }

    public int getId() {
        return job.getId();
    }

    public String getTitle() {
        return job.getTitle();
    }

    public EmployerView getEmployer() {
        return new EmployerView(job.getEmployer());
    }

    public Job.Type getType() {
        return job.getType();
    }

    public boolean isPaid() {
        return job.isPaid();
    }

    public String getCity() {
        return job.getCity();
    }

    public String getProvince() {
        return job.getProvince();
    }

    public String getRequirement() {
        return job.getRequirement();
    }

    public String getDescription() {
        return job.getDescription();
    }

    public Date getDeadline() {
        return job.getDeadline();
    }
}
