package repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.config.Cofig;
import org.example.entities.Course;
import org.hibernate.Session;
import repository.CourseRepository;


import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {
    public final EntityManager entityManager = Cofig.getEntityManagerFactory();
    public String saveCourse(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "save...";
    }

    @Override
    public Course getCourseById(Long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.createQuery("SELECT c FROM Course c WHERE c.id = :id", Course.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();
        return course;

    }
    @Override
    public List<Course> getAllCourse() {
        entityManager.getTransaction().begin();
        List<Course>courses = entityManager.createQuery("select c  from Course c ", Course.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
    }

    @Override
    public String updateCourse(Long id, Course course) {
            entityManager.getTransaction().begin();

            Course courseToUpdate = entityManager.find(Course.class, id);
            if (courseToUpdate == null) {

            }

            courseToUpdate.setCourseName(course.getCourseName());
            courseToUpdate.setDescription(course.getDescription());
            courseToUpdate.setDuration(course.getDuration());
            courseToUpdate.setImageLink(course.getImageLink());
            courseToUpdate.setDateOfStart(course.getDateOfStart());

            entityManager.merge(courseToUpdate);
            entityManager.getTransaction().commit();

            return "update.....";
        }
    @Override
    public void deleteCourseById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Course.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Course with id: " + id + " deleted!");

    }
}
