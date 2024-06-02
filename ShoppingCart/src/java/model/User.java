/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private int isSeller;
    private int isAdmin;
    private String country;
    private String contact;
    public User() {
    }

    
    public User(int id, String name, String email, String password, int isSeller, int isAdmin, String country, String contact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isSeller = isSeller;
        this.isAdmin = isAdmin;
        this.country = country;
        this.contact = contact;
    }

    public User(int id, String name, String email, String password, String country, String contact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(int isSeller) {
        this.isSeller = isSeller;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", isSeller=" + isSeller + ", isAdmin=" + isAdmin + ", country=" + country + ", contact=" + contact + '}';
    }



   
}
