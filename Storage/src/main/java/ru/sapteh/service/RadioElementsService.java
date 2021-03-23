package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.RadioElements;

import java.util.List;

public class RadioElementsService implements DAO<RadioElements, Integer> {
    private final SessionFactory factory;

    public RadioElementsService(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public void create(RadioElements radioElements) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(radioElements);
            session.getTransaction().commit();
        }
    }
    @Override
    public void update(RadioElements radioElements) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(radioElements);
            session.getTransaction().commit();
        }
    }
    @Override
    public void delete(RadioElements radioElements) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(radioElements);
            session.getTransaction().commit();
        }
    }
    @Override
    public RadioElements read(Integer id) {
        try(Session session = factory.openSession()){
            return session.get(RadioElements.class, id);
        }
    }
    @Override
    public List<RadioElements> findByAll() {
        try(Session session = factory.openSession()){
            Query<RadioElements> query = session.createQuery("FROM RadioElements");
            return query.list();
        }
    }
}
