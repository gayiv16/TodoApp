import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n1. Add Task\n2. List Tasks\n3. Mark Task Done\n4. Delete Task\n5. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter task: ");
                    String desc = scanner.nextLine();
                    manager.addTask(desc);
                    break;
                case "2":
                    manager.listTasks();
                    break;
                case "3":
                    System.out.print("Enter task number to mark done: ");
                    manager.markTaskDone(Integer.parseInt(scanner.nextLine()));
                    break;
                case "4":
                    System.out.print("Enter task number to delete: ");
                    manager.deleteTask(Integer.parseInt(scanner.nextLine()));
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
