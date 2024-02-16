package main;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CricketerTest {
    private static List<Cricketer> cricketers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Cricketer");
            System.out.println("2. Modify Cricketer's Rating");
            System.out.println("3. Search Cricketer by Name");
            System.out.println("4. Display All Cricketers");
            System.out.println("5. Display All Cricketers Sorted by Rating");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCricketer();
                    break;
                case 2:
                    modifyRating();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    displayAllCricketers();
                    break;
                case 5:
                    displaySortedByRating();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCricketer() {
        System.out.print("Enter Cricketer's Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Cricketer's Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Cricketer's Email ID: ");
        String emailId = scanner.nextLine();
        System.out.print("Enter Cricketer's Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Cricketer's Rating: ");
        int rating = scanner.nextInt();

        cricketers.add(new Cricketer(name, age, emailId, phone, rating));
        System.out.println("Cricketer added successfully.");
    }

    private static void modifyRating() {
        System.out.print("Enter Cricketer's Name to modify rating: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Rating: ");
        int newRating = scanner.nextInt();

        boolean found = false;
        for (Cricketer cricketer : cricketers) {
            if (cricketer.getName().equalsIgnoreCase(name)) {
                cricketer.setRating(newRating);
                found = true;
                System.out.println("Rating modified successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Cricketer not found.");
        }
    }

    private static void searchByName() {
        System.out.print("Enter Cricketer's Name to search: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Cricketer cricketer : cricketers) {
            if (cricketer.getName().equalsIgnoreCase(name)) {
                System.out.println("Cricketer found: " + cricketer);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Cricketer not found.");
        }
    }

    private static void displayAllCricketers() {
        System.out.println("\nAll Cricketers:");
        for (Cricketer cricketer : cricketers) {
            System.out.println(cricketer);
        }
    }

    private static void displaySortedByRating() {
        List<Cricketer> sortedCricketers = new ArrayList<>(cricketers);
        sortedCricketers.sort(Comparator.comparingInt(Cricketer::getRating).reversed());

        System.out.println("\nAll Cricketers Sorted by Rating:");
        for (Cricketer cricketer : sortedCricketers) {
            System.out.println(cricketer);
        }
    }
}
