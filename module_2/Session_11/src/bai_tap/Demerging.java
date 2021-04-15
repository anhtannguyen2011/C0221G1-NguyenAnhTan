package bai_tap;

import javax.lang.model.util.ElementScanner14;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Demerging {
    static class Employee{
        private String name;
        private String gender;
        private String dayofBirth;
        static int id =1;

        public Employee() {
        }
        public Employee(String name, String gender, String dayofBirth, int id) {
            this.name = name;
            this.gender = gender;
            this.dayofBirth = dayofBirth;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getDayofBirth() {
            return dayofBirth;
        }

        public void setDayofBirth(String dayofBirth) {
            this.dayofBirth = dayofBirth;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "ID='" + id++ + '\'' +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", dayofBirth='" + dayofBirth + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        ArrayList<Employee> listEmployee = new ArrayList<>();


        Employee employee = new Employee("Hai","Male","01/02/1990",Employee.id++);
        Employee employee1 = new Employee("Hung","Male","02/02/1986",Employee.id++);
        Employee employee2 = new Employee("Sen","Famale","03/02/1988",Employee.id++);
        Employee employee3 = new Employee("Hoc","Male","01/02/1997",Employee.id++);
        Employee employee4 = new Employee("Quynh","Famale","01/02/1991",Employee.id++);
        listEmployee.add(employee);
        listEmployee.add(employee1);
        listEmployee.add(employee2);
        listEmployee.add(employee3);
        listEmployee.add(employee4);

        Collections.sort(listEmployee, new Comparator<Employee>() {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            @Override
            public int compare(Employee o1, Employee o2) {
                try {
                    return dateFormat.parse(o1.dayofBirth).compareTo(dateFormat.parse(o2.dayofBirth));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });


        System.out.println(listEmployee);
        System.out.println("============+++=============");
        ArrayList<Object> ouput = new ArrayList<>();

        Queue<Object> queueFamale = new LinkedList();
        Queue<Object> queueMale = new LinkedList();

        for(int i = 0; i< listEmployee.size() ; i++){
            if(listEmployee.get(i).getGender() == "Famale"){
                queueFamale.add(listEmployee.get(i));
            }else if(listEmployee.get(i).getGender() == "Male") {
                queueMale.add(listEmployee.get(i));
            }
        }


        while (!queueFamale.isEmpty()){
            ouput.add(queueFamale.remove());
        }
        System.out.println(ouput);
        System.out.println("============+++=============");
        while (!queueMale.isEmpty()){
            ouput.add(queueMale.remove());
        }


        System.out.println(ouput);




    }
}
