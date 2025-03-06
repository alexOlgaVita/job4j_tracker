package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.toone.Role;

import java.util.List;

public class HbmRole {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    public Role add(Role role) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return role;
    }

    public void delete(int id) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery(
                            "DELETE Role WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public List<Role> findAll() {
        Session session = sf.openSession();
        Query query = session.createQuery("from Role");
        List<Role> result = query.list();
        session.close();
        return result;
    }

    public Role findById(int id) {
        Session session = sf.openSession();
        Query<Role> query = session.createQuery(
                "from Role as i where i.id = :fId", Role.class);
        query.setParameter("fId", id);
        Role result = query.uniqueResult();
        session.close();
        return result;
    }

    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}