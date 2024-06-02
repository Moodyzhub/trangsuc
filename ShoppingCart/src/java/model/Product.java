/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Product {

    private String gia;
    private int id;
    private String name;
    private double price;
    private String image;
    private String title;
    private String describes;
    private String image1;
    private String image2;
    Category cate;

    public Product() {
    }

    public Product(String gia, int id, String name, double price, String image, String title, String describes, String image1, String image2) {
        this.gia = gia;
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.title = title;
        this.describes = describes;
        this.image1 = image1;
        this.image2 = image2;
    }

    public Product(String gia, int id, String name, double price, String image, String title, String describes, String image1, String image2, Category cate) {
        this.gia = gia;
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.title = title;
        this.describes = describes;
        this.image1 = image1;
        this.image2 = image2;
        this.cate = cate;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    @Override
    public String toString() {
        return "Product{" + "gia=" + gia + ", id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", title=" + title + ", describes=" + describes + ", image1=" + image1 + ", image2=" + image2 + '}';
    }

}
