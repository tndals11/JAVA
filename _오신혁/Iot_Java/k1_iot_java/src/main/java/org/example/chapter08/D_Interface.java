package org.example.chapter08;

// 인터페이스
interface Flyable {
    // 필드
    // 날 수 있는 것에 대한 동작 선언
    int AVERAGE_SPEED = 100; // public static final 생략되어있음
    
    void fly(); // public abstract 생략되어있는 형태(각 구현제에서 나는 행위를 재정의)

    // 디폴트 메서드 - 재정의 가능
    default void land() {
        System.out.println("착륙합니다.");
    }

    // 정적 메서드 - 재정의 불가능 + 인터페이스 호출만 가능
    static int getWingCount() {
        return 2;
    }
}

class 참새 implements Flyable {
    @Override
    public void fly() { // -> 인터페이스 안의 있는 메서드 무조건 재정의해서 사용해야한다 !
        // 인터페이스의 필드 사용가능
        System.out.println("참새의 속력은" + AVERAGE_SPEED + "km의 평균 속도보다 느립니다.");
    }

    @Override
    public void land() {
        System.out.println("사뿐");
    }
}

class 독수리 implements Flyable{
    @Override
    public void fly() {
        System.out.println("독수리의 속력은 " + AVERAGE_SPEED + "km의 평균 속도보다 빠릅니다.");
    }

    @Override
    public void land() {
        System.out.println("슈우우우웅");
    }
}

public class D_Interface {
    public static void main(String[] args) {
        참새 bird1 = new 참새();

        bird1.fly(); // 참새의 속력은 100km의 평균 속도보다 느립니다.
        bird1.land(); // 사뿐

        독수리 bird2 = new 독수리();
        bird2.fly(); // 독수리의 속력은 100km의 평균 속도보다 느립니다.
        bird2.land(); // 슈우우웅

        System.out.println(Flyable.getWingCount());

        Flyable bird3 = new 참새();
        Flyable bird4 = new 독수리();
        bird3.fly();
        bird4.fly();
        bird3.land();
        bird4.land();
        
    }
}
