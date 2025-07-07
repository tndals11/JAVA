package org.example.chapter06;

// == 상속(Inheritance) == //
// : 한 클래스의 속성과 메서드를 다른 메서드가 물려받는 것
// : 기존의 클래스로 재사용하여 새로운 클래스를 작성하는 것
// : 코드의 재사용성, 증복제거 (프로그램 생상선 향상)

// 상속 구현 방법
// extends (확장하다) 키워드를 사용하여 구현
// : class 자식클래스 extends 부모클래스 {}

// cf) 명칭
//    상속해주는 클래스(Parent) - 조상, 부모, 상위, 기반, 슈퍼클래스
//    상속받는 클래스(Child) - 자손, 자식, 하위, 파생, 서브클래스

// == 동물 클래스 == //
class Animal {
    String name;
}

class Dog extends Animal {
    // 부모 클래스의 속성과 이미 모두 상속 받음(생략된 것과 같다)
    // String name;

    // 클래스의 확장
    // : 부모가 가지지 않은 필드나 메서드 정의 가능
    void bark() {
        System.out.println("멍멍");
    }
}

class Tv {
    boolean power;
    int channel;

    void setPower() {
            power = !power;
        }


    void channelUp() { ++channel;}
    void channelDown() { --channel;}
}


class  SmartTv extends Tv{
    boolean ott; // ott 플랫폼 전원 상태

    void  displayOff( String platform ) {
        if ( ott ) {
            System.out.println(platform);
        } else {
            System.out.println("ott가 켜져있지않습니다.");
        }
    }
}



class Parent{} // 부모 클래스(기존 클래스)
class Child extends Parent{} // 자식 클래스(새로운 클래스)

public class B_Inheritance {
    public static void main(String[] args) {
        Dog choco = new Dog();
        choco.name = "초코";
        System.out.println(choco.name);
        choco.bark();


        // == Tv 객체 생성 == //

        Tv tv = new Tv();
        // 필드의 경우 자동 초기화
        // : 기본 자료형 = boolean(2), int(4), char('')
        // : 참조 자료형 = null
        tv.power = true;
        tv.channelUp();
        tv.channelUp();
        tv.channelUp();
        System.out.println(tv.channel);

        SmartTv smartTv = new SmartTv();
        smartTv.power = true;
        smartTv.channelDown();
        smartTv.channelDown();
        smartTv.channelDown();
        smartTv.channelDown();
        smartTv.channelUp();
        System.out.println(smartTv.channel);

        smartTv.displayOff("Netflix");
        smartTv.ott = true;
        System.out.println("Disney Plus");

        //  tv.ott = true;
        // 부모는 자식의 기능과 행위를 전달받지 못한다
    }
}
