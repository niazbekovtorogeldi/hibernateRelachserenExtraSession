package repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.config.Cofig;
import org.example.entities.Course;
import org.example.entities.Instructor;
import org.example.entities.Lesson;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import repository.LessonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LessonRepositoryimpl implements LessonRepository {
    private final EntityManager entityManager = Cofig.getEntityManagerFactory();

    @Override
    public Lesson saveLesson(Long courseId, Lesson lesson) {

        entityManager.getTransaction().begin();

        Course course = entityManager.find(Course.class, courseId);
        lesson.setCourse(course);
        entityManager.persist(lesson);
        entityManager.getTransaction().commit();

        return lesson;

    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        entityManager.getTransaction().begin();
        Lesson lesson11 = entityManager.find(Lesson.class, id);
        if (lesson11 == null) {
            System.out.println("");
        }
        lesson11.setLessonName(lesson.getLessonName());
        lesson11.setVideoLink(lesson.getVideoLink());
        entityManager.getTransaction().commit();
        entityManager.close();

        return lesson;
    }

    @Override
    public List<Lesson> getLessonByCourseName(String name) {
        entityManager.getTransaction().begin();
        List<Lesson> lessons = entityManager.createQuery(
                        "select l from Lesson l join l.course c where c.courseName = :name", Lesson.class)
                .setParameter("name", name).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return lessons;
    }

    @Override
    public Map<Lesson, String> getLessonsByInstructorId(Long instructorId) {
            entityManager.getTransaction().begin();
            List<Lesson> lessons = entityManager.createQuery(
                    "select l from Lesson l join l.course i where i.id = :instructorId",
                    Lesson.class).setParameter("instructorId", instructorId).getResultList();

            Map<Lesson, String> resultMap = new HashMap<>();
            for (Lesson lesson : lessons) {
                String courseName = lesson.getCourse().getCourseName();
                resultMap.put(lesson, courseName);
            }

            entityManager.getTransaction().commit();
            entityManager.close();

            return resultMap;
        }





        @Override
    public void deleteLessonById(Long id) {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Lesson.class, id));
            entityManager.getTransaction().commit();
            entityManager.close();


    }
}
