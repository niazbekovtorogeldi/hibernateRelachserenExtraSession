package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "instructors")
@Setter
@Getter
@NoArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(
            generator = "instructor_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "instructor_gen",
            sequenceName = "instructor_seq",
            allocationSize = 1)
    private Long id;
    private String instructorName;
    private String email;
    private String phoneNumber;

    public Instructor(String instructorName, String email, String phoneNumber) {
        this.instructorName = instructorName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},
            mappedBy = "instructors")
    private List<Course> courses;

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", instructorName='" + instructorName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }}
