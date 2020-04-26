package allhomework.homework14.hw.employee;

// Создать список объетов List<Employee> (использовать метод employeeGenerator)
// и сортировать по:
// имени
// имени и зарплете
// имени, зарплете, возрасту и компании

import java.util.*;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    public static void main(String[] args) {
        List<Employee> employees;
         employees = new LinkedList<>(employeeGenerator(3));
         employees.sort(new EmployeeNameComparator());
        System.out.println("Sort by name:");
         employees.forEach(System.out::println);
        System.out.println("**********************");
        employees = new LinkedList<>(employeeGenerator(5));
        employees.sort(new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator()));
        System.out.println("Sort by name and salary:");
        employees.forEach(System.out::println);
        System.out.println("**********************");
        employees = new LinkedList<>(employeeGenerator(10));
        System.out.println("Sort by name, salary, age and company:");
        employees.sort(new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator().thenComparing
                                    (new EmployeeAgeComparator().thenComparing(new CompanyNameComparator()))));
        employees.forEach(System.out::println);

    }

    public Employee(String name, String company, int salary, int age) {
        setName(name);
       setCompany(company);
        setSalary(salary);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // TODO: конструктор, геттеры и сеттеры

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний
        Random random = new Random();
        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            String name = names[random.nextInt(names.length)];
            String company = companies[random.nextInt(companies.length)];
            int age = random.nextInt(40)+21;
            int salary = random.nextInt(5001)+5000;
            employees.add(new Employee(name, company, salary, age)); // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
        }
        return employees;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", salary: " + salary + "$" +
                ", age: " + age +
                ", company: " + company + ".";
    }
}

class EmployeeNameComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class EmployeeAgeComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class EmployeeSalaryComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class CompanyNameComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}

