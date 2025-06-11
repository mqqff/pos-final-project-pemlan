/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import pkg.DBConnection;
import entity.Cashier;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import pkg.HashUtil;

/**
 *
 * @author atha3
 */
public class AuthDao {    
    private final pkg.DBConnection conn = new DBConnection();
    
    public Cashier authenticate(String username, String password) {
        Cashier user = new Cashier();
        
        try {
            List<Map<String, Object>> users = conn.executeQuery("SELECT TOP 1 password FROM cashiers WHERE username = ?", username);
            if (users.isEmpty()) return null;
            
            Map<String, Object> userDB = users.getFirst();
            
            String passwordDB = userDB.get("password").toString();
            if (!HashUtil.verifyPassword(password, passwordDB)) return null;
            
            userDB = conn.executeQuery("SELECT TOP 1 id, name, username, phone FROM cashiers WHERE username = ?", username).getFirst();
            
            user.setId((int) userDB.get("id"));
            user.setUsername(userDB.get("username").toString());
            user.setName(userDB.get("name").toString());
            user.setPhone(userDB.get("phone").toString());
        } catch (Exception e) {
            Logger.getLogger(AuthDao.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        
        return user;
    }
}
