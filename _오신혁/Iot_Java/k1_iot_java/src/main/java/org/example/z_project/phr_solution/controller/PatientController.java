package org.example.z_project.phr_solution.controller;

import org.example.z_project.phr_solution.dto.Patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.Patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.Patient.response.PatientDetailResponseDto;
import org.example.z_project.phr_solution.dto.Patient.response.PatientListResponseDto;
import org.example.z_project.phr_solution.service.PatientService;
import org.example.z_project.phr_solution.service.implement.PatientServiceImpl;

import java.util.List;

public class PatientController {
    // 변하지 않는 값 final을 명시해주고 service를 가져온다
    private final PatientService patientService;
    
    // 생성자
    public PatientController() {
        this.patientService = new PatientServiceImpl();
    }
    // patient 생성
    public void registerPatient(PatientCreateRequestDto dto) {
        patientService.registerPatient(dto);
    }
    // 조회 (List 타입의 객체를 반환해야 하기 때문에 타입에 List<PatientListResponseDto> 명시해준다)
    public List<PatientListResponseDto> getAllPatients() {
        List<PatientListResponseDto> result = patientService.listAllPatients();
        return result;
    }
    // 단건조회 (단건 조회는 전체 리스트가 아니기 때문에 PatientDetailResponseDto에 타입을 명시 )
    public PatientDetailResponseDto getPatientById(Long id) {
        PatientDetailResponseDto result = patientService.getPatientById(id);
        return result;
    }
    // 수정
    public void updatePatient(Long id, PatientUpdateRequestDto dto) {
        patientService.updatePatient(id, dto);
    }
    // 삭제
    public void deletePatient(Long id) {
        patientService.deletePatient(id);
    }

}
