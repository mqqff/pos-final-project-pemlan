/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package contracts;

/**
 *
 * @author atha3
 */
public interface Payment {
    boolean pay(long amount);
    String getInsertSQL();
}
