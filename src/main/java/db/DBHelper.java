package db;

import models.Player;
import models.Team;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void saveOrUpdate(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    public static <T> T getUniqueResult(Criteria cr) {
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T)cr.uniqueResult();
            transaction.commit();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return result;
    }

    public static <T> List<T> getList(Criteria cr) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = cr.list();
            transaction.commit();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return results;

    }

    public static <T> T findById(Class classType, int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria cr = session.createCriteria(classType);
        cr.add(Restrictions.idEq(id));
        result = getUniqueResult(cr);
        return result;

    }

    public static <T> List<T> getAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria cr = session.createCriteria(classType);
        results = getList(cr);
        return results;
    }

    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        }
        catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    public static List<Player> getPlayersFromTeam(Team team) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Player> results = null;
        Criteria cr = session.createCriteria(Player.class);
        cr.add(Restrictions.eq("team", team));
        results = getList(cr);
        return results;

    }



}
