package com.hitema;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnection {
    static Session currentSession;

    public Session getCurrentSession() {
        if ( ! ( currentSession != null && currentSession.isOpen()))
            currentSession=openCurrentSession();
        return currentSession;
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    private SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration().configure();
        return cfg.buildSessionFactory();
    }
}
