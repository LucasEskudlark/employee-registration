package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();

        // Request the amount of employees to be registered
        System.out.print("How many employees will be registered? ");
        int employeeAmount = scanner.nextInt();

        // Requesting employee data
        for (int i = 0; i < employeeAmount; i++) {

            System.out.println();
            System.out.println("Employee #" + (i + 1) + ":");

            // Requesting id
            System.out.print("Id: ");
            int id = scanner.nextInt();

            // Using containsId method to detect if id is already taken
            while (containsId(list, id)) {
                // If it's already taken, request again
                System.out.print("Id already taken. Try again: ");
                id = scanner.nextInt();
            }

            scanner.nextLine();

            // Requesting name
            System.out.print("Name: ");
            String name = scanner.nextLine();

            // Requesting salary
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();

            // Adding employee to the list "list"
            list.add(new Employee(id, name, salary));
        }

        // Requesting which employee will have salary increased
        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int id2 = scanner.nextInt();

        /* Using containsId method reversed
        * The original method returns true if the id is already in the list*/
        while (!containsId(list, id2)) {
            System.out.println("This id does not exist. Try again: ");
            id2 = scanner.nextInt();
        }

        // Request the salary increase percentage
        System.out.println();
        System.out.print("Enter the percentage: ");
        double percentage = scanner.nextDouble();

        // Search for the employee(object) that has the same id
        for (Employee object: list) {
            if (object.getId() == id2) {
                object.increaseSalary(percentage);
            }
        }

        // Print list data
        System.out.println("List of employees: ");
        for (Employee object: list) {
            System.out.println(object);
        }
    }

    /* The method takes a list of objects and an id
    * It checks whether the entered id already exists in the list or not and
    * returns a boolean value
    * If the id already exists in the list, it will return true
    * If the id does not exists in the list, it will return false*/
    public static boolean containsId(List<Employee> list, int id) {
        boolean result = false;
        for (Employee object: list) {
            if (object.getId() == id) {
                result = true;
                break;
            }
        }
        return result;
    }
}
