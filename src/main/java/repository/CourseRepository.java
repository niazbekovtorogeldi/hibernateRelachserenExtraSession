package repository;

import org.example.entities.Course;
import org.example.entities.Lesson;

import java.util.List;

public interface CourseRepository {
    String saveCourse(Course course);
    Course getCourseById(Long id);
    List<Course>getAllCourse();
    String updateCourse(Long id,Course course);
    void deleteCourseById(Long id);

}
