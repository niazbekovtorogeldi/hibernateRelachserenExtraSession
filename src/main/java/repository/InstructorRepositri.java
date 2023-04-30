package repository;

import org.example.entities.Instructor;

import java.util.List;

public interface InstructorRepositri {
    String saveInstructor(Instructor instructor);
    Instructor getInstryctor(Long id);
    Instructor updateInstructor(Long id,Instructor instructor );
    List<Instructor>getINstryctorByCourseId(Long courseId);
    void deleteInstructorById(Long id);
    String assingInstructorToCourse(Long instructorId,Long courseId);

}
