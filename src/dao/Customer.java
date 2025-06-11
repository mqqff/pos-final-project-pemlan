/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.logging.*;
import java.sql.*;
import java.util.*;
import pkg.DBConnection;

public class Customer {
    private final pkg.DBConnection conn = new DBConnection();

    public entity.Customer getCustomerById(entity.Customer c) {
        try {
            List<Map<String, Object>> customers = conn.executeQuery("SELECT TOP 1 * FROM customers WHERE id = ?", c.getId());
            
            if (customers.isEmpty()) return null;
            
            Map<String, Object> customer = customers.getFirst();
            
            c.setName(customer.get("name").toString());
            c.setPhone(customer.get("phone").toString());
            c.setAddress(customer.get("address").toString());
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return c;
    }

    public List<entity.Customer> getAllCustomers() {
        List<entity.Customer> list = new ArrayList<>();
        try {
            List<Map<String, Object>> rows = conn.executeQuery("SELECT * FROM customers");
            for (Map<String, Object> row : rows) {
                int id = (int) row.get("id");
                String name = row.get("name").toString();
                String phone = row.get("phone").toString();
                String address = row.get("address").toString();
                list.add(new entity.Customer(id, name, phone, address));
            }
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public int createCustomer(entity.Customer c) {
        try {
            int query = conn.executeUpdate("INSERT INTO customers (name, phone, address) VALUES (?, ?, ?)", 
                c.getName(), c.getPhone(), c.getAddress());
            if (query > 0) return 1;
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int updateCustomer(entity.Customer c) {
        try {
            int query = conn.executeUpdate("UPDATE customers SET name = ?, phone = ?, address = ? WHERE id = ?", 
                c.getName(), c.getPhone(), c.getAddress(), c.getId());
            if (query > 0) return 1;
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int deleteCustomer(entity.Customer c) {
        try {
            int query = conn.executeUpdate("DELETE FROM customers WHERE id = ?", c.getId());
            if (query > 0) return 1;
        } catch (SQLException e) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    
    public long countCustomers() {
    try {
        String query = "SELECT count(*) AS total_customers FROM customers";
        Map<String, Object> row = conn.executeQuery(query).getFirst();

        return Long.parseLong(row.get("total_customers").toString());
    } catch (SQLException e) {
        Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
    }

    return 0;
  }
}
