package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<AddUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public AddUser saveUser(@RequestBody AddUser  user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public AddUser  getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @PutMapping("/{id}")
    public AddUser  updateUser(@PathVariable Long id, @RequestBody AddUser  updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User with id " + id + " has been deleted successfully.";
    }
}
