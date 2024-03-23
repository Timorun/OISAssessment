package com.assessment.api;

import com.assessment.model.Participant;
import com.assessment.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParticipantController {

    @GetMapping("/api/test")
    public String getString() {
        return "/api/test endpoint reached";
    }

    @Autowired
    private ParticipantRepository participantRepository;

    @PostMapping("/register")
    public Participant registerParticipant(@RequestBody Participant participant) {
        return participantRepository.save(participant);
    }
}
