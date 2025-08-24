package xyz.thaumazein.patientservice.dto;

import java.time.LocalDate;
import java.util.UUID;

public record PatientResponse(UUID id,
                              String name,
                              String email,
                              String address,
                              LocalDate dateOfBirth) {
}
