package com.example.Back2U.controller;


import com.example.Back2U.dto.Item_MissedDTO;
import com.example.Back2U.dto.UserDTO;
import com.example.Back2U.model.Item_Missed;
import com.example.Back2U.service.Item_MissedService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/back2u")
public class Item_MissedController {


    @Autowired
    Item_MissedService itemMissedService;

    @GetMapping("/items")
    public List<Item_MissedDTO> getallitem(){
        return itemMissedService.getallitem();
    }

    @PostMapping("/additem")
    public ResponseEntity<String> additem(@RequestBody Item_MissedDTO itemMissedDTO){
        return itemMissedService.additem(itemMissedDTO);
    }

    @PutMapping("/updateitem")
    public ResponseEntity<String> updateitem(@RequestBody Item_MissedDTO itemMissedDTO1){
        return itemMissedService.updateitem(itemMissedDTO1);
    }

    @DeleteMapping("/deleteitem")
    public ResponseEntity<String> deleteitem(@RequestParam("itemId")int itemId){
        return itemMissedService.deleteitem(itemId);
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity<Item_MissedDTO> getitem(@PathVariable int itemId){
        return itemMissedService.getitem(itemId);
    }
}
