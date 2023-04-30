package org.example;

import org.example.config.Cofig;
import org.example.entities.Course;
import org.example.entities.Instructor;
import org.example.entities.Lesson;
import org.example.entities.Task;
import repository.LessonRepository;
import repository.impl.CourseRepositoryImpl;
import repository.impl.InstrutorRepositotiImpl;
import repository.impl.LessonRepositoryimpl;
import repository.impl.TaskRepositoryImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        Cofig.getEntityManagerFactory();
//        CourseRepositoryImpl  repository = new CourseRepositoryImpl();
//        System.out.println(repository.saveCourse(new Course("java", 9, LocalDate.of(2023, 11, 30), "imag", "des")));
//        System.out.println(repository.saveCourse(new Course("js", 6, LocalDate.of(2022, 10, 1), "imag", "des")));
//        System.out.println(repository.saveCourse(new Course("c++", 4, LocalDate.of(2019, 9, 2), "imag", "des")));
//        System.out.println(repository.getCourseById(1L));
//        System.out.println(repository.getAllCourse());
//        System.out.println(repository.updateCourse(1L, new Course("c##", 2, LocalDate.of(1999, 2, 23), "imag", "des")));
//        repository.deleteCourseById(1L);
//        InstrutorRepositotiImpl instrutorRepositoti = new InstrutorRepositotiImpl();
//        System.out.println(instrutorRepositoti.saveInstructor(new Instructor("datka", "datka@gmail.com", "0777554444")));
//        System.out.println(instrutorRepositoti.saveInstructor(new Instructor("aijamal", "aijamal@gmail.com", "0999222333")));
//        System.out.println(instrutorRepositoti.saveInstructor(new Instructor("ulan", "ulan@gmail.com", "0333111444")));
//        System.out.println(instrutorRepositoti.getInstryctor(1L));
//        System.out.println(instrutorRepositoti.updateInstructor(3L, new Instructor("chynguz", "chyngyz@gmail.com", "12345678")));
//        System.out.println(instrutorRepositoti.getINstryctorByCourseId(1L));
//        System.out.println(instrutorRepositoti.assingInstructorToCourse(1L, 1L));
//        instrutorRepositoti.deleteInstructorById(2L);
        LessonRepositoryimpl lessonRepositoryimpl = new LessonRepositoryimpl();
//        System.out.println(lessonRepositoryimpl.saveLesson(2L, new Lesson("jdbs", "https://us02web.zoom.us/rec/")));
//        System.out.println(lessonRepositoryimpl.saveLesson(1L, new Lesson("hibernate", "https://us02web.zoom.us/rec/")));
        System.out.println(lessonRepositoryimpl.getLessonsByInstructorId(3L));
//        System.out.println(lessonRepositoryimpl.getLessonByCourseName("js"));
//        lessonRepositoryimpl.updateLesson(1L,new Lesson());
//        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl();
//        System.out.println(taskRepository.saveTask(5L, new Task("delete", LocalDate.of(2023, 11, 12), "delete by id")));
//        System.out.println(taskRepository.saveTask(6L, new Task("update", LocalDate.of(2023, 11, 1), "update by id")));
//        taskRepository.updateTask(1L,new Task());
//        System.out.println(taskRepository.getAllTaskByLessonId(5L));
//        taskRepository.deleteTaskById(1L);
    }
}
