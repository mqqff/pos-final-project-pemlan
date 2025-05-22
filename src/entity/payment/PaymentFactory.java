/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.payment;

import contracts.Payment;

/**
 *
 * @author atha3
 */
public class PaymentFactory {
    public static Payment create(String type, long amount, String cardNumber, long change) {
        return switch (type.toLowerCase()) {
            case "cash" -> new CashPayment(amount, change);
            case "card" -> new CardPayment(cardNumber);
            case "qris" -> new QRISPayment(amount);
            default -> throw new IllegalArgumentException("Unknown payment method: " + type);
        };
    }
}
