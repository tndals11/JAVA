package org.example.chapter06;

// 학생 관리 시스템

import java.util.ArrayList;

// 1. 학생 클래스 정의
// : 학생 정보 저장, 관련 메서드 제공
class Student{
    // === 필드 === //
    int studentId; // 학생 Id
    String name; // 이름
    int age; // 나이
    String major; // 전공
    double gpa; // 평균학점
    
    // INSERT
    Student(int studentId, String name, int age, String major, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.major = major;
        this.gpa = gpa;
    }
    
    // === 메서드 === //
    // SELECT
    void printStudentInfo() { // 출력
        System.out.println("Id : " + studentId
                + "name : " + name
                + "age : " + age
                + "major : " + major
                + "gpa : " + gpa);
    }

    // UPDATE
    void updateGpa(double newGpa) { // 수정
        this.gpa = newGpa;
    }

    // === 생성자 === //
    Student() {
       this.studentId = 0;
       this.name = "Unknow";
       this.age = 20;
       this.major = "Undeclared";
       this.gpa = 0.0;
    }
    
    Student(int studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }
    
}

// 2. 학생 관리 시스템 클래스 정의
// : 메인 클래스(실행)
// : 학생 등록, 조회, 수정기능 담당
public class StudentManagementApp {
    // cf) Java 클래스명은 파일명과 동일 (대소문자까지)
    //      : 하나의 파일에서 public 단위의 클래스는 한 개만 지정 가능
    //      >>  public class 클래스명은 파일명과 일치!

    //cf) static
    //      : 인스턴스화 없이 클래스 자체에서 직접호출
    //      - main 메서드 내부에서 다른 매서드 호출 시 반드시 해당 메서드는 static 이어야 한다
    // 배열에 값을 담아야하기 때문에 ArrayList에 담는다
    static ArrayList<Student> students  = new ArrayList<>();

    // 학생 등록(INSERT)
    static void addStudent(int id, String name, int age, String major, double gpa) {
        Student student = new Student(id, name, age, major, gpa);
        // 배열에.add => 배열에 추가
        students.add(student);
        System.out.println(name + " 학생이 등록되었습니다.");
    }

    // 학생 조회 (select)
    static void printAllStudents () {
        System.out.println("=== 전체 학생 목록 ===");
        // for (순회하는 요소의 변수 선언 : 배열리스트) {}
        for (Student student: students) {
            student.printStudentInfo();
        }
    }

    // 학생 검색: 학생 ID를 통해 해당 학생의 정보를 출력 (select) where 학생ID를 사용해서 학생의 정보를 출력
    static void findStudentById(int studentId) {
        for (Student student : students) {
            if (student.studentId == studentId) {
                student.printStudentInfo();
                return; // 메서드 종료
            }
        }
        System.out.println(studentId + "해당 ID의 학생을 찾을 수 없습니다.");
    }

    // 평균 학점 업데이트: 학생 ID를 사용하여 해당 학생의 평점을 업데이트(update)
    static  void updateStudentGpa(int studentId, double newGpa) {
        for (Student student : students){
            if (student.studentId == studentId) {
                student.updateGpa(newGpa);
                System.out.println("평점이 업데이트 되었습니다.");
                return;
            }
        }
    }
    
    // main 메서드
    // : 프로그램을 진입점을 제공
    // >> public static void main(String[] args) 형식이어야 만 실행 가능
    // >> JVM은 main 메서드가 없을 경우 해당 파일을 실행x
    public static void main(String[] args) {
        // 생성자 생성
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        
        // 배열에 학생 추가 (INSERT)
        addStudent(1, "김보민", 20, "IoT", 3.8);
        addStudent(2, "박진영", 21, "IoT", 3.9);
        addStudent(3, "오신혁", 22, "IoT", 3.7);
        addStudent(4, "김세훈", 23, "IoT", 3.5);

        // 전체조회(SELECT)
        printAllStudents();

        // 학생조회(SELECT = "ID")
        findStudentById(1);
        findStudentById(3);
        
        // 학생 평점 업데이트 (UPDATE)
        updateStudentGpa(1, 4.1);
        updateStudentGpa(4, 4.5);
        
        // 업데이트된 학생 출력
        findStudentById(1);
        findStudentById(4);
    }
}
