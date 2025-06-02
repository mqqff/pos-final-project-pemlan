package controller;

import entity.TransactionDetail;
import java.security.SecureRandom;
import java.util.List;
import pkg.Helper;
import contracts.Payment;
import entity.Customer;
import pkg.Session;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nara
 */
public class Transaction {
    private final repository.Payment paymentRepo = new repository.Payment();
    private final repository.Transaction transactionRepo = new repository.Transaction();
    private final repository.TransactionDetail transactionDetailRepo = new repository.TransactionDetail();
    private final repository.Product productRepo = new repository.Product();
    
    public String generateInvoice() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 8;
        
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }
    
    public int createTransaction(List<TransactionDetail> items, String cust, String invoiceNo, long total, String paymentMethod, long amount, String cardNumber) {
        Payment p = Helper.paymentFactory(paymentMethod, total, amount, cardNumber);
        int paymentId = paymentRepo.createPayment(p);
        if (paymentId < 0) return 0;
        
        entity.Payment pa = new entity.Payment();
        pa.setId(paymentId);
        
        entity.Transaction t = new entity.Transaction();
        t.setCashier(Session.getCashier());
        t.setInvoiceNo(invoiceNo);
        t.setTotal(total);
        t.setPayment(pa);
        
        if (!cust.equals("")) {
            Customer c = new Customer();
            c.setName(cust);
            t.setCustomer(c);
        }
        
        int transactionId = transactionRepo.createTransaction(t);
        if (transactionId < 0) return 0;
        
        for (TransactionDetail item : items) {
            entity.Product pr = item.getProduct();
            pr.setStock(pr.getStock() - item.getQty());
            int rowsAffected = productRepo.updateProduct(pr);
            if (rowsAffected < 1) return 0;
            
            item.setTransactionId(transactionId);
            rowsAffected = transactionDetailRepo.createTransactionDetail(item);
            if (rowsAffected < 1) return 0;
        }
        
        return 1;
    }
    
    public List<entity.Transaction> getAllTransactions() {
        return transactionRepo.getAllTransactions();
    }
    
    public long countTransactions() {
        return transactionRepo.countTransactions();
    }
    
    public long countIncome() {
        return transactionRepo.countIncome();
    }
}
