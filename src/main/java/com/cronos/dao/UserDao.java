package com.cronos.dao;

import com.cronos.model.User;
import com.cronos.requestBody.CreateUserRequestBody;
import com.cronos.view.UserView;

/**
 * Created by toshikijahja on 6/7/17.
 */
public class UserDao extends BaseDao<User> {

    public UserDao(final SessionProvider sessionProvider) {
        super(sessionProvider, User.class);
    }

    public UserView createUser(final CreateUserRequestBody createUserRequestBody) {
        getSessionProvider().startTransaction();
        final User user = new User.Builder()
                .firstName(createUserRequestBody.getFirstName())
                .lastName(createUserRequestBody.getLastName())
                .resumeUrl(createUserRequestBody.getResumeUrl())
                .email(createUserRequestBody.getEmail())
                .standingYear(createUserRequestBody.getStandingYear())
                .degree(createUserRequestBody.getDegree())
                .birthDate(new java.util.Date(createUserRequestBody.getBirthDate()))
                .build();
        getSessionProvider().getSession().save(user);
        getSessionProvider().commitTransaction();
        return new UserView(user);
    }
}
