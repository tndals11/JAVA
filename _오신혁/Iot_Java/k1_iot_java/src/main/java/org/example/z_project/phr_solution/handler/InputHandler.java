package org.example.z_project.phr_solution.handler;

import org.example.z_project.phr_solution.dto.Health.record.request.RecordCreateRequestDto;
import org.example.z_project.phr_solution.dto.Patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.Patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.entity.Patient;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner sc = new Scanner(System.in);

    public static int getChoice() {
        while (!sc.hasNextInt()) {
            System.out.println("숫자를 입력해주세요");
            sc.nextLine();
        }
        int choice = sc.nextInt();
        sc.nextLine(); // 버퍼 처리
        return choice;
    }
    public static String getInput(String prompt) {
        while (true) {
            System.out.println(prompt + ": ");
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("입력값을 비워둘 수 없습니다. 다시 입력해주세요.");
        }
    }

    public static Long getIdInput() {
        String input = getInput("ID를 입력하세요");
        return Long.parseLong(input);
    }

    public static void closeScanner() {
        sc.close();
    }

    // 요청
    // 1) 환자 정보 - 생성, 수정
    public static PatientCreateRequestDto createPatientRequest() {
        PatientCreateRequestDto dto = null;
        try {
            String name = getInput("환자 이름을 입력해주세요");
            int age = Integer.parseInt(getInput("환자 나이를 입력해주세요"));
            String gender = getInput("환자 성별을 입력해주세요.");

            if (!gender.equals("남") && !gender.equals("여")) {
                System.out.println("올바른 성별을 입력해주세요. (남/여)");
                return null;
            } else {
                dto = new PatientCreateRequestDto(name, age, gender);
            }
        } catch (NumberFormatException e) {
            System.out.println("환자 나이는 숫자값을 입력해야 합니다. " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dto;
    }
    
    // 2) 건강 기록 정보 - 생성
    public static RecordCreateRequestDto createRecordRequest() {
        RecordCreateRequestDto dto = null;
        try {
            long patientId = getIdInput();
            String dateOfVisit = getInput("방문 날짜를 입력하세요(예: 2025-07-25)");
            // ? 문자열의 포멧이 DateTime과 다를 경우?]
            String diagnosis = getInput("진단명을 입력하세요.");
            String treatment = getInput("처방 내용을 입력하세요.");

            dto = new RecordCreateRequestDto(patientId, dateOfVisit, diagnosis, treatment);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dto;
    }


    public static PatientUpdateRequestDto updatePatientRequest() {
        PatientUpdateRequestDto dto = null;
        try {
            String name = getInput("환자 이름을 입력해주세요");
            int age = Integer.parseInt(getInput("환자 나이를 입력해주세요"));
            dto = new PatientUpdateRequestDto(name, age);
            System.out.println("수정이 완료되었습니다");
        } catch (NumberFormatException e) {
            System.out.println("환자 나이는 숫자값을 입력해야 합니다. " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dto;
    }


}
