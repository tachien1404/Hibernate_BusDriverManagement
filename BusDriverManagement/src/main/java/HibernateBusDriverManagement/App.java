package HibernateBusDriverManagement;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println(fac);
        System.out.println(fac.isClosed());
    }
}
