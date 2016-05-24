package Dao;

import Enity.User;
import Util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by wangda on 16/5/18.
 */
public class UserDaoImpl implements UserDao {

    public void save(User user) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            HibernateUtil.closeSession();
        }
    }
    public User findbyId(int id) {

        User user = null;
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        try {
            user = (User)session.get(User.class,id);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            HibernateUtil.closeSession();
        }
        return user;
    }

    public void delete(User user) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(user);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            HibernateUtil.closeSession();
        }

    }


    public void upDate(User user) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(user);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            HibernateUtil.closeSession();
        }
    }
}
