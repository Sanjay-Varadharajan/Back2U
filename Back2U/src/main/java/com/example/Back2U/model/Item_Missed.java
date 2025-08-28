package com.example.Back2U.model;


import com.example.Back2U.enums.ItemStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Data
@Entity
public class Item_Missed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    private String itemTitle;

    private String itemDescription;

    private String itemCategory;

    private ItemStatus itemStatus;

    private String missedLocation;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime dateReported;

    @JoinColumns({
        @JoinColumn(name = "userId",referencedColumnName = "userid",nullable = false),
        @JoinColumn(name = "userMail", referencedColumnName = "usermail",nullable = false)
    })
    @ManyToOne
    private User user;


    public Item_Missed(int itemId, String itemTitle, String itemDescription, String itemCategory, ItemStatus itemStatus, String missedLocation, LocalDateTime dateReported, User user) {
        this.itemId = itemId;
        this.itemTitle = itemTitle;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemStatus = itemStatus;
        this.missedLocation = missedLocation;
        this.dateReported = dateReported;
        this.user = user;
    }

    public Item_Missed() {
    }

    public Item_Missed(String itemTitle, String itemDescription, String itemCategory, ItemStatus itemStatus, String missedLocation, User user) {
        this.itemTitle = itemTitle;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemStatus = itemStatus;
        this.missedLocation = missedLocation;
        this.user = user;
    }
}
