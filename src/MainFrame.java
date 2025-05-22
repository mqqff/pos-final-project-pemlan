import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import view.*;

public class MainFrame extends javax.swing.JFrame {

    private Category categoryPanel;
    private Product productPanel;
    private Customer customerPanel;
    private Transaction transactionPanel;

    public MainFrame() {
        initComponents();

        categoryPanel = new Category();
        productPanel = new Product();
        customerPanel = new Customer();
        transactionPanel = new Transaction();

        tabbedPane.addTab("Manage Categories", categoryPanel);
        tabbedPane.addTab("Manage Products", productPanel);
        tabbedPane.addTab("Manage Customers", customerPanel);
        tabbedPane.addTab("Manage Transactions", transactionPanel);

        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();
                String selectedTab = tabbedPane.getTitleAt(selectedIndex);

                System.out.println("Tab berpindah ke: " + selectedTab);

                switch (selectedTab) {
                    case "Manage Category" -> categoryPanel.reload();
                    case "Manage Product" -> productPanel.reload();
                }
            }
        });
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

    // Variables declaration
    private javax.swing.JTabbedPane tabbedPane;
}