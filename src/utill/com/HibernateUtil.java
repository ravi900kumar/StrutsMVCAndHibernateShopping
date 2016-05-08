package utill.com;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
 
@SuppressWarnings("deprecation")
public class HibernateUtil {
    private static SessionFactory sessionFactory;
     
    static{
     try{
      sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
     }catch (Throwable ex) {
      System.err.println("Initial sessionFactory creation failed."+ex);
      throw new ExceptionInInitializerError(ex);
  
  }
    }
 
    public static SessionFactory getSessionFactory() {
   
        return sessionFactory;
    }
}