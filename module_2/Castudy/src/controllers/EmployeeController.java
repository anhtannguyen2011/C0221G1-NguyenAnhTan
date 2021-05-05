package controllers;

import models.Customers;
import models.Employee;

import java.io.*;
import java.util.*;

public class EmployeeController {
    static Scanner scanner = new Scanner(System.in);
    static List<Employee> employees = new ArrayList<>();
    public static final String PATH = "DemoCastudy/src/data/Employee.csv";

    public static void addEmployee() {
        System.out.println("Nhập tên nhân viên : ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi nhân viên : ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Địa chỉ nhân viên");
        String address = scanner.nextLine();
        Employee employee = new Employee(name, age, address);
        employees.add(employee);

    }

    public static void numerAddEmployee() {
        System.out.println("Nhập số lượng nhân viên cần thêm vào");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            addEmployee();
        }
        try {
            FileWriter fileWriter = new FileWriter(PATH,true);
            BufferedWriter bf = new BufferedWriter(fileWriter);
            for (Employee employee : employees) {
                bf.write(employee.toString());
                bf.append("\n");
            }
            bf.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("File Not Fould");
        }
    }

    public static void showEmployee() {
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] str = null;
            Map<Integer, Employee> emp = new TreeMap<>();
            int id = 0;
            while ((line = bufferedReader.readLine()) != null) {
                id++;
                str = line.split(",");
                if (str.length == 3) {
                    Employee e = new Employee(str[0], Integer.parseInt(str[1]), str[2]);
                    emp.put(id, e);
                }
            }
            bufferedReader.close();
            fileReader.close();
            Set<Integer> set = emp.keySet();
            for (Integer s : set) {
                System.out.println(s + "." + emp.get(s));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void searchEmployee() {

        try {
            Stack<Employee> employeeStack = new Stack<>();
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] str = null;
            int id = 0;
            while ((line = bufferedReader.readLine()) != null) {
                str = line.split(",");
                if (str.length == 3) {
                    Employee e = new Employee(str[0], Integer.parseInt(str[1]), str[2]);
                    employeeStack.push(e);
                }
            }
            bufferedReader.close();
            fileReader.close();

            System.out.println("Nhập nhân viên cần tìm kiếm :");
            String name = scanner.nextLine();
            boolean check = false;
            for (Employee e : employeeStack) {
                if (name.equalsIgnoreCase(e.getName())) {
                    System.out.println("Name : " + e.getName() + "; Age : " + e.getAge() + "; Addess : " + e.getAddress());
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.err.println("Không tìm thấy nhân viên nào cả");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void menuEmployee() {
        while (true) {
            System.out.println("Mời Người Bạn Chọn Chức Năng");
            System.out.println("1. Thêm Số Lượng Nhân Viên");
            System.out.println("2. Hiển thị tổng số nhân viên");
            System.out.println("3. Tìm kiếm nhân viên");
            System.out.println("4. Trở lại menu chính");
            System.out.println("Mời bạn chọn !");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    numerAddEmployee();
                    break;
                case 2:
                    showEmployee();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    return;
                default:
                    System.err.println("Vui lòng nhập lại");
            }
        }

    }


}
