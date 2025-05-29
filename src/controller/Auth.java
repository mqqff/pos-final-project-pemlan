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
    private final repository.Auth authRepo = new repository.Auth();
    
    public boolean login(String username, String password) {
        Cashier cashier = authRepo.authenticate(username, password);
        
        if (cashier == null) return false;
        
        pkg.Session.setCashier(cashier);
        
        return true;
    }
}
