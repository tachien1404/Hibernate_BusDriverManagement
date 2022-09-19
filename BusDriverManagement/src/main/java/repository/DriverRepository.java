package repository;

import org.hibernate.Session;

import entity.Driver;
import util.DataUtil;
import util.HibernateUtil;

import java.util.List;

public class DriverRepository {

    public List<Driver> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Driver", Driver.class).list();
    }

    public void saveAll(List<Driver> drivers) {
        if (DataUtil.isEmptyCollection(drivers)) {
            return;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        try {
            for (Driver driver : drivers) {
                session.save(driver);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
    }

    public Driver findById(int driverId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Driver where id = :p_id", Driver.class)
                .setParameter("p_id", (long) driverId)
                .getSingleResult();
    }
}
