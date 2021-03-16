package com.example.testacc;

public class User {
    private String name;
    private String address;
    private String number;


    public User() {}
    public User(String name, String address, String number) {
        this.name=name;
        this.address=address;
        this.number=number;

    }


    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}

