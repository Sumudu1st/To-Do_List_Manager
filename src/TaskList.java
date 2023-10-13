import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void removeTask(int id) {
        this.tasks.removeIf(task -> task.getId() == id);
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public List<Task> getCompletedTasks() {
        return this.tasks.stream()
                .filter(Task::isStatus)
                .collect(java.util.stream.Collectors.toList());
    }

    public List<Task> getTasksDueToday() {
        Date today = new Date();
        return this.tasks.stream()
                .filter(task -> task.getDueDate().equals(today))
                .collect(java.util.stream.Collectors.toList());
    }

    public Task getTaskById(int id) {
        return this.tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void markAsCompleted(Task task) {
        task.setStatus(true);
    }

    public void sortTasksByDueDate() {
        Collections.sort(tasks, (t1, t2) -> t1.getDueDate().compareTo(t2.getDueDate()));
    }

    public void sortTasksByPriority() {
        Collections.sort(tasks, (t1, t2) -> Integer.compare(t1.getPriority(), t2.getPriority()));
    }

    public void sortTasksByTitle() {
        Collections.sort(tasks, (t1, t2) -> t1.getTitle().compareTo(t2.getTitle()));
    }
}
