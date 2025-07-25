package org.example.z_project.phr_solution.repository;

import org.example.z_project.phr_solution.entity.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientRepository  {
    List<Patient> patients = new ArrayList<>();

    // static final 처리를 하고 인스턴스를 생성
    private static final  PatientRepository instance = new PatientRepository();

    // 생성자를 만들어서 생성자를 막는다
    private PatientRepository() {}

    // getInstance 메서드를 정의
    public static PatientRepository getInstance() {
        return instance;
    }

    public void save(Patient patient) {
        // 생성(CREATE), 수정(UPDATE)가 같은 save 메서드를 사용
        Optional<Patient> existing = findById(patient.getId());
        // ifPresent 만약에 존재한다면 함수를 실행, 함수가 없다면 실행x
        existing.ifPresent(this::delete); // 전달받은 환자의 id가 이미 존재하는 경우 삭제

        patients.add(patient); // 새로운 데이터 추가
    }

    public List<Patient> findAll() {
        // 새로운 new 주소값에 담아서 반환해준다
        return new ArrayList<>(patients);
    }

    public Optional<Patient> findById(Long id) {

        return patients.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst();
    }

    public void delete(Patient patient) {
        patients.remove(patient);
    }
}
