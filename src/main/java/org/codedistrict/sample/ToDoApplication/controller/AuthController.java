//package org.codedistrict.sample.ToDoApplication.controller;
//
//import org.codedistrict.sample.ToDoApplication.entity.User;
//import org.codedistrict.sample.ToDoApplication.repository.UserRepository;
//import org.codedistrict.sample.ToDoApplication.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("")
//public class AuthController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
//        String username = credentials.get("username");
//        String password = credentials.get("password");
//
//        User user = userRepository.findByUsername(username);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//        }
//    }
//
//    @GetMapping("/register")
//    public String register(Model model) {
//        model.addAttribute("user", new User());
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String registerUser(@RequestBody User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userService.createUser(user);
//        return "redirect:/login";
//    }
//}
