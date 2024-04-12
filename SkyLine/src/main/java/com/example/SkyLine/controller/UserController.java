package com.example.SkyLine.controller;
// UserController.java
// UserController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SkyLine.model.User;
import com.example.SkyLine.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
    
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/api/children/sortBy/{field}")
    public ResponseEntity<?> getchild(@PathVariable String field)
    {
        try
        {
            return new ResponseEntity<>(userService.getchild(field),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/flight/{offset}/{pagesize}")
    public ResponseEntity<?> gettchild(@PathVariable int offset,@PathVariable int pagesize)
    {
        try
        {
            return new ResponseEntity<>(userService.gettchild(offset,pagesize),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/flight/{offset}/{pagesize}/{field}")
    public ResponseEntity<?> getttchild(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        try
        {
            return new ResponseEntity<>(userService.getttchild(offset,pagesize,field),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
