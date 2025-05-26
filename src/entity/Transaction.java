/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author nara
 */
public class Transaction {
    private entity.Cashier cashier;
    private entity.Customer customer;
    private String invoiceNo;
    private double total;
    private entity.Payment payment;
    private double amount;
    private String note;
    List<entity.TransactionDetail> transactionDetails = new ArrayList<>();
    
   public Transaction (Cashier cashier, Customer customer, String invoiceNo, double total, entity.Payment payment, double amount, String note, List<entity.TransactionDetail> transactionDetails) {
   this.customer = customer;
   this.invoiceNo = invoiceNo;
   this.total = total;
   this.payment = payment;
   this.amount = amount;
   this.note = note;
   this.transactionDetails = transactionDetails;
} 
   public Cashier getCashier(){
    return this.cashier;
    }
    
    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }
    
    public Customer getCustomer(){
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public entity.Payment getPayment() {
        return payment;
    }

    public void setPayment(entity.Payment payment) {
        this.payment = payment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<entity.TransactionDetail> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<entity.TransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}
