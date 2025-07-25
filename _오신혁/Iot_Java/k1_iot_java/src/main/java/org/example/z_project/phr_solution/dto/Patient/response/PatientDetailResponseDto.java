package org.example.z_project.phr_solution.dto.Patient.response;

import lombok.AllArgsConstructor;
import lombok.Data;

// Response 생성하는 것
@Data
@AllArgsConstructor
public class PatientDetailResponseDto {
    private Long id;
    private String name;
    private int age;
}
