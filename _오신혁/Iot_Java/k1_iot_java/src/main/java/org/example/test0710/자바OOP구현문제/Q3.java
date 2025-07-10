package org.example.test0710.자바OOP구현문제;

/*
🔸 Q3. 추상 클래스와 구현

Shape라는 추상 클래스를 만든다.
double getArea()라는 추상 메서드를 가진다.
Circle, Rectangle 클래스는 Shape를 상속받고 각자의 면적을 구하는 getArea를 구현한다.
Main 클래스에서 다형성을 활용해 각각의 도형 면적을 출력하라.
*/

abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    double getArea() {
        return  num*num*3.14;
    }
}

class Rectangle extends Shape {
    int height;
    int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    double getArea() {
        return width * height;
    }
}


public class Q3 {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        ((Circle) circle).setNum(200);
        ((Rectangle) rectangle).setHeight(20);
        ((Rectangle) rectangle).setWidth(50);

        System.out.println(circle.getArea());
        System.out.println(rectangle.getArea());


    }
}
