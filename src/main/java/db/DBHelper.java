package db;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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

    public static <T> T findById(Class classType, int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria cr = session.createCriteria(classType);
        cr.add(Restrictions.idEq(id));
        result = (T)cr.uniqueResult();
        return result;

    }




}
