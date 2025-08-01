package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserRepository repo;

    // ✅ New: Handle root URL
    @GetMapping("/")
    public String home() {
        return "redirect:/login";  // Redirect to the login page
    }

    // Show the login form page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Maps to templates/login.html
    }

    // Handle form submission and validate login
    @PostMapping("/login")
    public String validateLogin(@ModelAttribute("user") User user, Model model) {
        User u = repo.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (u != null) {
            model.addAttribute("message", "Login Successful!");
            model.addAttribute("color", "color:green");
        } else {
            model.addAttribute("message", "Invalid Credentials!");
            model.addAttribute("color", "color:red");
        }

        return "result";  // Maps to templates/result.html
    }

    // Bind the form with a default User object
    @ModelAttribute("user")
    public User getDefaultUser() {
        return new User();
    }
}
