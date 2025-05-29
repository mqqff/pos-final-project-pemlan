/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Logger;
import pkg.DBConnection;

/**
 *
 * @author atha3
 */
public class Payment {
    private final DBConnection conn = new DBConnection();
    
    /**
     * @param p
     * @return id
     */
    public int createPayment(contracts.Payment p) {
        BigDecimal id = new BigDecimal(-1);
        try {
            int query = conn.executeUpdate(p.getInsertSQL());
            if (query < 1) return 0;
            
            id = (BigDecimal) conn.executeQuery("SELECT @@IDENTITY AS id").getFirst().get("id");
        } catch (SQLException e) {
            Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return id.intValue();
    }
}
