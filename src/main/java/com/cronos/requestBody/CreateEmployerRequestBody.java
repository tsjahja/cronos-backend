package com.cronos.requestBody;

import com.cronos.model.Employer;

/**
 * Created by toshikijahja on 10/18/17.
 */
public class CreateEmployerRequestBody {
    private String name;
    private String logoUrl;
    private String city;
    private String province;
    private Employer.CompanySize companySize;

    public CreateEmployerRequestBody() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public void setLogoUrl(final String logoUrl) {
        this.logoUrl = logoUrl;
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

    public Employer.CompanySize getCompanySize() {
        return this.companySize;
    }

    public void setCompanySize(final Employer.CompanySize companySize) {
        this.companySize = companySize;
    }
}
