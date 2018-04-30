package com.cronos.dao;

import com.cronos.model.Employer;
import com.cronos.requestBody.CreateEmployerRequestBody;
import com.cronos.view.EmployerView;

/**
 * Created by toshikijahja on 10/18/17.
 */
public class EmployerDao extends BaseDao<Employer> {

    public EmployerDao(final SessionProvider sessionProvider) {
        super(sessionProvider, Employer.class);
    }

    public EmployerView createEmployer(final CreateEmployerRequestBody createEmployerRequestBody) {
        getSessionProvider().startTransaction();
        final Employer employer = new Employer.Builder()
                .name(createEmployerRequestBody.getName())
                .logoUrl(createEmployerRequestBody.getLogoUrl())
                .city(createEmployerRequestBody.getCity())
                .province(createEmployerRequestBody.getProvince())
                .companySize(createEmployerRequestBody.getCompanySize())
                .build();
        getSessionProvider().getSession().save(employer);
        getSessionProvider().commitTransaction();
        return new EmployerView(employer);
    }
}
