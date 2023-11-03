package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter @AllArgsConstructor

public class User {
    private String username;
    private  String password;
    private String lockedOutUserName;
    private String lockedOutPassword;
    private String errorMessage;

    public User(String lockedOutUserName, String lockedOutPassword, String errorMessage) {
        this.lockedOutUserName = lockedOutUserName;
        this.lockedOutPassword = lockedOutPassword;
        this.errorMessage = errorMessage;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }
}
