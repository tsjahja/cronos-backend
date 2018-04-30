package com.cronos.requestBody;

/**
 * Created by toshikijahja on 11/5/17.
 */
public class JobEntryRequestBody {

    private int userId;
    private int jobId;

    public JobEntryRequestBody() {

    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(final int userId) {
        this.userId = userId;
    }

    public int getJobId() {
        return this.jobId;
    }

    public void setJobId(final int jobId) {
        this.jobId = jobId;
    }
}
