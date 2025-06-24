import java.util.*;

public class ToDoApp {
    static List<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== To-Do List Menu ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskCompleted();
                case 4 -> deleteTask();
                case 5 -> {
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void addTask() {
        System.out.print("Enter task description: ");
        String desc = scanner.nextLine();
        tasks.add(new Task(desc));
        System.out.println(" Task added.");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    static void markTaskCompleted() {
        viewTasks();
        System.out.print("Enter task number to mark as completed: ");
        int num = scanner.nextInt();
        if (num > 0 && num <= tasks.size()) {
            tasks.get(num - 1).markCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println(" Invalid task number.");
        }
    }

    static void deleteTask() {
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int num = scanner.nextInt();
        if (num > 0 && num <= tasks.size()) {
            tasks.remove(num - 1);
            System.out.println("Task deleted.");
        } else {
            System.out.println(" Invalid task number.");
        }
    }
}