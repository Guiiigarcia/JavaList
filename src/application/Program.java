package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List <Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            System.out.println("Employee #"+(i+1)+":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.nextLine();
            sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id , name ,salary);

            list.add(emp);
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();

        Employee emp = list.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
        if(emp == null){
            System.out.println("This is does not exist.");
        }else{
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        for(Employee i: list){
            System.out.println(emp);
        }
        sc.close();
    }
}
