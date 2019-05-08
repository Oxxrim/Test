package org.kpi.fift.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kpi.fift.pojo.User;

public class HibernateUtil {

    private static SessionFactory sessionFactory = configureSessionFactory();

    private static SessionFactory configureSessionFactory() throws HibernateException {

        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(User.class);

        return configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
