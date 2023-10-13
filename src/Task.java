import java.util.Date;



public class Task {
    private static int counter = 1;
    private int id;
    private String title;
    private String description;
    private Date dueDate;
    private boolean status;

    public Task(String title, String description, Date dueDate) {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                '}';
    }
}

