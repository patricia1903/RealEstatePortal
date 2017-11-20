package com.realestateportalandroid.model;

import java.io.Serializable;


public class Property implements Serializable {

    private String id;
    private String description;
    private String title;
    private String price;
    private String picture;
    private String phone;
    private String address;
    private String email;

    public Property() {
    }

    public Property(String id, String description, String title, String price, String picture, String phone, String address, String email) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.price = price;
        this.picture = picture;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }


    public String getId() {
        return id;
    }

    public String getDescription() {

        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", picture='" + picture + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
