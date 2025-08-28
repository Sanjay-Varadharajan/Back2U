package com.example.Back2U.dto;

import com.example.Back2U.enums.ItemStatus;
import com.example.Back2U.model.Item_Missed;
import com.example.Back2U.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Item_MissedDTO {


    private int itemId;

    private String itemTitle;

    private String itemDescription;

    private String itemCategory;

    private ItemStatus itemStatus;

    private String missedLocation;

    private LocalDateTime dateReported;

  private String userMail;


    public Item_MissedDTO(int itemId, String itemTitle, String itemDescription, String itemCategory, ItemStatus itemStatus, String missedLocation, LocalDateTime dateReported) {
        this.itemId = itemId;
        this.itemTitle = itemTitle;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemStatus = itemStatus;
        this.missedLocation = missedLocation;
        this.dateReported = dateReported;
    }

    public Item_MissedDTO() {
    }

    public Item_MissedDTO(Item_Missed itemMissed){
        this.itemId=itemMissed.getItemId();
        this.itemCategory=itemMissed.getItemCategory();
        this.itemDescription=itemMissed.getItemDescription();
        this.itemTitle=itemMissed.getItemTitle();
        this.missedLocation=itemMissed.getMissedLocation();
        this.dateReported=itemMissed.getDateReported();
        this.itemStatus=itemMissed.getItemStatus();
        this.userMail = itemMissed.getUser() != null ? itemMissed.getUser().getUserMail() :null;
    }
}
