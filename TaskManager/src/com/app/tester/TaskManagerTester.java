package com.app.tester;

import com.app.exception.TaskNotFoundException;
import com.app.pojos.Status;
import com.app.utils.TaskManager;

import java.time.LocalDate;
import java.util.Scanner;

public class TaskManagerTester {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add New Task");
            System.out.println("2. Delete a Task");
            System.out.println("3. Update Task Status");
            System.out.println("4. Display All Pending Tasks");
            System.out.println("5. Display All Pending Tasks for Today");
            System.out.println("6. Display All Tasks Sorted by Task Date");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task Name: ");
                    scanner.nextLine(); // Consume newline
                    String taskName = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Task Date (YYYY-MM-DD): ");
                    LocalDate taskDate = LocalDate.parse(scanner.nextLine());
                    taskManager.addTask(taskName, description, taskDate);
                    break;
                case 2:
                    System.out.print("Enter Task ID to delete: ");
                    int taskIdToDelete = scanner.nextInt();
                    try {
                        taskManager.deleteTask(taskIdToDelete);
                    } catch (TaskNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter Task ID to update status: ");
                    int taskIdToUpdate = scanner.nextInt();
                    System.out.println("Select Status: ");
                    for (Status status : Status.values()) {
                        System.out.println(status.ordinal() + 1 + ". " + status.name());
                    }
                    int statusChoice = scanner.nextInt();
                    Status selectedStatus = Status.values()[statusChoice - 1];
                    try {
                        taskManager.updateTaskStatus(taskIdToUpdate, selectedStatus);
                    } catch (TaskNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("All Pending Tasks:");
                    taskManager.getAllPendingTasks().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Pending Tasks for Today:");
                    taskManager.getPendingTasksForToday().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("All Tasks Sorted by Task Date:");
                    taskManager.getAllTasksSortedByDate().forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
