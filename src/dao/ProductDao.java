/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import pkg.DBConnection;

/**
 *
 * @author atha3
 */
public class ProductDao {
  private final DBConnection conn = new DBConnection();

  public List<entity.Product> getAllProducts() {
    List<entity.Product> products = new ArrayList<>();
    try {
        String query = """
            SELECT i.*, c.id AS category_id, c.name AS category_name, c.description AS category_description
            FROM products i
            LEFT JOIN categories c
            ON i.category_id = c.id
            """;
        List<Map<String, Object>> rows = conn.executeQuery(query);

        for (Map<String, Object> row : rows) {
          int id = (int) row.get("id");
          String name = row.get("name").toString();
          String code = row.get("code").toString();
          int stock = Integer.parseInt(row.get("stock").toString());
          long price = Long.parseLong(row.get("price").toString());

          int categoryId = row.get("category_id") != null  ? (int) row.get("category_id") : null;
          String categoryName = row.get("category_name") != null ? row.get("category_name").toString() : null;
          String categoryDescription = row.get("category_description") != null
              ? row.get("category_description").toString()
              : null;
          entity.Category category = new entity.Category(categoryId, categoryName, categoryDescription);

          products.add(new entity.Product(id, name, code, category, stock, price));
        }
    } catch (SQLException e) {
        Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
    }

    return products;
  }

  public entity.Product getProductById(entity.Product p) {
    try {
        String query = """
            SELECT TOP 1 i.*, c.id AS category_id, c.name AS category_name, c.description AS category_description
            FROM products i
            LEFT JOIN categories c
            ON i.category_id = c.id
            WHERE i.id = ?
            """;
        List<Map<String, Object>> products = conn.executeQuery(query, p.getId());

        if (products.isEmpty()) return null;

        Map<String, Object> product = products.getFirst();

        String name = product.get("name").toString();
        String code = product.get("code").toString();
        long price = Long.parseLong(product.get("price").toString());
        int stock = Integer.parseInt(product.get("stock").toString());

        int categoryId = product.get("category_id") != null  ? (int) product.get("category_id") : null;
        String categoryName = product.get("category_name") != null ? product.get("category_name").toString() : null;
        String categoryDescription = product.get("category_description") != null
            ? product.get("category_description").toString()
            : null;
        entity.Category category = new entity.Category(categoryId, categoryName, categoryDescription);

        p.setName(name);
        p.setCode(code);
        p.setPrice(price);
        p.setStock(stock);
        p.setCategory(category);
    } catch (SQLException e) {
        Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
    }

    return p;
  }
  
  public entity.Product getProductByCode(entity.Product p) {
    try {
        String query = """
            SELECT TOP 1 i.*, c.id AS category_id, c.name AS category_name, c.description AS category_description
            FROM products i
            LEFT JOIN categories c
            ON i.category_id = c.id
            WHERE i.code = ?
            """;
        List<Map<String, Object>> products = conn.executeQuery(query, p.getCode());

        if (products.isEmpty()) return null;

        Map<String, Object> product = products.getFirst();

        int id = (int) product.get("id");
        String name = product.get("name").toString();
        long price = Long.parseLong(product.get("price").toString());
        int stock = Integer.parseInt(product.get("stock").toString());

        int categoryId = product.get("category_id") != null  ? (int) product.get("category_id") : null;
        String categoryName = product.get("category_name") != null ? product.get("category_name").toString() : null;
        String categoryDescription = product.get("category_description") != null
            ? product.get("category_description").toString()
            : null;
        entity.Category category = new entity.Category(categoryId, categoryName, categoryDescription);

        p.setId(id);
        p.setName(name);
        p.setPrice(price);
        p.setStock(stock);
        p.setCategory(category);
    } catch (SQLException e) {
        Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
    }

    return p;
  }

  public int createProduct(entity.Product p) {
    try {
        String query = """
            INSERT INTO products (name, code, category_id, stock, price)
            VALUES (
              ?,
              ?,
              (SELECT id FROM categories WHERE name = ?),
              ?,
              ?
            )
            """;

        int queryResult = conn.executeUpdate(query, p.getName(), p.getCode(), p.getCategory().getName(), p.getStock(),
            p.getPrice());
        if (queryResult > 0)
          return 1;
    } catch (SQLException e) {
        Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
    }

    return 0;
  }

  public int updateProduct(entity.Product i) {
    try {
      String query = """
          UPDATE products
          SET name = ?,
              code = ?,
              category_id = (SELECT id FROM categories WHERE name = ?),
              stock = ?,
              price = ?
          WHERE id = ?
          """;

        int rowsAffected = conn.executeUpdate(query, i.getName(), i.getCode(), i.getCategory().getName(), i.getStock(),
            i.getPrice(), i.getId());
        if (rowsAffected > 0)
          return 1;
    } catch (SQLException e) {
        Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
    }

    return 0;
  }

  public int deleteProduct(entity.Product p) {
    try {
        String query = "DELETE FROM products WHERE id = ?";
        int rowsAffected = conn.executeUpdate(query, p.getId());
        if (rowsAffected > 0)
          return 1;
    } catch (SQLException e) {
        Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
    }

    return 0;
  }
  
  public long countProducts() {
    try {
        String query = "SELECT count(*) AS total_products FROM products";
        Map<String, Object> row = conn.executeQuery(query).getFirst();

        return Long.parseLong(row.get("total_products").toString());
    } catch (SQLException e) {
        Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
    }

    return 0;
  }
}
