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
    private int quantity;
    private Product product;
    private int Transaction_ID;
    
    public TransactionDetail(int quantity, Product product){
    this.quantity =  quantity;
    this.product = product; 
    }
    
    public int getQuantity() {
    return this.quantity;
    }
    
    public void setQuantity(int quantity){
    this.quantity =  quantity;
    }
    
    public Product getProduct() {
    return this.product;
    }
    
    public void setQuantity(Product product){
    this.product =  product;
    }
    
    public int getTransactionID() {
    return this.Transaction_ID;
    }
    
    public void setTransactionID(int Transaction_ID){
    this.Transaction_ID =  Transaction_ID;
    }
}


