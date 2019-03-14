package com.ekoapp.ekoplayground.usecases;

public class UserLogInRequest implements EkoRequest {

    private String username;
    private String password;

    public UserLogInRequest() {
    }

    public UserLogInRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
