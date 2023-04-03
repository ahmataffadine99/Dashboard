
package com.epitech.dashboard.Controllers;


import com.epitech.dashboard.Models.User;
import com.epitech.dashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public ResponseEntity<User> create (@RequestBody User user) {
        userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).body(user);
    }

    @GetMapping()
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
