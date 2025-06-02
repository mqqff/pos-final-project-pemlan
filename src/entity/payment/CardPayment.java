/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.payment;

/**
 *
 * @author atha3
 */
public class CardPayment implements contracts.Payment {
    private String cardNumber;
    private long amountPaid;

    public CardPayment(long amountPaid, String cardNumber) {
        this.cardNumber = cardNumber;
        this.amountPaid = amountPaid;
    }
    
    public CardPayment() {}
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public long getAmountPaid() {
        return amountPaid;
    }
    
    public void setAmountPaid(long amountPaid) {
        this.amountPaid = amountPaid;
    }
    
    @Override
    public String getInsertSQL() {
        String query = "INSERT INTO payments (payment_method_id, card_number, amount_paid) values (";
        query += String.format("(SELECT id FROM payment_methods WHERE name = 'card'), '%s', '%d'", cardNumber, amountPaid);
        query += ")";
        
        return query;
    }
    
    @Override
    public String getType() {
        return "card";
    }
}
