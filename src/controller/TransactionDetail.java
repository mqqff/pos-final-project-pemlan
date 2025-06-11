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
public class TransactionDetail {
    private final dao.TransactionDetail tdDao = new dao.TransactionDetail();
    
    public List<entity.TransactionDetail> getTransactionDetailsByTransactionId(int tId) {
        return tdDao.getTransactionDetailsByTransactionId(tId);
    }
}
