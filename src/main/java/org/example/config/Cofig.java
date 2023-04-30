package org.example.config;

import jakarta.persistence.EntityManager;
import org.example.entities.Course;
import org.example.entities.Instructor;
import org.example.entities.Lesson;
import org.example.entities.Task;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;

import static org.hibernate.cfg.AvailableSettings.*;

public class Cofig {
        public static EntityManager getEntityManagerFactory() {
                try {
                        Configuration configuration = new Configuration();
                        configuration.setProperty(DRIVER, "org.postgresql.Driver");
                        configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/java-9");
                        configuration.setProperty(USER, "postgres");
                        configuration.setProperty(PASS, "1234");
                        configuration.setProperty(HBM2DDL_AUTO, "update");
                        configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                        configuration.setProperty(SHOW_SQL, "true");
                        configuration.addAnnotatedClass(Course.class);
                        configuration.addAnnotatedClass(Task.class);
                        configuration.addAnnotatedClass(Lesson.class);
                        configuration.addAnnotatedClass(Instructor.class);
                        return configuration.buildSessionFactory().createEntityManager();
                } catch (
                       HibernateException e) {
                        System.out.println(e.getMessage());
                }
                return null;
        }


}

