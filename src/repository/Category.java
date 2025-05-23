/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.logging.*;
import java.sql.*;
import java.util.*;
import pkg.DBConnection;

/**
 *
 * @author atha3
 */
public class Category {
    private final pkg.DBConnection conn = new DBConnection();
    
    public entity.Category getCategoryByName(String name) {
        entity.Category c = new entity.Category();
        
        try {
            List<Map<String, Object>> categories = conn.executeQuery("SELECT * FROM categories WHERE name = ? LIMIT 1", name);
            
            if (categories.isEmpty()) return null;
            
            Map<String, Object> category = categories.getFirst();
            
            c.setName(category.get("name").toString());
            c.setDescription(category.get("description").toString());
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return c;
    }
    
    public List<entity.Category> getAllCategories() {
        List<entity.Category> list = new ArrayList<>();
        
        try {
            List<Map<String, Object>> rows = conn.executeQuery("SELECT * FROM categories");

            for (Map<String, Object> row : rows) {
                String name = row.get("name").toString();
                String description = row.get("description").toString();
                
                list.add(new entity.Category(name, description));   
            }
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return list;
    }

    public int createCategory(entity.Category c) {
        try {
            int query = conn.executeUpdate("INSERT INTO categories (name, description) VALUES (?, ?)", c.getName(), c.getDescription());
            if (query > 0) return 1;
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return 0;
    }
    
    public int updateCategory(entity.Category c, String oldName) {
        try {
            int query = conn.executeUpdate("UPDATE categories SET name = ?, description = ? WHERE name = ?", c.getName(), c.getDescription(), oldName);
            if (query > 0) return 1;
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return 0;
    }
    
    public int deleteCategory(String categoryName) {
        try {
            int query = conn.executeUpdate("DELETE FROM categories WHERE name = ?", categoryName);
            if (query > 0) return 1;
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return 0;
    }
}
