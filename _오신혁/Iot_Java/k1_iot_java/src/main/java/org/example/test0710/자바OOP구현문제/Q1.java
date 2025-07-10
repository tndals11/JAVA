package org.example.test0710.자바OOP구현문제;
/*
🔸Q1. 상속과 오버라이딩
다음 요구사항을 만족하는 클래스를 구현하시오.
> Animal이라는 부모 클래스를 만든다.Animal 클래스에는 String name과 void makeSound() 메서드가 있다.
Dog, Cat 클래스는 Animal을 상속하고 makeSound() 메서드를 각각 “멍멍”, “야옹”을 출력하도록 오버라이딩한다.
Main 클래스에서 Animal 배열에 Dog와 Cat 인스턴스를 넣고 반복문으로 모든 동물의 이름과 소리를 출력하라.
>
 */

class Animal {
    // 필드
    String name;

    void aniMal (String name) {
        this.name = name;
    }

    // 메서드
    void makeSound() {}
}

class Dog extends Animal {

    @Override
    void aniMal(String name) {
        super.aniMal(name);
    }

    // Animal을 상속해 값을 재정의
    @Override
    void makeSound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {

    @Override
    void aniMal(String name) {
        System.out.println(name);
    }

    // Animal을 상속해 값을 재정의
    @Override
    void makeSound() {
        System.out.println("야옹");
    }
}

public class Q1 {
    public static void main(String[] args) {
        // 인스턴스화
        Animal dog = new Dog();
        Animal cat = new Cat();

        // Animal[] 배열을 생성
        // 배열에 값을 입력
        Animal[] animals = {dog, cat};
        
        // 반복문
        for (Animal animal : animals) {
            animal.aniMal("강아지");
            animal.makeSound();
            animal.aniMal("고양이");
        }

    }
}
