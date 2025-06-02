/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import pkg.DBConnection;

/**
 *
 * @author atha3
 */
public class Cashier {
    private final DBConnection conn = new DBConnection();
    
    public entity.Cashier getCashierByUsername(entity.Cashier c) {
        entity.Cashier cashier = new entity.Cashier();
        try {
            List<Map<String, Object>> rows = conn.executeQuery("SELECT id FROM cashiers WHERE username = ?", c.getUsername());
            if (rows.isEmpty()) return null;
            
            Map<String, Object> row = rows.getFirst();
            cashier.setId((int) row.get("id"));
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return cashier;
    }
    
    public int updateCashier(entity.Cashier c) {
        try {
            int query = conn.executeUpdate("UPDATE cashiers SET name = ?, username = ?, phone = ? WHERE id = ?", c.getName(), c.getUsername(), c.getPhone(), c.getId());
            if (query > 0) return 1;
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return 0;
    }
    
    public int updatePassword(entity.Cashier c, String password) {
        try {
            int query = conn.executeUpdate("UPDATE cashiers SET password = ? WHERE id = ?", password, c.getId());
            if (query > 0) return 1;
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return 0;
    }
}
