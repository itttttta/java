package Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by wangda on 16/5/18.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    static {
        Configuration cfg = new Configuration().configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    public  static SessionFactory getSessionFactory(){
        return  sessionFactory;
    }

    public static Session getSession(){
        Session session = (Session) threadLocal.get();
        if(session == null || !session.isOpen())
        {
            if(sessionFactory == null)
            {
                rebuildSessionFactory();
            }
            session = (sessionFactory !=null)?sessionFactory.openSession():null;
            threadLocal.set(session);
        }
        return session;
    }
    public  static void closeSession(){
        Session session = (Session) threadLocal.get();
        threadLocal.set((null));
        if(session !=null)
        {
            session.close();
        }
    }
//    public Configuration configure (){
//        configure("hibernate.cfg.xml");
//        return this;
//    }
    public static void rebuildSessionFactory() {
        Configuration cfg = new Configuration().configure();
        cfg.configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
    }
    public static void shutDown(){
        getSessionFactory().close();
    }


}

