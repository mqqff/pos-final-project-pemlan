/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import pkg.DBConnection;
import pkg.Helper;

/**
 *
 * @author nara
 */
public class TransactionDao {
     private final pkg.DBConnection conn = new DBConnection();
     
     public List<entity.Transaction> getAllTransactions() {
         List<entity.Transaction> transactions = new ArrayList<>();
        try {
            String sql = """
                SELECT 
                    t.*,
                    c.name AS customer_name,
                    ca.name AS cashier_name,
                    pa.name AS payment_method,
                    p.card_number, p.amount_paid
                FROM transactions t
                LEFT JOIN customers c
                ON t.customer_id = c.id
                LEFT JOIN payments p
                ON t.payment_id = p.id
                LEFT JOIN payment_methods pa
                ON p.payment_method_id = pa.id
                LEFT JOIN cashiers ca
                ON t.cashier_id = ca.id
                SELECT 
                    t.id, t. invoice_no, t.total, t.date,
                    pa.name AS payment_method
                FROM transactions t
                LEFT JOIN payments p
                ON t.payment_id = p.id
                LEFT JOIN payment_methods pa
                ON p.payment_method_id = pa.id
            """;
            List<Map<String, Object>> rows = conn.executeQuery(sql);
            
            if (rows.isEmpty()) return null;
            
            for (Map<String, Object> row : rows) {
                int id = (int) row.get("id");
                String invoiceNo = row.get("invoice_no").toString();
                Date date = Helper.formatDate(row.get("date").toString());
                long total = (long) row.get("total");

                String cashierName = row.get("cashier_name").toString();

                String paymentMethod = row.get("payment_method").toString();
                long amount = (long) row.get("amount_paid");

                entity.Cashier ca = new entity.Cashier();
                ca.setName(cashierName);

                contracts.PaymentContract p = Helper.paymentFactory(paymentMethod, total, amount, null);

                entity.Payment pa = new entity.Payment();
                pa.setType(p.getType());
                pa.setAmountPaid(amount);
                
                if (row.get("card_number") != null) {
                    pa.setCardNumber(row.get("card_number").toString());
                }
                
                entity.Transaction t = new entity.Transaction();
                t.setId(id);
                t.setInvoiceNo(invoiceNo);
                t.setDate(date);
                t.setTotal(total);
                t.setCashier(ca);
                t.setPayment(pa);

                if (row.get("customer_id") != null) {
                    String customerName = row.get("customer_name").toString();

                    entity.Customer c = new entity.Customer();
                    c.setName(customerName);

                    t.setCustomer(c);
                }
                
                transactions.add(t);
            }
        } catch (SQLException e) {
            Logger.getLogger(CategoryDao.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return transactions;
     }
    
      public int createTransaction(entity.Transaction t) {
        BigDecimal id = new BigDecimal(-1);
        try {
            String SQL;
            int query;
            
            if (t.getCustomer() == null) {
                SQL = """
                         INSERT INTO transactions 
                         (invoice_no, total, payment_id, cashier_id)
                         VALUES (
                            ?, 
                            ?, 
                            ?, 
                            (
                               SELECT id FROM cashiers WHERE name = ?
                            )
                         )
                         """;
                query = conn.executeUpdate(SQL, t.getInvoiceNo(), t.getTotal(), t.getPayment().getId(), t.getCashier().getName() );
            } else {
                SQL = """
                         INSERT INTO transactions 
                         (invoice_no, total, customer_id, payment_id, cashier_id)
                         VALUES (
                         ?, 
                         ?, 
                         (
                           SELECT id FROM customers WHERE name = ?
                         ), 
                         ?, 
                          (
                            SELECT id FROM cashiers WHERE name = ?
                         )
                         )
                         """;
                query = conn.executeUpdate(SQL, t.getInvoiceNo(), t.getTotal(), t.getCustomer().getName(), t.getPayment().getId(), t.getCashier().getName() );
            }
            
            if (query < 1) return 0;
            
            id = (BigDecimal) conn.executeQuery("SELECT @@IDENTITY AS id").getFirst().get("id");
        } catch (SQLException e) {
            Logger.getLogger(CategoryDao.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return id.intValue();
    }
        
    public long countTransactions() {
        try {
            String query = "SELECT count(*) AS total_transactions FROM transactions";
            Map<String, Object> row = conn.executeQuery(query).getFirst();

            return Long.parseLong(row.get("total_transactions").toString());
        } catch (SQLException e) {
            Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }

        return 0;
    }
    
    public long countIncome() {
        try {
            String query = "SELECT sum(total) AS income FROM transactions";
            Map<String, Object> row = conn.executeQuery(query).getFirst();

            return (long) row.get("income");
        } catch (SQLException e) {
            Logger.getLogger(ProductDao.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }

        return 0;
    }
}
