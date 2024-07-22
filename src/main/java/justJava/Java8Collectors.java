package justJava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Collectors {

    public static void main(String[] args) {

        List<Employee> empList = getEmployee();

        


//        Map<String, Map<String, Integer>> collected = empList.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment,
//                        Collectors.groupingBy(Employee::getGender, Collectors.summingInt(Employee::getSalary))));
//
//

//        //get max salary
//        Map<String, Map<String, Optional<Employee>>> collect1 = empList.stream().collect(
//                Collectors.groupingBy(Employee::getDepartment,
//                        Collectors.groupingBy(Employee::getGender,
//                                Collectors.maxBy(Comparator.comparing(Employee::getSalary)))));
//
        Map<String, Map<String, Optional<Employee>>> collect = empList.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getGender,
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary)))));
//
////
//        System.out.println(collect1);


        Optional<Employee> max = empList.stream().max(Comparator.comparing(Employee::getSalary));


        empList.stream().max(Comparator.comparing((e1 -> e1.getSalary())));


//        Map<Employee,Integer> asddasd = new TreeMap<>(Comparator.comparing(p -> p.id));
//
//        getEmployee().forEach(emp -> asddasd.put(emp, emp.id));
//
//        System.out.println(asddasd);
//
//        Collectors.reducing()
//        System.exit(0);

//
        Map<String, Map<String, IntSummaryStatistics>> collect1 = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getGender, Collectors.summarizingInt(Employee::getSalary))));
//
        IntSummaryStatistics as = collect1.get("1").get("as");



//        Map<String, Map<String, Long>> peopleInEachDept = empList.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment,
//                                                Collectors.groupingBy(Employee::getGender,
//                        Collectors.counting())));
//
////
////
//        Map<String, Map<String, Map<String, Employee>>> collect = empList.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment,
//                        Collectors.groupingBy(Employee::getGender,
//                                Collectors.teeing(
//                                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
//                                        Collectors.minBy(Comparator.comparing(Employee::getSalary)),
//                                        (e1, e2) -> {
//                                            HashMap<String, Employee> map = new HashMap<>();
//                                            map.put("MAX_SALARY", e1.get());
//                                            map.put("MIN_SALARY", e2.get());
//                                            return map;
//                                        }
//
//                                ))));


//        HashMap<String, Employee> result = empList.stream().collect(
//                Collectors.teeing(
//                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
//                        Collectors.minBy(Comparator.comparing(Employee::getSalary)),
//                        (e1, e2) -> {
//                            HashMap<String, Employee> map = new HashMap();
//                            map.put("MAX", e1.get());
//                            map.put("MIN", e2.get());
//                            return map;
//                        }
//                ));


//        Predicate<Employee> p = e -> e.getAge() > 18 && e.getSalary() > 1000;
//        empList.stream().filter(p).forEach(System.out::println);
//
//        Runnable run =  () -> System.out.println("asd");
//        Thread thread = new Thread(run);
//        thread.start();
//        empList.stream().collect(Collectors.toCollection())
//        System.out.println(collect);


    }

    public static List<Employee> getEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();

//        employees.add(new Employee(1, "sai", 29, "IT", 21, "MALE"));
//        employees.add(new Employee(2, "PRakash", 29, "IT", 22, "MALE"));
//        employees.add(new Employee(3, "Resh", 30, "ART", 23, "FEMALE"));
//        employees.add(new Employee(3, "Theepak", 30, "SCIENCE", 24, "MALE"));
//        employees.add(new Employee(4, "Shallini", 26, "IT", 25, "FEMALE"));
//        employees.add(new Employee(4, "Manjula", 26, "ART", 26, "FEMALE"));
//        employees.add(new Employee(4, "VArun", 26, "CIVIL", 27, "FEMALE"));


        employees.add(new Employee(1, "sai21", 29, "IT", 21, "MALE"));
        employees.add(new Employee(2, "sai22", 29, "IT", 22, "MALE"));
        employees.add(new Employee(3, "sai20", 29, "IT", 20, "MALE"));

        employees.add(new Employee(4, "Sha20", 29, "IT", 20, "FEMALE"));
        employees.add(new Employee(5, "Sha21", 29, "IT", 21, "FEMALE"));
        employees.add(new Employee(6, "sha22", 29, "IT", 22, "MALE"));


        return employees;

    }
}


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Employee {
    Integer id;
    String name;
    Integer age;
    String department;
    Integer Salary;
    String gender;
}
