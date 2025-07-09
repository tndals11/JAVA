package org.example.chapter09;


// == 자바 예외 처리 == //
// 1. try-catch 블록
// 2. throw, throws 키워드


/*
    try-catch 블록

    === 기본 형태 ===

    try {
       // 예외가 발생할 수 있는 코드
       // ...
    } catch('발생한 예외의 타입'' 예외를 저장할 변수) {
        해당 예외 발생 시 실행할 코드
    } catch('발생한 예외의 타입'' 예외를 저장할 변수) {
          
    }   
    
    cf) catch 블록
            : 특정 예외 타입이 발생했을 때 실행된 코드를 정의
            - 다중 catch 블록으로 사용 가능(여러 예외 처리 가능)

*/

public class Exception02 {
    public static void main(String[] args) {
        // [ - 컴파일 예외 -]
        // char c1 = 'abc';

        // int division = 10 / 0;
        // Exception in  thread "main" java.lang.ArithmeticException: // by zero

        try {
            //  int i = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("0으로 정수를 나눌 수 없습니다.");
            System.out.println(e.getMessage());
            //cf) 예외 변수
            // : try 블록 내의 예외에 대한 정보를 포함
            // - 동일한 예외 타입 또는 해당 타입을 포함하는 타입일 경우
            //      , 발생된 예외를 자동으로 전달 받음
        }
        System.out.println("정상적인 실행");

        System.out.println("== 다중 catch 블록 실행 ==");
        try {
            System.out.println("정상실행");
            int division = 10 / 0;
            System.out.println("위에서 예외가 발생할 경우 실행 X");

            int[]numbers = new int[5];
            numbers[10] = 50;

            String text = null;
            System.out.println(text.length());
        } catch (ArithmeticException e) {
            System.out.println("수학 공식 예외 " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("배열 인섹스 초가 예외");
            // 배열 인덱스 초가 예외: Index 10 out of bounds for length 5
        } catch (Exception e) {
            
            System.out.println("null 값 계산 예외" + e.getMessage() );
        } finally {
            // cf) 예외 발생 여부와 상관없이 항상 실행되는 코드 블록
            System.out.println("finally 블록 - 항상실행");
        }

    }
}


