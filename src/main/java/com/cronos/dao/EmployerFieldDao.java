package com.cronos.dao;

import com.cronos.model.EmployerField;

/**
 * Created by toshikijahja on 11/2/17.
 */
public class EmployerFieldDao extends BaseDao<EmployerField> {

    public EmployerFieldDao(final SessionProvider sessionProvider) {
        super(sessionProvider, EmployerField.class);
    }

}
