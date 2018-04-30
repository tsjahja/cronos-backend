package com.cronos.view;

import com.cronos.model.JobEntry;

/**
 * Created by toshikijahja on 11/14/17.
 */
public class JobEntryView {

    private final JobEntry jobEntry;

    public JobEntryView(final JobEntry jobEntry) {
        this.jobEntry = jobEntry;
    }

    public int getId() {
        return jobEntry.getId();
    }

    public JobView getJob() {
        return new JobView(jobEntry.getJob());
    }

    public JobEntry.Status getStatus() {
        return jobEntry.getStatus();
    }
}
