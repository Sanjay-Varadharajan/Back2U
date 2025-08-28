package com.example.Back2U.service;


import com.example.Back2U.dto.UserDTO;
import com.example.Back2U.model.User;
import com.example.Back2U.repo.Item_MissedRepo;
import com.example.Back2U.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepo userRepo;




    public List<UserDTO> users() {
        return userRepo.findAll().stream().map(UserDTO::new).toList();
    }


    public ResponseEntity<String> adduser(UserDTO userdto) {
        Optional<User> check=userRepo.findByUserMail(userdto.getUserMail());

        if(check.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User Already exists");
        }

        User user=new User();
        user.setUserMail(userdto.getUserMail());
        user.setUserName(userdto.getUserName());
        user.setUserPhone(userdto.getUserPhone());

        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("User Added Sucessfully");

    }


    public ResponseEntity<String> update(UserDTO userdto) {

        Optional<User> check=userRepo.findByUserMail(userdto.getUserMail());

        if(check.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        }

        User user=check.get();

        user.setUserName(userdto.getUserName());
        user.setUserPhone(userdto.getUserPhone());
        user.setUserMail(userdto.getUserMail());

        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("User Updated Sucessfully");
    }

    public ResponseEntity<String> deleteuser(String userMail) {
        Optional<User> check=userRepo.findByUserMail(userMail);

        if(check.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Available");
        }


        userRepo.delete(check.get());
        return ResponseEntity.status(HttpStatus.OK).body("User Deleted Sucessfully");
    }

    public ResponseEntity<UserDTO> getuser(String userMail) {
        return userRepo.findByUserMail(userMail).map(user -> ResponseEntity.ok(new UserDTO(user))).orElse(ResponseEntity.notFound().build());
    }
}
