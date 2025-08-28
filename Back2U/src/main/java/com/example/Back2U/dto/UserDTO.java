package com.example.Back2U.dto;

import com.example.Back2U.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@Data
@NoArgsConstructor
public class UserDTO {

    private int userId;

    private String userName;

    private String userMail;

    private String userPhone;

    private LocalDateTime dateTime;




    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.userMail = user.getUserMail();
        this.userPhone = user.getUserPhone();
        this.dateTime = user.getDateTime();
    }

    public UserDTO(int userId, String userName, String userMail, String userPhone, LocalDateTime dateTime) {
        this.userId = userId;
        this.userName = userName;
        this.userMail = userMail;
        this.userPhone = userPhone;
        this.dateTime = dateTime;
    }

    public UserDTO(String userName, String userMail, String userPhone) {
        this.userName = userName;
        this.userMail = userMail;
        this.userPhone = userPhone;
    }
}
