package xyz.thaumazein.patientservice.mapper;

import xyz.thaumazein.patientservice.dtos.PatientResponse;
import xyz.thaumazein.patientservice.entities.Patient;

public class PatientMapper {
    public static PatientResponse toDto(Patient patient) {
        return new PatientResponse(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDateOfBirth());
    }
}
