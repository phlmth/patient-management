package xyz.thaumazein.patientservice.mapper;

import xyz.thaumazein.patientservice.dto.PatientRequest;
import xyz.thaumazein.patientservice.dto.PatientResponse;
import xyz.thaumazein.patientservice.entity.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponse toDto(Patient patient) {
        return new PatientResponse(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDateOfBirth());
    }

    public static Patient toEntity(PatientRequest request) {
        var patient = new Patient();

        patient.setName(request.name());
        patient.setEmail(request.email());
        patient.setAddress(request.address());
        patient.setDateOfBirth(LocalDate.parse(request.dateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(request.registeredDate()));

        return patient;
    }

    public static void update(PatientRequest request, Patient patient) {
        patient.setName(request.name());
        patient.setAddress(request.address());
        patient.setEmail(request.email());
        patient.setDateOfBirth(LocalDate.parse(request.dateOfBirth()));
    }
}
