package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@Setter
@Getter
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(
            generator = "course_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "course_gen",
            sequenceName = "course_seq",
            allocationSize = 1)
    private Long id;
    private String courseName;
    private int duration;
    private LocalDate dateOfStart;
    private String imageLink;
    private String description;

    @ManyToMany(cascade = {
            DETACH,
            REFRESH,
            MERGE})
    private List<Instructor> instructors;

    @OneToMany(cascade = {
            REFRESH,
            MERGE,
            REMOVE,
            DETACH},
            mappedBy = "course")
    private List<Lesson> lesson;

    public Course(String courseName, int duration, LocalDate dateOfStart, String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.dateOfStart = dateOfStart;
        this.imageLink = imageLink;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", dateOfStart=" + dateOfStart +
                ", imageLink='" + imageLink + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
