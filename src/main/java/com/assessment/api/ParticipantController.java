package com.assessment.api;

import com.assessment.model.Participant;
import com.assessment.repository.ParticipantRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ParticipantController {

    @GetMapping("/api/test")
    public String getString() {
        return "/api/test endpoint reached";
    }


    // Autowired automatically provides an instance of the specified bean type and assign it to that variable
    @Autowired
    private ParticipantRepository participantRepository;


    @PostMapping("/api/signup")
    public ResponseEntity<?> registerParticipant(@Valid @RequestBody Participant participant, BindingResult bindingResult) {
        // First we check that json received does not contain blanks and email is in right format
        if (bindingResult.hasErrors()) {
            // If there are validation errors, collect error messages and return them along with a bad request status
            List<String> errors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            // If validation passes, we try to save the participant
            Participant savedParticipant = participantRepository.save(participant);
            return ResponseEntity.ok(savedParticipant);
        } catch (DataIntegrityViolationException e) {
            // If email is not unique, return error message. Return as part of list to facilitate parsing later on to have same format as validation errors.
            List<String> error = new ArrayList<>();
            error.add("Email has already been used");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
}
