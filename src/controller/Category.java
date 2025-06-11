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
public class Category {
    private final dao.Category categoryDao = new dao.Category();

    public int createCategory(String name, String description) {
        entity.Category c = new entity.Category();
        c.setName(name);
        c.setDescription(description);
        return categoryDao.createCategory(c);
    }
    
    public int updateCategory(String name, String description, int id) {
        entity.Category c = new entity.Category();
        c.setId(id);
        c.setName(name);
        c.setDescription(description);
        return categoryDao.updateCategory(c);
    }
    
    public entity.Category getCategoryById(int id) {
        entity.Category c = new entity.Category();
        c.setId(id);
        return categoryDao.getCategoryById(c);
    }
    
    public int deleteCategory(int id) {
        entity.Category c = new entity.Category();
        c.setId(id);
        return categoryDao.deleteCategory(c);
    }

    public List<entity.Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}
