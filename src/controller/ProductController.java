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
public class ProductController {
  private final dao.ProductDao productDao = new dao.ProductDao();

  public int createProduct(String name, String code, String categoryName, int stock, long price) {
    entity.Product p = new entity.Product();
    entity.Category c = new entity.Category();
    c.setName(categoryName);

    p.setName(name);
    p.setCode(code);
    p.setCategory(c);
    p.setStock(stock);
    p.setPrice(price);
    return productDao.createProduct(p);
  }

  public int updateProduct(String name, String code, String categoryName, int stock, long price, int id) {
    entity.Product p = new entity.Product();
    entity.Category c = new entity.Category();
    c.setName(categoryName);

    p.setId(id);
    p.setName(name);
    p.setCode(code);
    p.setCategory(c);
    p.setStock(stock);
    p.setPrice(price);
    return productDao.updateProduct(p);
  }

  public entity.Product getProductById(int id) {
    entity.Product p = new entity.Product();
    p.setId(id);
    return productDao.getProductById(p);
  }
  
  public entity.Product getProductByCode(String code) {
    entity.Product p = new entity.Product();
    p.setCode(code);
    return productDao.getProductByCode(p);
  }

  public int deleteProduct(int id) {
    entity.Product p = new entity.Product();
    p.setId(id);
    return productDao.deleteProduct(p);
  }

  public List<entity.Product> getAllProducts() {
    return productDao.getAllProducts();
  }
  
  public long countProducts() {
      return productDao.countProducts();
  }
}
