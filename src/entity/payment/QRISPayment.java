/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.payment;

/**
 *
 * @author atha3
 */
public class QRISPayment implements contracts.PaymentContract {
    private long amountPaid;
    
    public QRISPayment(long amountPaid) {
        this.amountPaid = amountPaid;
    }
    
    public QRISPayment() {}
    
    public long getAmountPaid() {
        return amountPaid;
    }
    
    public void setAmountPaid(long amountPaid) {
        this.amountPaid = amountPaid;
    }
    
    @Override
    public String getInsertSQL() {
        String query = "INSERT INTO payments (payment_method_id, amount_paid) values (";
        query += String.format("(SELECT id FROM payment_methods WHERE name = 'qris'), %d", amountPaid);
        query += ")";
        
        return query;
    }
    
    @Override
    public String getType() {
        return "qris";
    }
}
