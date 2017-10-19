package com.cronos.model;

import org.hibernate.annotations.Type;

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
    private String email;

    @Column
    @Type(type="date")
    private Date birthday;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column (columnDefinition = "tinyint default false")
    private boolean liner = false;

    public enum Gender {
        MALE, FEMALE;
    }

    public User() {

    }

    public User(final Builder builder) {
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setEmail(builder.email);
        setBirthday(builder.birthday);
        setGender(builder.gender);
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private Date birthday;
        private Gender gender;

        public Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder birthday(final Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder gender(final Gender gender) {
            this.gender = gender;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}