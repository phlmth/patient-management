package xyz.thaumazein.patientservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.thaumazein.patientservice.dto.PatientRequest;
import xyz.thaumazein.patientservice.dto.PatientResponse;
import xyz.thaumazein.patientservice.service.PatientService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    public List<PatientResponse> getPatients() {
        return patientService.getPatients();
    }

    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(@RequestBody @Valid PatientRequest request) {
        var patientResponse = patientService.createPatient(request);

        return ResponseEntity.ok(patientResponse);
    }
}
