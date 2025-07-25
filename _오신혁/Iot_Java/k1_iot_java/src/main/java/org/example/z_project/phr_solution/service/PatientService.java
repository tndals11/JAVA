package org.example.z_project.phr_solution.service;

import org.example.z_project.phr_solution.dto.Patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.Patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.Patient.response.PatientDetailResponseDto;
import org.example.z_project.phr_solution.dto.Patient.response.PatientListResponseDto;

import java.util.List;

public interface PatientService {
    // 생성 (요청 x)
    void registerPatient(PatientCreateRequestDto dto);
    // 전체조회 (응답 List 배열)
    List<PatientListResponseDto> listAllPatients();
    // 단건조회
    PatientDetailResponseDto getPatientById(Long id);
    // 수정
    void updatePatient(Long id, PatientUpdateRequestDto dto);
    // 삭제
    void deletePatient(Long id);
}
