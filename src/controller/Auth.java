/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Cashier;

/**
 *
 * @author atha3
 */
public class Auth {
    private repository.Auth authRepo = new repository.Auth();
    
    public boolean login(String username, String password) {
        Cashier cashier = authRepo.login(username, password);
        
        if (cashier == null) return false;
        
        pkg.Session.setUser(cashier);
        
        return true;
    }
}
