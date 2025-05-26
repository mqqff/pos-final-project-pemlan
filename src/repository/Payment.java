/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.SQLException;
import java.util.logging.Logger;
import pkg.DBConnection;

/**
 *
 * @author atha3
 */
public class Payment {
    private final DBConnection conn = new DBConnection();
    
    public int createPayment(contracts.Payment p) {
        try {
            int query = conn.executeUpdate(p.getInsertSQL());
            if (query > 0) return 1;
        } catch (SQLException e) {
            Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return 0;
    }
}
