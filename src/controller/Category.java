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
    private repository.Category categoryRepo = new repository.Category();

    public int createCategory(String name, String description) {
        entity.Category c = new entity.Category();
        c.setName(name);
        c.setDescription(description);
        return categoryRepo.createCategory(c);
    }
    
    public int updateCategory(String name, String description, String oldName) {
        entity.Category c = new entity.Category();
        c.setName(name);
        c.setDescription(description);
        return categoryRepo.updateCategory(c, oldName);
    }
    
    public entity.Category getCategoryByName(String name) {
        return categoryRepo.getCategoryByName(name);
    }
    
    public int deleteCategory(String name) {
        return categoryRepo.deleteCategory(name);
    }

    public List<entity.Category> getAllCategories() {
        return categoryRepo.getAllCategories();
    }
}
