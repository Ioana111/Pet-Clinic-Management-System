package com.sda.ioana.petclinic.utils;

import com.sda.ioana.petclinic.model.Client;
import com.sda.ioana.petclinic.model.Consult;
import com.sda.ioana.petclinic.model.Pet;
import com.sda.ioana.petclinic.model.Vet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionManager extends AbstractSessionManager {

    private static final SessionManager INSTANCE = new SessionManager();

    private SessionManager() {

    }

    public static SessionFactory getSessionFactory() {
        return INSTANCE.getSessionFactory("pet_clinic");
    }

    public static void shutdown() {
        INSTANCE.shutdownSessionManager();

    }

    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
        //add model classes here
        configuration.addAnnotatedClass(Vet.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Pet.class);
        configuration.addAnnotatedClass(Consult.class);
    }
}
