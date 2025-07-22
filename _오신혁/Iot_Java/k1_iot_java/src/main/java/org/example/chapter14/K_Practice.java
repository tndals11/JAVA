package org.example.chapter14;

// == 직원 관리 시스템 == //

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 직원 데이터 정의
@AllArgsConstructor
@ToString
@Getter
// 직원 데이터 정의
class Employee {
    private String department; // 부서
    private String name; // 직원명
    private  int salary; // 급여

}


public class K_Practice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("IT", "이승아", 300),
            new Employee("HR", "조승범", 500),
            new Employee("IT", "김준일", 400),
            new Employee("OP", "전예찬", 350),
            new Employee("HR", "조대휘", 380)
        );


        // 1. 급여가 400 이상인 직원 '필터링'
        // : filter() - 조건을 검사해서 true인 요소만을 다시 반환
        List<Employee> filterEmp = employees.stream()
                .filter( emp -> emp.getSalary() >= 400)
                .collect(Collectors.toList());

        filterEmp.forEach(System.out::println);


        // 2. IT 부서 직원의 이름만 추출
        // 1) 부서(department)가 'IT'인 직원을 필터링 - filter
        // 2) 부서가 'IT'인 직원 목록을 전체 순회하여 이름만 추출 - map
        System.out.println(" === 부서(department)가 'IT'인 직원 ===");
        List<String> filterName = employees.stream()
                .filter(employee -> employee.getDepartment().contains("IT"))
                .map(Employee::getName)
                .toList();

        filterName.forEach(System.out::println);


        // 3. 특정 부서(HR) 직원 중 이름에 '조'가 포함된 직원 필터링
        // 1) 부서가 'HR'인 직원을 필터링 >> equals
        // 2) 위의 목록 중 이름에 '조'가 포함된 직원을 필터링 >> contains
        System.out.println("=== 부서가 'HR'인 직원을 필터링 하고 목록중에 조가 포함된 직원 ===");
        List<Employee> filterNameJo = employees.stream()
                .filter(employee -> employee.getDepartment().equals("HR")).filter(employee -> employee.getName().contains("조"))
                .collect(Collectors.toList());

        filterNameJo.forEach(System.out::println);


        System.out.println("=== 4번 ===");
        // 4. 부서별 직원 그룹화
        // Collectors 클래스 - groupingBy
        Map<String, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println(grouped);

        for (Map.Entry<String, List<Employee>> entry: grouped.entrySet()) {
            String department = entry.getKey();
            List<Employee> employeeList = entry.getValue();

            System.out.println(department + ": ");
            for (Employee employee : employeeList) {
                System.out.println(employee.getName() + " ");
            }
            System.out.println();
        }


        Map<String, Double> avgSalaryByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));

        System.out.println(avgSalaryByDept);

    }
}
