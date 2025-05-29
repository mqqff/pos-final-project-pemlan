/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nara
 */
public class TransactionDetail {
    private int id;
    private int qty;
    private Product product;
    private int transactionId;
    
    public TransactionDetail(int qty, Product product){
        this.qty =  qty;
        this.product = product; 
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getQty() {
        return this.qty;
    }
    
    public void setQty(int qty){
        this.qty =  qty;
    }
    
    public Product getProduct() {
        return this.product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public int getTransactionId() {
        return this.transactionId;
    }
    
    public void setTransactionId(int transactionId){
        this.transactionId = transactionId;
    }
}


