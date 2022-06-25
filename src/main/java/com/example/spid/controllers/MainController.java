package com.example.spid.controllers;

import com.example.spid.entities.Spid;
import com.example.spid.entities.User;
import com.example.spid.service.SpidService;
import com.example.spid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    UserService userService;
    @Autowired
    SpidService spidService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser (@RequestBody User user){
        return new ResponseEntity(userService.createUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById (@PathVariable (name = "id") Long id)throws Exception{
        return new ResponseEntity(userService.getUser(id), HttpStatus.OK);
    }

    @PutMapping("/editUser/{id}")
    public ResponseEntity<User> editUser (
            @RequestBody User user,
            @PathVariable (name = "id") Long id) throws Exception {
        return new ResponseEntity(userService.editUser(id, user), HttpStatus.OK);
    }

    @DeleteMapping("/deleteSpid/{id}")
    public ResponseEntity<String> deleteSpid (@PathVariable(name = "id") Long id) throws Exception {
        spidService.deleteSpid(id);
        return new ResponseEntity("Spid with id " +id+" has been deleted.", HttpStatus.OK);
    }

    @PostMapping("/addSpid")
    public ResponseEntity<Spid> addSpid (@RequestBody Spid spid) throws Exception{
        return new ResponseEntity(spidService.createSpid(spid),HttpStatus.OK);
    }

    @GetMapping("/getAllSpids")
    public ResponseEntity<List<Spid>> getAllSpids() throws Exception {
        return new ResponseEntity(spidService.retrieveAllSpids(), HttpStatus.OK);
    }

    @PutMapping("/changeStatus/{id}")
    public ResponseEntity<Spid> changeSpidStatus(
            @PathVariable (name = "id")Long id) throws Exception {
        return new ResponseEntity(spidService.changeStatus(id),HttpStatus.OK);
    }
}
