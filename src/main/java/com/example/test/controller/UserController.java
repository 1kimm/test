package com.example.test.controller;

import com.example.test.model.User;
import com.example.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class UserController {

    @GetMapping("/test")
    String test(Model model) {
        Map<String, String> first = null;
        first.put("hana", "hi");
        model.addAttribute("first", first);
        return "testView";
    }

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public String read(@PathVariable Long id) {

        Optional<User> userOptional = userRepository.findById(id);
        userOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
}
