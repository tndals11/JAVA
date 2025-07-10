package org.example.test0710.자바OOP구현문제;

/*
Q4. 인터페이스 구현

Playable이라는 인터페이스를 만든다.
play() 메서드를 가진다.Piano, Guitar 클래스는 Playable을 구현하고 play() 메서드에서 각각 다른 악기 소리를 출력한다.
Main에서 다형성을 통해 모든 악기를 재생하라.
*/

interface Playable {
    default void play() {
    }
}
class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("피아노소리");
    }
}
class Guitar implements  Playable {
    @Override
    public void play() {
        System.out.println("기타소리");
    }
}
public class Q4 {
    public static void main(String[] args) {
        Playable piano = new Piano();
        Playable guitar = new Guitar();

        ((Piano) piano).play();
        ((Guitar) guitar).play();
    }
}
