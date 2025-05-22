package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import pkg.Session;
import view.*;
import view.Category;
import view.Customer;
import view.Login;
import view.Product;
import view.Transaction;

public class MainFrame extends javax.swing.JFrame {

    private Category categoryPanel;
    private Product productPanel;
    private Customer customerPanel;
    private Transaction transactionPanel;
    private Login loginPanel;

    public MainFrame() {
        initComponents();

        categoryPanel = new Category();
        productPanel = new Product();
        customerPanel = new Customer();
        transactionPanel = new Transaction();
        loginPanel = new Login();

        tabbedPane.addTab("Login", loginPanel);
        tabbedPane.addTab("Manage Categories", categoryPanel);
        tabbedPane.addTab("Manage Products", productPanel);
        tabbedPane.addTab("Manage Customers", customerPanel);
        tabbedPane.addTab("Manage Transactions", transactionPanel);
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
                    return;
                } else if (selectedTab.equals("Login") && Session.isLoggedIn()) {
                    tabbedPane.setSelectedIndex(1);
                }

                switch (selectedTab) {
                    case "Manage Category" -> categoryPanel.reload();
                    case "Manage Product" -> productPanel.reload();
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
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        tabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(tabbedPane, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }
    
    public javax.swing.JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    // Variables declaration
    private javax.swing.JTabbedPane tabbedPane;
}