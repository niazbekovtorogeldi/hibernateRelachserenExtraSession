package repository;

import org.example.entities.Task;

import java.util.List;

public interface TaskRepository {
    Task saveTask(Long lessonId, Task task);
    Task updateTask(Long id, Task task);
    List<Task> getAllTaskByLessonId(Long id);
    void deleteTaskById(Long id);
}
