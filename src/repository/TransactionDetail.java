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
 * @author nara
 */
public class TransactionDetail {
    private final pkg.DBConnection conn = new DBConnection();

    public int createTransactionDetails(entity.TransactionDetail td) {
        try {
            int query = conn.executeUpdate("INSERT INTO transactions_details (transaction_id, product_id, quantity) VALUES (?, ?, ?)", td.getTransactionID(), td.getProduct().getName(), td.getQuantity());
            if (query > 0) return 1;
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return 0;
    }
}
