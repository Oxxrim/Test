package org.kpi.fift.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.kpi.fift.pojo.User;
import org.kpi.fift.util.HibernateUtil;

import java.util.List;


public class UserDAO {
    private Session session;

    public synchronized User findUser(String login){

        session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        User user = session.get(User.class, login);

        session.getTransaction().commit();

        session.close();

        return user;
    }

    public void saveUser(User user){
        session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        session.saveOrUpdate(user);

        session.getTransaction().commit();

        session.close();
    }

    public void deleteUser(User user){
        session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        session.delete(user);

        session.getTransaction().commit();

        session.close();
    }

    public int checkForAdmin(){

        session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        Query query = session.createNativeQuery("select * from usr where role = 'admin'");
        List list = query.list();

        session.getTransaction().commit();

        session.close();

        return list.size();
    }

    public List<User> findAll(){
        session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        Query query = session.createNativeQuery("select * from usr", User.class);
        List<User> list = (List<User>) query.list();

        session.getTransaction().commit();

        session.close();

        return list;
    }
}
