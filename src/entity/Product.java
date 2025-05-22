/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author atha3
 */
public class Product {
  private String name;
  private String code;
  private entity.Category category;
  private int stock;
  private long price;

  public Product() {
  }

  public Product(String name, String code, entity.Category category, int stock, long price) {
    this.name = name;
    this.code = code;
    this.category = category;
    this.stock = stock;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public entity.Category getCategory() {
    return category;
  }

  public void setCategory(entity.Category category) {
    this.category = category;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }
}
