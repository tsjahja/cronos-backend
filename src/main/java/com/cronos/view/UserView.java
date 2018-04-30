package com.cronos.view;

import com.cronos.model.User;

import java.time.Instant;
import java.util.Date;

/**
 * Created by toshikijahja on 10/18/17.
 */
public class UserView {

    private final User user;

    public UserView(final User user) {
        this.user = user;
    }

    public int getId() {
        return user.getId();
    }

    public String getFirstName() {
        return user.getFirstName();
    }

    public String getLastName() {
        return user.getLastName();
    }

    public String getResumeUrl() {
        return user.getResumeUrl();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public int getStandingYear() {
        return user.getStandingYear();
    }

    public User.Degree getGender() {
        return user.getDegree();
    }

    public Date getBirthDate() {
        return user.getBirthDate();
    }
}
