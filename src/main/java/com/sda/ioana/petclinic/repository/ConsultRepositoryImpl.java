package com.sda.ioana.petclinic.repository;

import com.sda.ioana.petclinic.model.Consult;
import com.sda.ioana.petclinic.repository.base.BaseRepositoryImpl;
import com.sda.ioana.petclinic.utils.SessionManager;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ConsultRepositoryImpl extends BaseRepositoryImpl<Consult, Long> implements ConsultRepository {
    public ConsultRepositoryImpl() {
        super(Consult.class);
    }

    @Override
    public List<Consult> findAllUnvaccinatedPets() {
        try{
            Session session = SessionManager.getSessionFactory().openSession();
            List<Consult> consults = session.createQuery("FROM Consult c WHERE c.pet.isVaccinated = false", Consult.class).list();

             session.close();
             return consults;
        }catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }


    }
}
