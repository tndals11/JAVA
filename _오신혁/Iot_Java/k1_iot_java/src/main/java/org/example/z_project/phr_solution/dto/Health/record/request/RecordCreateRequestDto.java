package org.example.z_project.phr_solution.dto.Health.record.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecordCreateRequestDto {
    private Long patientId;
    private String dateOfVisit;
    private String diagnosis;
    private String treatment;
}

