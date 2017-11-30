package com.example.manthole.delihamper;

/**
 * Created by manthole on 09 Nov 2017.
 */

public class Profile {

    private String name;
    private String lastname;
    private String address;
    private String contactNumber;
    private String email;
    private String password;


    public Profile() {

    }

    public Profile(String name, String lastname, String address, String contactNumber, String email, String password) {

        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
        this.password = password;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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
}


