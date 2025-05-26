/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nara
 */
public class Payment {
    private int id;
    private String cardNumber;
    private long amountPaid;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
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
}
