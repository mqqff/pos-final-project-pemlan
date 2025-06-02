/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

/**
 *
 * @author atha3    
 */
public class Session {
    private static entity.Cashier currentCashier;

    public static void setCashier(entity.Cashier cashier) {
        currentCashier = cashier;
    }

    public static entity.Cashier getCashier() {
        return currentCashier;
    }

    public static void clear() {
        currentCashier = null;
    }

    public static boolean isLoggedIn() {
        return currentCashier != null;
    }
}
