package Repositry;

import Model.dto.SupplierDto;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class SupplierRepositryImpl implements SupplierRepositry {
    @Override
    public void addSuplier(SupplierDto supplier) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(supplier);
            transaction.commit();
        }
    }

    @Override
    public void updateSuplier(SupplierDto supplier) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(supplier);
            transaction.commit();
        }
    }

    @Override
    public void deleteSuplier(String supId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            SupplierDto supplier = session.getReference(SupplierDto.class, supId);
            if (supplier != null) session.remove(supplier);
            transaction.commit();
        }
    }

    @Override
    public List<SupplierDto> getAllSupllier() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM SupplierDto", SupplierDto.class).list();
        }
    }
}