package com.sda.ioana.petclinic.repository;

import com.sda.ioana.petclinic.model.Pet;
import com.sda.ioana.petclinic.model.Vet;
import com.sda.ioana.petclinic.repository.base.BaseRepositoryImpl;
import com.sda.ioana.petclinic.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class VetRepositoryImpl extends BaseRepositoryImpl<Vet, Long> implements VetRepository {
    public VetRepositoryImpl() {
        super(Vet.class);
    }

    @Override
    public List<Vet> findByMultipleParameters(String firstName, String lastName, String address, String speciality) {
        try {
            Session session = SessionManager.getSessionFactory().openSession();
            String query = "FROM Vet v WHERE";
            if (firstName != null && !firstName.isBlank() ) {
                query += " v.firstName =:firstName";
            }else{
                query += " v.id is not null";
            }
            query += " AND ";
            if (lastName != null && !lastName.isBlank()) {
                query += " v.lastName =:lastName";
            }else{
                query += " v.id is not null";
            }
            query += " AND ";
            if (address != null && !address.isBlank()) {
                query += " v.address =:address";
            }else{
                query += " v.id is not null";
            }
            query += " AND ";
            if (speciality != null && !speciality.isBlank()) {
                query += " v.speciality =:speciality";
            }else{
                query += " v.id is not null";
            }

            System.out.println(query);

            Query<Vet> query1 = session.createQuery(query, Vet.class);
            if (firstName != null && !firstName.isBlank()) {
                query1.setParameter("firstName", firstName);
            }
            if (lastName != null && !lastName.isBlank()) {
                query1.setParameter("lastName", lastName);
            }
            if (address != null && !address.isBlank() ) {
                query1.setParameter("address", address);
            }
            if (speciality != null && !speciality.isBlank()) {
                query1.setParameter("speciality", speciality);
            }

            List<Vet> vets = query1.list();


            session.close();
            return vets;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }


    }
}
