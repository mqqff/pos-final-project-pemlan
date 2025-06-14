/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import pkg.Session;

/**
 *
 * @author atha3
 */
public class MainFrame extends javax.swing.JFrame {
    private Category categoryPanel;
    private Product productPanel;
    private Customer customerPanel;
    private Transaction transactionPanel;
    private Login loginPanel;
    private TransactionHistory transactionHistoryPanel;
    private Dashboard dashboardPanel;
    private Profile profilePanel;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        categoryPanel = new Category();
        productPanel = new Product();
        customerPanel = new Customer();
        transactionPanel = new Transaction();
        loginPanel = new Login();
        dashboardPanel = new Dashboard();
        transactionHistoryPanel = new TransactionHistory();
        profilePanel = new Profile();

        tabbedPane.addTab("Login", loginPanel);
        tabbedPane.addTab("Dashboard", dashboardPanel);
        tabbedPane.addTab("Category", categoryPanel);
        tabbedPane.addTab("Product", productPanel);
        tabbedPane.addTab("Customer", customerPanel);
        tabbedPane.addTab("Transaction", transactionPanel);
        tabbedPane.addTab("Transaction History", transactionHistoryPanel);
        tabbedPane.addTab("Profile", profilePanel);
        tabbedPane.addTab("Logout", new JPanel());
        
        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) return;
            
            Session.clear();
            tabbedPane.setSelectedIndex(0);
        });

        add(btnLogout, java.awt.BorderLayout.SOUTH);
        
        toggleAuthButton();
        

        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();
                String selectedTab = tabbedPane.getTitleAt(selectedIndex);
                
                btnLogout.setVisible(Session.isLoggedIn());
                
                if (selectedIndex == tabbedPane.getTabCount() - 1) {
                    int confirm = JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                    if (confirm != JOptionPane.YES_OPTION) return;

                    Session.clear();
                    tabbedPane.setSelectedIndex(0);
                }
                
                toggleAuthButton();

                if (!selectedTab.equals("Login") && !Session.isLoggedIn()) {
                    tabbedPane.setSelectedIndex(0);
                    loginPanel.focusUsernameInput();
                    return;
                } else if (selectedTab.equals("Login") && Session.isLoggedIn()) {
                    tabbedPane.setSelectedIndex(1);
                }

                switch (selectedTab) {
                    case "Login" -> loginPanel.focusUsernameInput();
                    case "Category" -> categoryPanel.reload();
                    case "Dashboard" -> dashboardPanel.reload();
                    case "Transaction History" -> {
                        transactionHistoryPanel.reload();
                        transactionHistoryPanel.focusSearch();
                    }
                    case "Transaction" -> {
                        transactionPanel.load();
                        transactionPanel.loadCustomer();
                        transactionPanel.initCashier();
                        transactionPanel.focusOnProductCodeInput();
                    }
                    case "Product" -> productPanel.reload();
                    case "Profile" -> profilePanel.reload();
                }
            }
        });
    }
    
    private void toggleAuthButton() {
        if (Session.isLoggedIn()) {
            tabbedPane.setEnabledAt(0, false);
            tabbedPane.setEnabledAt(tabbedPane.getTabCount() - 1, true);
        } else {
            tabbedPane.setEnabledAt(0, false);
            tabbedPane.setEnabledAt(tabbedPane.getTabCount() - 1, false);
            loginPanel.focusUsernameInput();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    public javax.swing.JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
