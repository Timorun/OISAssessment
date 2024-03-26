package com.assessment.api;

import com.assessment.model.Admin;
import com.assessment.model.Participant;
import com.assessment.repository.AdminRepository;
import com.assessment.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // Autowired automatically provides an instance of the specified bean type and assign it to that variable
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    // Admin login redirect
    @GetMapping("/login")
    public String showLogin() {
        return "admin_login";
    }

//    @GetMapping("/logout")
//    public String showSignup() {
//        return "admin_login";
//    }

//    @PostMapping("/login")
//    public String login(@RequestParam("username") String username,
//                        @RequestParam("password") String password,
//                        Model model) {
//        Admin admin = adminRepository.findByUsernameAndPassword(username, password);
//        if (admin != null) {
//            return "redirect:/admin/dashboard";
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "admin_login";
//        }
//    }


//    @PostMapping("/signout")
//    public String logout(Model model) {
//        model.addAttribute("error", "You have signed out");
//        return "admin_login";
//    }

    // Admin dashboard
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        Iterable<Participant> participants = participantRepository.findAll();
        model.addAttribute("participants", participants);
        return "admin_dashboard";
    }

    // Eliminate participants
    @PostMapping("/delete/{pid}")
    public String deleteParticipant(@PathVariable("pid") Long pid) {
        participantRepository.deleteById(pid);
        return "redirect:/admin/dashboard";
    }
}
