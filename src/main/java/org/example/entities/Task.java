package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Setter
@Getter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(
            generator = "task_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "task_gen",
            sequenceName = "task_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private LocalDate deadline;
    private String taskDescription;

    public Task(String name, LocalDate deadline, String taskDescription) {
        this.name = name;
        this.deadline = deadline;
        this.taskDescription = taskDescription;
    }

    @ManyToOne(cascade = {
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.PERSIST})
    private Lesson lesson;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deadline=" + deadline +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
