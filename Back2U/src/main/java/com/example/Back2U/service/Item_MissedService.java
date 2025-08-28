package com.example.Back2U.service;


import com.example.Back2U.dto.Item_MissedDTO;
import com.example.Back2U.dto.UserDTO;
import com.example.Back2U.model.Item_Missed;
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
    public class Item_MissedService {

        @Autowired
        Item_MissedRepo itemMissedRepo;

        @Autowired
    UserRepo userRepo;


        public List<Item_MissedDTO> getallitem() {
            return itemMissedRepo.findAll().stream().map(Item_MissedDTO::new).toList();
        }

    public ResponseEntity<String> additem(Item_MissedDTO itemMissedDTO) {




        Optional<User> user=userRepo.findByUserMail(itemMissedDTO.getUserMail());

        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User Not Found");
        }

        Item_Missed item=new Item_Missed();



        item.setItemCategory(itemMissedDTO.getItemCategory());
        item.setItemDescription(itemMissedDTO.getItemDescription());
        item.setItemTitle(itemMissedDTO.getItemTitle());
        item.setItemStatus(itemMissedDTO.getItemStatus());
        item.setMissedLocation(itemMissedDTO.getMissedLocation());

        User user1=user.get();

        item.setUser(user1);


        itemMissedRepo.save(item);

        return ResponseEntity.status(HttpStatus.OK).body("Item Added Sucessfully");

    }

        public ResponseEntity<String> updateitem(Item_MissedDTO itemMissedDTO1) {
                Optional<Item_Missed> check=itemMissedRepo.findById(itemMissedDTO1.getItemId());

                if(check.isEmpty()){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Found");
                }

                Item_Missed itemMissed=check.get();


                itemMissed.setItemCategory(itemMissedDTO1.getItemCategory());
                itemMissed.setItemDescription(itemMissedDTO1.getItemDescription());
                itemMissed.setItemTitle(itemMissedDTO1.getItemTitle());
                itemMissed.setItemStatus(itemMissedDTO1.getItemStatus());
                itemMissed.setMissedLocation(itemMissedDTO1.getMissedLocation());

                Optional<User> checkuser=userRepo.findByUserMail(itemMissedDTO1.getUserMail());

                if(checkuser.isEmpty()){
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("User Not Found");
                }

                User user=checkuser.get();

                itemMissed.setUser(user);

                itemMissedRepo.save(itemMissed);

                return ResponseEntity.status(HttpStatus.OK).body("Updated Sucessfully");
        }

    public ResponseEntity<String> deleteitem(int itemId) {
            Optional<Item_Missed> item=itemMissedRepo.findById(itemId);

            if(item.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Not Found");
            }

            itemMissedRepo.deleteById(itemId);
            return ResponseEntity.status(HttpStatus.OK).body("Item Deleted Sucessfully");
    }

    public ResponseEntity<Item_MissedDTO> getitem(int itemId) {
            return itemMissedRepo.findById(itemId).map(item->ResponseEntity.ok(new Item_MissedDTO(item))).orElse(ResponseEntity.notFound().build());
    }
}
