package org.example.z_project.phr_solution.dto.Patient.request;

import lombok.AllArgsConstructor;
import lombok.Data;


// Request 요청 dto의 값을 꺼내와서 사용할 수 있다.
@Data
@AllArgsConstructor
public class PatientCreateRequestDto {
    private String name;
    private int age;
    private String gender;
}
