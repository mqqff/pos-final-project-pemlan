/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nara
 */
public class Customer extends contracts.Person{
    private int id;
    private String address;
    
    public Customer(String address){
        this.address = address;
    }
    
    public Customer() {}
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}
