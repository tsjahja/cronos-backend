package com.cronos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String resumeUrl;

    @Column
    private String email;

    @Column
    private int standingYear;

    @Column
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate = null;

    public enum Degree {
        ASSOCIATE,
        BACHELOR,
        MASTERS,
        PHD
    }

    public User() {

    }

    public User(final Builder builder) {
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setResumeUrl(builder.resumeUrl);
        setEmail(builder.email);
        setStandingYear(builder.standingYear);
        setDegree(builder.degree);
        setBirthDate(builder.birthDate);
    }

    public int getId() {
        return this.id;
    }

    public void setId() {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getResumeUrl() {
        return this.resumeUrl;
    }

    public void setResumeUrl(final String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public int getStandingYear() {
        return this.standingYear;
    }

    public void setStandingYear(final int standingYear) {
        this.standingYear = standingYear;
    }

    public Degree getDegree() {
        return this.degree;
    }

    public void setDegree(final Degree degree) {
        this.degree = degree;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String resumeUrl;
        private String email;
        private int standingYear;
        private Degree degree;
        private Date birthDate;

        public Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder resumeUrl(final String resumeUrl) {
            this.resumeUrl = resumeUrl;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder standingYear(final int standingYear) {
            this.standingYear = standingYear;
            return this;
        }

        public Builder degree(final Degree degree) {
            this.degree = degree;
            return this;
        }

        public Builder birthDate(final Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}