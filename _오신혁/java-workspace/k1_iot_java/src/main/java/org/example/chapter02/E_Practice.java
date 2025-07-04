package org.example.chapter02;

import java.util.Scanner;

public class E_Practice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("(점수를 입력해주세요: )");
        int score = sc.nextInt();

        if (score < 0 || score < 100) {
            if ( score >= 90) {
                System.out.println("A");
            } else if (score >= 80) {
                System.out.println("B");
            } else if (score >= 70) {
                System.out.println("C");
            } else if (score >= 60) {
                System.out.println("D");
            } else {
                System.out.println("F");
            }
        } else {
            System.out.println("유효하지 않는 점수입니다.");
        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

   int rows = 5;
    for (int i = 1; i <= rows; i++) {
        for(int j = 1; j <= rows - i; j++) {
            System.out.print(" ");
        }

        for (int k = 1; k<=i; k++) {
            // 별의 반복
            // k: 1부터 5까지의 수
            System.out.print("*");
        }
        System.out.println();
    }
    // 1행: i(i) / j(1~4) / k(1)
    // 2행 : i(2) / j(1~3) / k(1~2)
    // ...
    // 5행 : i(5) / j(0) / k(1~5)

    }
}
