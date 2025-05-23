/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author atha3
 */
public class PaymentMethod {
    private String name;
    
    public PaymentMethod(String name) {
        this.name = name;
    }
    
    public PaymentMethod() {}
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
