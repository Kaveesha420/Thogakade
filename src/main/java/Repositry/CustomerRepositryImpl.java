package Repositry;

import Model.dto.CustomerDto;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CustomerRepositryImpl implements CustomerRepositry {
    @Override
    public void addCustomer(CustomerDto customer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(customer);
            transaction.commit();
        }
    }

    @Override
    public void updateCustomer(CustomerDto customer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(customer);
            transaction.commit();
        }
    }

    @Override
    public void deleteCustomer(String cusId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CustomerDto customer = session.getReference(CustomerDto.class, cusId);
            if (customer != null) session.remove(customer);
            transaction.commit();
        }
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM CustomerDto", CustomerDto.class).list();
        }
    }
}