package com.cronos.model;

import javax.persistence.*;

/**
 * Created by toshikijahja on 10/18/17.
 */
@Entity
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column
    private String logoUrl;

    @Column
    private String city;

    @Column
    private String province;

    @Column
    @Enumerated(EnumType.STRING)
    private CompanySize companySize;

    public enum CompanySize {
        MICRO("1-10"),
        SMALL("10-100"),
        MEDIUM("100-500"),
        LARGE("500-1000"),
        ENTERPRISE(">1000");

        private String description;
        CompanySize(final String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    public Employer() {

    }

    public Employer(final Builder builder) {
        setName(builder.name);
        setLogoUrl(builder.logoUrl);
        setCity(builder.city);
        setProvince(builder.province);
        setCompanySize(builder.companySize);
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
            this.id = id;
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

    public CompanySize getCompanySize() {
        return this.companySize;
    }

    public void setCompanySize(final CompanySize companySize) {
        this.companySize = companySize;
    }

    public static class Builder {
        private String name;
        private String logoUrl;
        private String city;
        private String province;
        private CompanySize companySize;

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder logoUrl(final String logoUrl) {
            this.logoUrl = logoUrl;
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

        public Builder companySize(final CompanySize companySize) {
            this.companySize = companySize;
            return this;
        }

        public Employer build() {
            return new Employer(this);
        }
    }
}
