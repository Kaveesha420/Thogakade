package Repositry;

import Model.dto.EmployeeDto;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeRepositryImpl implements EmployeeRepositry {
    @Override
    public void addEmployee(EmployeeDto employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        }
    }

    @Override
    public void updateEmployee(EmployeeDto employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployee(String employeeId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            EmployeeDto employee = session.getReference(EmployeeDto.class, employeeId);
            if (employee != null) session.remove(employee);
            transaction.commit();
        }
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM EmployeeDto", EmployeeDto.class).list();
        }
    }
}