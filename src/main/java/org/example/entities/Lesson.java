package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "lessons")
@Setter
@Getter
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(
            generator = "lesson_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "lesson_gen",
            sequenceName = "lesson_seq",
            allocationSize = 1)
    private Long id;
    private String lessonName;
    private String videoLink;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    private Course course;

    public Lesson(String lessonName, String videoLink) {
        this.lessonName = lessonName;
        this.videoLink = videoLink;

    }



    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lessonName='" + lessonName + '\'' +
                ", videoLink='" + videoLink + '\'' +
                '}';
    }}
