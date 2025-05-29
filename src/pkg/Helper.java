/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

import contracts.Payment;
import entity.payment.CardPayment;
import entity.payment.CashPayment;
import entity.payment.QRISPayment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author atha3
 */
public class Helper {
    public static Payment paymentFactory(String type, long total, long amount, String cardNumber) {
        return switch (type.toLowerCase()) {
            case "cash" -> new CashPayment(total, amount);
            case "card" -> new CardPayment(amount, cardNumber);
            case "qris" -> new QRISPayment(amount);
            default -> throw new IllegalArgumentException("Unknown payment method: " + type);
        };
    }
    
    public static Date formatDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
        }
        
        return date;
    }
    
    public static boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }
    
    public static int findRowByValueInColumn(DefaultTableModel model, int columnIndex, String keyword) {
        for (int row = 0; row < model.getRowCount(); row++) {
            Object value = model.getValueAt(row, columnIndex);
            if (value != null && value.toString().equalsIgnoreCase(keyword)) {
                return row;
            }
        }
        return -1;
    }
}
