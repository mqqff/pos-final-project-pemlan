/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.util.Date;
import java.util.List;
/**
 *
 * @author nara
 */
public class Transaction {
    private int id;
    private entity.Cashier cashier;
    private entity.Customer customer;
    private String invoiceNo;
    private long total;
    private entity.Payment payment;
    private Date date;
    private List<entity.TransactionDetail> transactionDetails;
    
   public Transaction (Cashier cashier, Customer customer, String invoiceNo, long total, entity.Payment payment, String note, List<entity.TransactionDetail> transactionDetails) {
        this.customer = customer;
        this.invoiceNo = invoiceNo;
        this.total = total;
        this.payment = payment;
        this.transactionDetails = transactionDetails;
    } 
   
    public Transaction() {}
   
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
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

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public entity.Payment getPayment() {
        return payment;
    }

    public void setPayment(entity.Payment payment) {
        this.payment = payment;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public List<entity.TransactionDetail> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<entity.TransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}
