/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.payment;

/**
 *
 * @author atha3
 */
public class CashPayment implements contracts.PaymentContract {
    private long total;
    private long amountPaid;
    
    public CashPayment(long total, long amountPaid) {
        this.amountPaid = amountPaid;
        this.total = total;
    }
    
    public CashPayment() {}
    
    public long getAmountPaid() {
        return amountPaid;
    }
    
    public void setAmountPaid(long amountPaid) {
        this.amountPaid = amountPaid;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    
    public long getChange() {
        return amountPaid - total;
    }
    
    @Override
    public String getInsertSQL() {
        String query = "INSERT INTO payments (payment_method_id, amount_paid) values (";
        query += String.format("(SELECT id FROM payment_methods WHERE name = 'cash'), %d", amountPaid);
        query += ")";
        
        return query;
    }
    
    @Override
    public String getType() {
        return "cash";
    }
}
