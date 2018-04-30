package com.cronos.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by toshikijahja on 11/2/17.
 */
@Entity
public class EmployerField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employerId")
    private Employer employer;

    @Column
    @Enumerated(EnumType.STRING)
    private Field field;

    public enum Field {
        COMPLETED,
        FAILED,
    }

    public EmployerField() {

    }

    public EmployerField(final Builder builder) {
        setEmployer(builder.employer);
        setField(builder.field);
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Employer getEmployer() {
        return this.employer;
    }

    public void setEmployer(final Employer employer) {
        this.employer = employer;
    }

    public Field getField() {
        return this.field;
    }

    public void setField(final Field field) {
        this.field = field;
    }

    public static class Builder {
        private Employer employer;
        private Field field;

        public Builder employer(final Employer employer) {
            this.employer = employer;
            return this;
        }

        public Builder field(final Field field) {
            this.field = field;
            return this;
        }

        public EmployerField build() {
            return new EmployerField(this);
        }
    }
}
