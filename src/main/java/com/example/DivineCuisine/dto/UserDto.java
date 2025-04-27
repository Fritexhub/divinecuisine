
package com.example.DivineCuisine.dto;

public class UserDto {
    private String fullname;
    private String email;
    private String address;

    private String password;
    public UserDto() {
    }

    public UserDto(String fullname, String email, String address, String password) {
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}