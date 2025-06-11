/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;

public class CustomerController {
    private final dao.CustomerDao customerDao = new dao.CustomerDao();

    public int createCustomer(String name, String phone, String address) {
        entity.Customer c = new entity.Customer();
        c.setName(name);
        c.setPhone(phone);
        c.setAddress(address);
        return customerDao.createCustomer(c);
    }

    public int updateCustomer(String name, String phone, String address, int id) {
        entity.Customer c = new entity.Customer();
        c.setId(id);
        c.setName(name);
        c.setPhone(phone);
        c.setAddress(address);
        return customerDao.updateCustomer(c);
    }

    public entity.Customer getCustomerById(int id) {
        entity.Customer c = new entity.Customer();
        c.setId(id);
        return customerDao.getCustomerById(c);
    }

    public int deleteCustomer(int id) {
        entity.Customer c = new entity.Customer();
        c.setId(id);
        return customerDao.deleteCustomer(c);
    }

    public List<entity.Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }
    
    public long countCustomers() {
      return customerDao.countCustomers();
  }
}
