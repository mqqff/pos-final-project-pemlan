/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;

public class Customer {
    private repository.Customer customerRepo = new repository.Customer();

    public int createCustomer(String name, String phone, String address) {
        entity.Customer c = new entity.Customer();
        c.setName(name);
        c.setPhone(phone);
        c.setAddress(address);
        return customerRepo.createCustomer(c);
    }

    public int updateCustomer(String name, String phone, String address, int id) {
        entity.Customer c = new entity.Customer();
        c.setId(id);
        c.setName(name);
        c.setPhone(phone);
        c.setAddress(address);
        return customerRepo.updateCustomer(c);
    }

    public entity.Customer getCustomerById(int id) {
        entity.Customer c = new entity.Customer();
        c.setId(id);
        return customerRepo.getCustomerById(c);
    }

    public int deleteCustomer(int id) {
        entity.Customer c = new entity.Customer();
        c.setId(id);
        return customerRepo.deleteCustomer(c);
    }

    public List<entity.Customer> getAllCustomers() {
        return customerRepo.getAllCustomers();
    }
    
    public long countCustomers() {
      return customerRepo.countCustomers();
  }
}
