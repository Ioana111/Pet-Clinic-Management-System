package com.sda.ioana.petclinic.repository;

import com.sda.ioana.petclinic.model.Consult;
import com.sda.ioana.petclinic.repository.base.BaseRepositoryImpl;

public class ConsultRepositoryImpl extends BaseRepositoryImpl<Consult, Long> implements ConsultRepository {
    public ConsultRepositoryImpl() {
        super(Consult.class);
    }
}
