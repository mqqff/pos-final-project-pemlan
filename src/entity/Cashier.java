/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author atha3
 */
public class Cashier extends contracts.Person {
    private String username;
    
    public Cashier(String name, String phone, String username) {
        super(name, phone);
        this.username = username;
    }
    public Cashier(){
    }
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
}
