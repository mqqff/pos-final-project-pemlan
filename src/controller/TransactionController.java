package controller;

import entity.TransactionDetail;
import java.security.SecureRandom;
import java.util.List;
import pkg.Helper;
import entity.Customer;
import pkg.Session;
import contracts.PaymentContract;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nara
 */
public class TransactionController {
    private final dao.PaymentDao paymentDao = new dao.PaymentDao();
    private final dao.TransactionDao transactionDao = new dao.TransactionDao();
    private final dao.TransactionDetailDao transactionDetailDao = new dao.TransactionDetailDao();
    private final dao.ProductDao productDao = new dao.ProductDao();
    
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
        PaymentContract p = Helper.paymentFactory(paymentMethod, total, amount, cardNumber);
        int paymentId = paymentDao.createPayment(p);
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
        
        int transactionId = transactionDao.createTransaction(t);
        if (transactionId < 0) return 0;
        
        for (TransactionDetail item : items) {
            entity.Product pr = item.getProduct();
            pr.setStock(pr.getStock() - item.getQty());
            int rowsAffected = productDao.updateProduct(pr);
            if (rowsAffected < 1) return 0;
            
            item.setTransactionId(transactionId);
            rowsAffected = transactionDetailDao.createTransactionDetail(item);
            if (rowsAffected < 1) return 0;
        }
        
        return 1;
    }
    
    public List<entity.Transaction> getAllTransactions() {
        return transactionDao.getAllTransactions();
    }
    
    public long countTransactions() {
        return transactionDao.countTransactions();
    }
    
    public long countIncome() {
        return transactionDao.countIncome();
    }
}
