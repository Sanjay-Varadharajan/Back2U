package com.example.Back2U.controller;

import com.example.Back2U.dto.UserDTO;
import com.example.Back2U.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/back2u")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<UserDTO> users(){
        return userService.users();
    }

    @PostMapping("/adduser")
    public ResponseEntity<String> adduser(@RequestBody UserDTO userdto){
        return userService.adduser(userdto);
    }

    @PutMapping("/updateuser")
    public ResponseEntity<String> updateuser(@RequestBody UserDTO userdto){
        return userService.update(userdto);
    }

    @DeleteMapping("/deleteuser")
    public ResponseEntity<String> deleteuser(@RequestParam("userMail")String userMail){
        return userService.deleteuser(userMail);
    }

    @GetMapping("/user/{userMail}")
    public ResponseEntity<UserDTO> getuser(@PathVariable String userMail){
        return userService.getuser(userMail);
    }
}
