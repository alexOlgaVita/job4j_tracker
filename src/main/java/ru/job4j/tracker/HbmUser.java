package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.toone.User;

import java.util.List;

public class HbmUser {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    public User add(User user) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return user;
    }

    public void delete(int id) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery(
                            "DELETE User WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public List<User> findAll() {
        Session session = sf.openSession();
        Query query = session.createQuery("from User");
        List<User> result = query.list();
        session.close();
        return result;
    }

    public User findById(int id) {
        Session session = sf.openSession();
        Query<User> query = session.createQuery(
                "from User as i where i.id = :fId", User.class);
        query.setParameter("fId", id);
        User result = query.uniqueResult();
        session.close();
        return result;
    }

    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}