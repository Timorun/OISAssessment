package com.assessment.api;

import com.assessment.model.Participant;
import com.assessment.repository.ParticipantRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    @GetMapping("/test")
    public String getString() {
        return "/participants/test endpoint reached";
    }

    // Autowired automatically provides an instance of the specified bean type and assign it to that variable
    @Autowired
    private ParticipantRepository participantRepository;

    @PostMapping("/signup")
    public ResponseEntity<?> registerParticipant(@Valid @RequestBody Participant participant, BindingResult bindingResult) {
        // First we check that json received does not contain blanks and email is in right format
        if (bindingResult.hasErrors()) {
            // We check if there are validation errors with getFieldErrors(),
            // collect error messages and return them along with a bad request status
            List<String> errors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            // If validation passes, we try to store the participant in db
            Participant savedParticipant = participantRepository.save(participant);
            return ResponseEntity.ok("Signed up successfully");
        } catch (DataIntegrityViolationException e) {
            // If email is not unique, return error message. Return as part of list to facilitate parsing later on, consistent to format with validation errors.
            List<String> error = new ArrayList<>();
            error.add("Email has already been used");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }


    // Method to retrieve list of participants and pass it to Thymeleaf template
    @GetMapping("/dashboard")
    public String participantsTable(Model model) {
        List<Participant> participants = participantRepository.findAll();
        model.addAttribute("participants", participants);

        return "participants";
    }


    // Method to eliminate participants
    @DeleteMapping("/participants/delete/{pid}")
    public ResponseEntity<?> deleteParticipant(@PathVariable("pid") Long pid) {
        try {
            participantRepository.deleteById(pid);
            return ResponseEntity.ok("Participant deleted successfully");
        } catch (EmptyResultDataAccessException ex) {
            // If participant with the given ID doesn't exist
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // If there's any other exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
