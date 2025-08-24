package xyz.thaumazein.patientservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.thaumazein.patientservice.dto.PatientRequest;
import xyz.thaumazein.patientservice.dto.PatientResponse;
import xyz.thaumazein.patientservice.service.PatientService;
import xyz.thaumazein.patientservice.validation.CreatePatientValidationGroup;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/patients")
@Tag(name = "Patient", description = "API for managing Patients")
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    @Operation(summary = "Get Patients")
    public List<PatientResponse> getPatients() {
        return patientService.getPatients();
    }

    @PostMapping
    @Operation(summary = "Create a new Patients")
    public ResponseEntity<PatientResponse> createPatient(@RequestBody
                                                         @Validated({Default.class, CreatePatientValidationGroup.class})
                                                         PatientRequest request) {

        var patientResponse = patientService.createPatient(request);

        return ResponseEntity.ok(patientResponse);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Patient")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable UUID id,
                                                         @RequestBody @Validated({Default.class}) PatientRequest request) {

        var patientResponse = patientService.updatePatient(id, request);

        return ResponseEntity.ok(patientResponse);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Patient")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
