package xyz.thaumazein.patientservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.thaumazein.patientservice.dtos.PatientResponse;
import xyz.thaumazein.patientservice.mapper.PatientMapper;
import xyz.thaumazein.patientservice.repositories.PatientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<PatientResponse> getPatients() {
        return patientRepository.findAll().stream().map(PatientMapper::toDto).toList();
    }
}
