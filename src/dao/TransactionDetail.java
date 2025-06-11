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
 * @author nara
 */
public class TransactionDetail {
    private final pkg.DBConnection conn = new DBConnection();
    
    public List<entity.TransactionDetail> getTransactionDetailsByTransactionId(int transactionId) {
        List<entity.TransactionDetail> list = new ArrayList<>();
        try {
            List<Map<String, Object>> rows = conn.executeQuery("SELECT td.*, p.name AS product_name, p.price AS product_price FROM transaction_details td JOIN products p ON td.product_id = p.id WHERE transaction_id = ?", transactionId);
            
            for (Map<String, Object> row : rows) {
                int id = (int) row.get("id");
                int qty = (int) row.get("qty");
                
                String productName = row.get("product_name").toString();
                long price = (long) row.get("product_price");
                
                entity.Product p = new entity.Product();
                p.setName(productName);
                p.setPrice(price);
                
                entity.TransactionDetail td = new entity.TransactionDetail(qty, p);
                td.setId(id);
                
                list.add(td);
            }
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return list;
    }

    public int createTransactionDetail(entity.TransactionDetail td) {
        try {
            int query = conn.executeUpdate("INSERT INTO transaction_details (transaction_id, product_id, qty) VALUES (?, ?, ?)", td.getTransactionId(), td.getProduct().getId(), td.getQty());
            if (query > 0) return 1;
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return 0;
    }
}
