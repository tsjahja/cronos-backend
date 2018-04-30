package com.cronos.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by toshikijahja on 7/29/17.
 */
@Entity
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employerId")
    private Employer employer;

    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column
    private boolean paid;

//    @OneToMany(mappedBy = "item")
//    private Set<OrderJob> orderJobs = new HashSet<OrderJob>();

    @Column
    private String city;

    @Column
    private String province;

    @Column(columnDefinition = "text")
    private String requirement;

    @Column(columnDefinition = "text")
    private String description;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline = null;

    public enum Type {
        FULL_TIME,
        PART_TIME,
        INTERN,
        ON_CAMPUS,
        CO_OP
    }

    public Job() {

    }

    public Job(final Builder builder) {
        setTitle(builder.title);
        setEmployer(builder.employer);
        setType(builder.type);
        setPaid(builder.paid);
        setCity(builder.city);
        setProvince(builder.province);
        setRequirement(builder.requirement);
        setDescription(builder.description);
        setDeadline(builder.deadline);
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Employer getEmployer() {
        return this.employer;
    }

    public void setEmployer(final Employer employer) {
        this.employer = employer;
    }

    public Type getType() {
        return type;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    public boolean isPaid() {
        return this.paid;
    }

    public void setPaid(final boolean paid) {
        this.paid = paid;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(final String province) {
        this.province = province;
    }

    public String getRequirement() {
        return this.requirement;
    }

    public void setRequirement(final String requirement) {
        this.requirement = requirement;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return this.deadline;
    }

    public void setDeadline(final Date deadline) {
        this.deadline = deadline;
    }

    public static class Builder {
        private String title;
        private Employer employer;
        private Type type;
        private boolean paid;
        private String city;
        private String province;
        private String requirement;
        private String description;
        private Date deadline;

        public Builder title(final String title) {
            this.title = title;
            return this;
        }

        public Builder employer(final Employer employer) {
            this.employer = employer;
            return this;
        }

        public Builder type(final Type type) {
            this.type = type;
            return this;
        }

        public Builder paid(final boolean paid) {
            this.paid = paid;
            return this;
        }

        public Builder city(final String city) {
            this.city = city;
            return this;
        }

        public Builder province(final String province) {
            this.province = province;
            return this;
        }

        public Builder requirement(final String requirement) {
            this.requirement = requirement;
            return this;
        }

        public Builder description(final String description) {
            this.description = description;
            return this;
        }

        public Builder deadline(final Date deadline) {
            this.deadline = deadline;
            return this;
        }

        public Job build() {
            return new Job(this);
        }
    }
}
