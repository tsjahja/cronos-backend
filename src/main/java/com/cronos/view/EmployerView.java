package com.cronos.view;

import com.cronos.model.Employer;

/**
 * Created by toshikijahja on 10/18/17.
 */
public class EmployerView {

    private final Employer employer;

    public EmployerView(final Employer employer) {
        this.employer = employer;
    }

    public String getName() {
        return employer.getName();
    }

    public String getLogoUrl() {
        return employer.getLogoUrl();
    }

    public String getCity() {
        return employer.getCity();
    }

    public String getProvince() {
        return employer.getProvince();
    }

    public Employer.CompanySize getCompanySize() {
        return employer.getCompanySize();
    }

    public String getCompanySizeDescription() {
        return employer.getCompanySize().getDescription();
    }
}
