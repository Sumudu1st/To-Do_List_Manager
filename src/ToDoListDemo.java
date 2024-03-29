import java.util.Scanner;
import java.util.Date;


public class ToDoListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TaskList taskList = new TaskList();

        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("What do you want to do?");
            System.out.println("1. Add a task");
            System.out.println("2. Remove a task");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. List all tasks");
            System.out.println("5. List completed tasks");
            System.out.println("6. List tasks due today");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();


            scanner.nextLine();


            switch (choice) {
                case 1:
                    System.out.println("Enter the title of the task:");
                    String title = scanner.nextLine();

                    System.out.println("Enter the description of the task:");
                    String description = scanner.nextLine();

                    System.out.println("Enter the due date of the task (yyyy-mm-dd):");
                    String dueDate = scanner.nextLine();

                    Date dueDateObj = new Date(dueDate);

                    Task task = new Task(title, description, dueDateObj);

                    taskList.addTask(task);

                    break;
                case 2:
                    System.out.println("Enter the ID of the task to be removed:");
                    int id = scanner.nextInt();

                    Task taskToRemove = taskList.getTasks().stream()
                            .filter(taskToList -> taskToList.getId() == id)
                            .findFirst()
                            .orElse(null);

                    if (taskToRemove != null) {
                        taskList.removeTask(taskToRemove.getId());
                        System.out.println("Task removed successfully.");
                    } else {
                        System.out.println("Task with the given ID does not exist.");
                    }

                    break;
                case 3:
                    System.out.println("Enter the ID of the task to be marked as completed:");
                    id = scanner.nextInt();

                    taskToRemove = taskList.getTasks().stream()
                            .filter(taskToList -> taskToList.getId() == id)
                            .findFirst()
                            .orElse(null);

                    if (taskToRemove != null) {
                        taskList.markAsCompleted(taskToRemove);
                        System.out.println("Task marked as completed successfully.");
                    } else {
                        System.out.println("Task with the given ID does not exist.");
                    }

                    break;
                case 4:
                    System.out.println("All tasks:");
                    for (Task taskToList : taskList.getTasks()) {
                        System.out.println(taskToList);
                    }
                    break;
                case 5:
                    System.out.println("Completed tasks:");
                    for (Task taskToList : taskList.getCompletedTasks()) {
                        System.out.println(taskToList);
                    }
                    break;
                case 6:
                    System.out.println("Tasks due today:");
                    for (Task taskToList : taskList.getTasksDueToday()) {
                        System.out.println(taskToList);
                    }
                    break;
                case 7:
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
