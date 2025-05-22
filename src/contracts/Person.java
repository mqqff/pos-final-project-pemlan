package contracts;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author atha3
 */
public abstract class Person {
    protected String name;
    protected String phone;
    
    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    
    public Person() {
        
    }
    
    public String getName() {
        return name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
