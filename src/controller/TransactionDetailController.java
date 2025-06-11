/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;

/**
 *
 * @author atha3
 */
public class TransactionDetailController {
    private final dao.TransactionDetailDao tdDao = new dao.TransactionDetailDao();
    
    public List<entity.TransactionDetail> getTransactionDetailsByTransactionId(int tId) {
        return tdDao.getTransactionDetailsByTransactionId(tId);
    }
}
