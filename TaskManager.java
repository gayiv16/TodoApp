import java.io.*;
import java.util.*;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private final String fileName = "tasks.txt";

    public TaskManager() {
        loadTasks();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
        saveTasks();
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            int index = 1;
            for (Task task : tasks) {
                System.out.println(index++ + ". " + task);
            }
        }
    }

    public void markTaskDone(int index) {
        if (index > 0 && index <= tasks.size()) {
            tasks.get(index - 1).markDone();
            saveTasks();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void deleteTask(int index) {
        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            saveTasks();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private void saveTasks() {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Task task : tasks) {
                writer.println(task.isDone + ";" + task.description);
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    private void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";", 2);
                Task task = new Task(parts[1]);
                task.isDone = Boolean.parseBoolean(parts[0]);
                tasks.add(task);
            }
        } catch (IOException e) {
            // file might not exist yet
        }
    }
}
