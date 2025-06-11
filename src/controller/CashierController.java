/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import pkg.HashUtil;
import pkg.Session;

/**
 *
 * @author atha3
 */
public class CashierController {
    private final dao.CashierDao cashierDao = new dao.CashierDao();
    private final dao.AuthDao authDao = new dao.AuthDao();
    
    public int updateCashier(String name, String username, String phone) {
        entity.Cashier c = new entity.Cashier(name, phone, username);
        c.setId(Session.getCashier().getId());
        
        entity.Cashier cDB = cashierDao.getCashierByUsername(c);
        if (cDB != null && cDB.getId() != Session.getCashier().getId()) return -1;
        
        int rowsAffected = cashierDao.updateCashier(c);
        if (rowsAffected < 1) return 0;
        
        Session.setCashier(c);
        
        return 1;
    }
    
    public int updatePassword(String oldPassword, String newPassword) {
        entity.Cashier c = authDao.authenticate(Session.getCashier().getUsername(), oldPassword);
        if (c == null) return -1;
        
        return cashierDao.updatePassword(c, HashUtil.hashPassword(newPassword));
    }
}
