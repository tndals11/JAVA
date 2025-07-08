package org.example.chapter07.orderApp;
/*
 * Electronics 클래스
 *
 * - Product(제품)를 상속받는 하위 클래스
 * - (추가) 전자 제품은 특별 세율 적용: 15% (오버라이딩)
 * */
public class Electronics extends Product {
    Electronics(String name, int price) {
        super(name, price);
    }
    // 오버라이딩 => 부모클래스의 메소드를 재정의 하는 것  
    // 전자 제품은 특별 세율 적용: 15% 조건이 주어져서 값을 재정의
    @Override
    double calculateTax() {
        return price * 0.15;
    }
}
