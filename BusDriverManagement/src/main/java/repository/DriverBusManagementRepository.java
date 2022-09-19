package repository;


import org.hibernate.Session;

import entity.DriverBusManagement;
import util.DataUtil;
import util.HibernateUtil;

import java.util.List;

public class DriverBusManagementRepository {


    public List<DriverBusManagement> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from DriverBusManagement", DriverBusManagement.class).list();
    }

    public void saveAll(List<DriverBusManagement> toEntity) {
        if (DataUtil.isEmptyCollection(toEntity)) {
            return;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        try {
            for (DriverBusManagement driverBusManagement : toEntity) {
                session.save(driverBusManagement);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();

    }
}
