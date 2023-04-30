package repository.impl;

import jakarta.persistence.EntityManager;
import org.example.config.Cofig;
import org.example.entities.Lesson;
import org.example.entities.Task;
import org.hibernate.Session;
import repository.TaskRepository;

import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private final EntityManager entityManager = Cofig.getEntityManagerFactory();
    @Override
    public Task saveTask(Long lessonId, Task task) {
        entityManager.getTransaction().begin();


        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        task.setLesson(lesson);
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        return task;
    }

    @Override
    public Task updateTask(Long id, Task task) {
        entityManager.getTransaction().begin();
        Task taskUpdate= entityManager.find(Task.class,id);
        if (taskUpdate == null){
            System.out.println("not...");
        }
        taskUpdate.setName(task.getName());
        taskUpdate.setDeadline(task.getDeadline());
        taskUpdate.setTaskDescription(task.getTaskDescription());
        entityManager.getTransaction().commit();
        entityManager.close();
        return task;
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        entityManager.getTransaction().begin();
        List<Task>tasks = entityManager.createQuery("select t from Task t where t.lesson.id =:id",Task.class).setParameter("id",id).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
    }

    @Override
    public void deleteTaskById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Task  t where t.id=id");
        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
