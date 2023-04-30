package repository.impl;

import jakarta.persistence.EntityManager;
import org.example.config.Cofig;
import org.example.entities.Course;
import org.example.entities.Instructor;
import repository.InstructorRepositri;

import java.util.List;

public class InstrutorRepositotiImpl implements InstructorRepositri {
    private final EntityManager entityManager = Cofig.getEntityManagerFactory();


    @Override
    public String saveInstructor(Instructor instructor) {
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "saveInstructor...";
    }

    @Override
    public Instructor getInstryctor(Long id) {
        entityManager.getTransaction().begin();
       Instructor instructor = entityManager.createQuery("select i from Instructor i WHERE i.id = :id", Instructor.class).setParameter("id", id).getSingleResult();
       entityManager.getTransaction().commit();
       entityManager.close();
       return instructor;
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) {
        entityManager.getTransaction().begin();


       Instructor instructorUpdate = entityManager.find(Instructor.class, id);
        if (instructorUpdate == null) {

        }
        instructorUpdate.setInstructorName(instructor.getInstructorName());
        instructorUpdate.setEmail(instructor.getEmail());
        instructorUpdate.setPhoneNumber(instructor.getPhoneNumber());

        entityManager.merge(instructorUpdate);
        entityManager.getTransaction().commit();

        return instructor;
    }

    @Override
    public List<Instructor> getINstryctorByCourseId(Long courseId) {
        entityManager.getTransaction().begin();
        List<Instructor> instructors = entityManager.createQuery(
                        "select i from Instructor i " +
                                "join i.courses c where c.id = :courseId", Instructor.class)
                .setParameter("courseId", courseId).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructors;

    }

    @Override
    public void deleteInstructorById(Long id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        for (int i = 0; i < instructor.getCourses().size(); i++) {
            if (instructor.getCourses().get(i).getInstructors().contains(instructor)) {
                instructor.getCourses().get(i).getInstructors().remove(instructor);
            }
        }

        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public String assingInstructorToCourse(Long instructorId, Long courseId) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        Course course = entityManager.find(Course.class, courseId);
        instructor.getCourses().add(course);
        course.getInstructors().add(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor.getInstructorName() + " assigned to " + course.getCourseName() + " course!";

    }
}
