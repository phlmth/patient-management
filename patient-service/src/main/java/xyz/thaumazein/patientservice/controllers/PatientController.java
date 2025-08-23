package xyz.thaumazein.patientservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.thaumazein.patientservice.dtos.PatientResponse;
import xyz.thaumazein.patientservice.services.PatientService;

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
}
