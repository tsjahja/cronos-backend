package com.cronos.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by toshikijahja on 10/31/17.
 */
@Entity
@Table
public class JobEntry implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobId")
    private Job job;

    @Column
    private int userId;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status = Status.APPLIED;

    public enum Status {
        APPLIED,
        APPROVED,
        REJECTED
    }

    public JobEntry() {

    }

    public JobEntry(final Builder builder) {
        setJob(builder.job);
        setUserId(builder.userId);
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(final Job job) {
        this.job = job;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(final int userId) {
        this.userId = userId;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public static class Builder {
        private Job job;
        private int userId;
        private Status status;

        public Builder job(final Job job) {
            this.job = job;
            return this;
        }

        public Builder userId(final int userId) {
            this.userId = userId;
            return this;
        }

        public Builder status(final Status status) {
            this.status = status;
            return this;
        }

        public JobEntry build() {
            return new JobEntry(this);
        }
    }

}

