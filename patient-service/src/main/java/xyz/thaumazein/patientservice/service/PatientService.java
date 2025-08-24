package xyz.thaumazein.patientservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.thaumazein.patientservice.dto.PatientRequest;
import xyz.thaumazein.patientservice.dto.PatientResponse;
import xyz.thaumazein.patientservice.exception.EmailAlreadyExistsException;
import xyz.thaumazein.patientservice.mapper.PatientMapper;
import xyz.thaumazein.patientservice.repository.PatientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<PatientResponse> getPatients() {
        return patientRepository.findAll().stream().map(PatientMapper::toDto).toList();
    }

    public PatientResponse createPatient(PatientRequest request) {
        if (patientRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException("A patient with this email already exists: %s".formatted(request.email()));
        }

        var patient = patientRepository.save(PatientMapper.toEntity(request));

        return PatientMapper.toDto(patient);
    }
}
