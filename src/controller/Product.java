/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;

/**
 *
 * @author atha3
 */
public class Product {
  private repository.Product productRepo = new repository.Product();

  public int createProduct(String name, String code, String categoryName, int stock, long price) {
    entity.Product p = new entity.Product();
    entity.Category c = new entity.Category();
    c.setName(categoryName);

    p.setName(name);
    p.setCode(code);
    p.setCategory(c);
    p.setStock(stock);
    p.setPrice(price);
    return productRepo.createProduct(p);
  }

  public int updateProduct(String name, String code, String categoryName, int stock, long price, String oldCode) {
    entity.Product p = new entity.Product();
    entity.Category c = new entity.Category();
    c.setName(categoryName);

    p.setName(name);
    p.setCode(code);
    p.setCategory(c);
    p.setStock(stock);
    p.setPrice(price);
    return productRepo.updateProduct(p, oldCode);
  }

  public entity.Product getProductByCode(String code) {
    return productRepo.getProductByCode(code);
  }

  public int deleteProduct(String code) {
    return productRepo.deleteProduct(code);
  }

  public List<entity.Product> getAllProducts() {
    return productRepo.getAllProducts();
  }
}
