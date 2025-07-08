package org.example.chapter07;

// employeeId`: 사원 고유 번호 (String, **변경 불가**, `final`)
// name`: 사원 이름 (String, **외부에서 직접 접근 불가**)
// position`: 직급 (String, **외부에서 직접 접근 불가**)
// salary`: 급여 (int, **0 이상만 허용**, 외부에서 직접 접근 불가

class EmpClass {
    private final String employeeId;
    private String empName;
    private String position;
    private int salary;
    
    // 값을 입력
    EmpClass(String employeeId, String empName, String position, int salary) {
        this.employeeId = employeeId;
        this.empName = empName;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    public String getEmpName() {
        return empName;
    }
    public String getPosition() {
        return position;
    }

    public int getSalary() {
        if (salary >= 0) {
            return salary;
        } else {
            return salary = 0;
        }
    }

    // 사원의 ID, 이름, 직급, 급여를 출력하는 메서드
    public void displayInfo() {
        System.out.println("사원 ID : " + employeeId + ", 이름 : " + empName + ", 직급 : " + position + ", 급여 : " + salary);
    }

    public void setName(String name) {
        if (!"".equals(name) && !" ".equals(name)) {
            System.out.println("이름을 " + name + "으로 변경합니다.");
            this.empName = name;
        } else {
            System.out.println("공백을 입력해주세요");
        }
    }

    public void setPosition(String position) {
        if (!"".equals(position) && !" ".equals(position)) {
            System.out.println("직급을 " + position + "로 변경합니다.");
            this.position = position;
        } else {
            System.out.println("공백을 입력해주세요.");
        }
    }

    public void setSalary(int salary) {
        System.out.println("급여를 " + salary + "으로 변경 시도합니다.");
        if (salary >= 0) {
            this.salary = salary;
        }
    }


}

class Manager extends EmpClass {
    int teamSize;

    Manager(String employeeId, String empName, String position, int salary, int teamSize) {
        super(employeeId, empName, position, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("팀 사이즈 : " + teamSize);
    }
}

public class D_Practice2 {
    public static void main(String[] args) {
        EmpClass emp1 = new EmpClass("100", "김승민", "대리", 3500000);
        emp1.displayInfo();
        System.out.println();
        emp1.setName("조충범");
        System.out.println();
        emp1.setSalary(-50000);
        System.out.println();
        emp1.displayInfo();


        Manager manager = new Manager("200", "이승민", "과장", 500000, 200);
        manager.displayInfo();

    }
}
