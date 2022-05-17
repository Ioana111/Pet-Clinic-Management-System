package com.sda.ioana.petclinic.repository;

import com.sda.ioana.petclinic.model.Vet;
import com.sda.ioana.petclinic.repository.base.BaseRepositoryImpl;

public class VetRepositoryImpl extends BaseRepositoryImpl<Vet, Long> implements VetRepository{
    public VetRepositoryImpl() {
        super(Vet.class);
    }
}
