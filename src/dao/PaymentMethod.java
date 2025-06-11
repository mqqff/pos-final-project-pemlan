/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import pkg.DBConnection;

/**
 *
 * @author atha3
 */
public class PaymentMethod {
    private final DBConnection conn = new DBConnection();
    
    public List<entity.PaymentMethod> getAllPaymentMethods() {
        List<entity.PaymentMethod> list = new ArrayList<>();
        try {
            List<Map<String, Object>> rows = conn.executeQuery("SELECT * FROM payment_methods");

            for (Map<String, Object> row : rows) {
                String name = row.get("name").toString();
                
                list.add(new entity.PaymentMethod(name));   
            }
        } catch (SQLException e) {
            Logger.getLogger(PaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return list;
    }
    
    public entity.PaymentMethod getPaymentMethodByName(String name) {
        entity.PaymentMethod paymentMethod = new entity.PaymentMethod();
        
        try {
            List<Map<String, Object>> rows = conn.executeQuery("SELECT * FROM payment_methods");
            
            if (rows.isEmpty()) return null;

            Map<String, Object> row = rows.getFirst();
            paymentMethod.setName(row.get("name").toString());
        } catch (SQLException e) {
            Logger.getLogger(PaymentMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return paymentMethod;
    }
}
