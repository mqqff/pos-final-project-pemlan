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
public class Transaction {
     private final pkg.DBConnection conn = new DBConnection();
    
      public int createTransaction(entity.Transaction t) {
        try {
            String SQL = """
                         INSERT INTO transactions 
                         (invoiceNo, total, customer_id, payment_id, cashier_id)
                         VALUES (
                         ?, 
                         ?, 
                         (
                           SELECT id FROM customers WHERE name = '?'
                         ), 
                         ?, 
                          (
                            SELECT id FROM cashiers WHERE name = '?'
                         )
                         )
                         """;
            int query = conn.executeUpdate(SQL, t.getInvoiceNo(), t.getTotal(), t.getCustomer().getName(), t.getPayment().getId(), t.getCashier().getName() );
            if (query > 0) return 1;
        } catch (SQLException e) {
            Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return 0;
    }
        
}
