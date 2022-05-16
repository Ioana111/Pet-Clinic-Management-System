package com.sda.ioana.petclinic;

import com.sda.ioana.petclinic.utils.SessionManager;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        //temporary change until we have the repository impl
        SessionManager.getSessionFactory().openSession();



    }
}
