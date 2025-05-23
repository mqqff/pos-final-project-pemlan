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

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public CardPayment() {}
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    @Override 
    public boolean pay(long amount) {
        return true;
    }
    
    @Override
    public String getInsertQuery() {
        String query = "INSERT INTO payments (payment_method_id, card_number, amount_paid) values (";
        query += String.format("SELECT id FROM payment_methods WHERE name = 'card', '%s'", cardNumber);
        query += ")";
        
        return query;
    }
}
