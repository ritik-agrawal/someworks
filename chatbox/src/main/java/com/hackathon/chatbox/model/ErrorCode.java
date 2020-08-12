package com.hackathon.chatbox.model;

import lombok.Getter;

public enum ErrorCode {
    //Need to add the error as the project grows
    RANDOM_ERROR                   (0001,"Started implementation. will add later.");

    @Getter private int code;
    @Getter private String message;

    private ErrorCode(int code, String message){
        this.message = message;
        this.code = code;
    }
}
