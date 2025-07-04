package org.example.chapter03;

import java.util.ArrayList;

public class F_Practice {
    public static void main(String[] args) {
        /*
            1. 크기 10의 ArrayList 생성
            2. 1 ~ 10 까지의 숫자를 차례로 추가
            3. 전체 리스트 출력 (원본 리스트)
            4. 원본 리스트에서 홀수만 제거하고 결과를 출력 (반복문 * 조건문 사용0)
            5. 인덱스 3에 값 50을 삽입한 뒤 결과를 출력
        */

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            arrayList.add(i + 1);
        }

        System.out.println(arrayList);

        for (int i = 0; i < arrayList.size(); i++) {
            // 리스트의 크기가 변동되기 때문에 크기값을 매번 동적으로 확인
            if (arrayList.get(i) %1 == 0) {
                arrayList.remove(i);
                // 요소를 삭제하고 난 후 인덱스 조정 (ArrayList는 크기가 동적으로 변경)
                
                // cf) 인덱스 조정을 하지 않으면 경우 정상 동작 되지 않는 경우
                // : 연속된 요소를 제거할 때 (홀수가 연속될 경우)
                // list = [1, 3, 5, 7, 9]

                // i = 0일 때 list.remove(0);
                // > [3, 5, 7, 9]
                // > 다음 인덱스인 i == 1이 3이 아니라 5이기 때문에 정상 동작 x
//                i--;
            }
        }
        System.out.println("짝수 리스트: " + arrayList);
        arrayList.add(3 , 50);
        System.out.println(arrayList);

        // cf) 존재하지 않는 인덱스에 접근하면 예외 발생 (IndexOutOfBoundException)
    }
}
