import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter roll number: ");
                    String roll = sc.nextLine().trim();
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine().trim();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine().trim();

                    if (name.isEmpty() || roll.isEmpty() || grade.isEmpty() || email.isEmpty()) {
                        System.out.println(" All fields are required.");
                    } else {
                        sms.addStudent(new Student(name, roll, grade, email));
                        System.out.println(" Student added successfully.");
                    }
                }

                case 2 -> {
                    System.out.print("Enter roll number to remove: ");
                    String roll = sc.nextLine().trim();
                    if (sms.removeStudent(roll)) {
                        System.out.println(" Student removed.");
                    } else {
                        System.out.println(" Student not found.");
                    }
                }

                case 3 -> {
                    System.out.print("Enter roll number to search: ");
                    String roll = sc.nextLine().trim();
                    Student s = sms.searchStudent(roll);
                    if (s != null) {
                        System.out.println(" Student Found:\n" + s);
                    } else {
                        System.out.println(" Student not found.");
                    }
                }

                case 4 -> sms.displayAllStudents();

                case 5 -> System.out.println(" Exiting Student Management System. Goodbye!");

                default -> System.out.println(" Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
