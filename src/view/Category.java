/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author atha3
 */
public class Category extends javax.swing.JPanel {
    private final controller.CategoryController categoryController = new controller.CategoryController();
    private final List<entity.Category> categories = new ArrayList<>();
    private int modifiedCategoryId;

    /**
     * Creates new form CategoryController
     */
    public Category() {
        initComponents();
        reload();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoryTitle = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        categoryName = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        categoryDescription = new javax.swing.JTextField();
        btnAddCategory = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
        btnDeleteCategory = new javax.swing.JButton();
        btnEditCategory = new javax.swing.JToggleButton();

        categoryTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        categoryTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoryTitle.setText("Manage Categories");

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nameLabel.setText("Name");

        descriptionLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        descriptionLabel.setText("Description");

        btnAddCategory.setText("Add");
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });

        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        categoryTable.setMaximumSize(null);
        jScrollPane1.setViewportView(categoryTable);

        btnDeleteCategory.setText("Delete Selected");
        btnDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCategoryActionPerformed(evt);
            }
        });

        btnEditCategory.setText("Edit ");
        btnEditCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(categoryTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addGap(12, 12, 12)
                                .addComponent(categoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(descriptionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(categoryDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnAddCategory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditCategory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteCategory)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categoryTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(categoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionLabel)
                    .addComponent(categoryDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCategory)
                    .addComponent(btnDeleteCategory)
                    .addComponent(btnEditCategory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        if (!validateFields())
            return;
        
        String target = categoryName.getText();
        entity.Category ca = categories.stream().filter(c -> c.getName().equalsIgnoreCase(target)).findFirst().orElse(null);
        if (ca != null) {
            JOptionPane.showMessageDialog(this, "Category with name '" + target + "' already exist");
            return;
        }

        int rowsAffected = categoryController.createCategory(target, categoryDescription.getText());

        if (rowsAffected == 0) {
            JOptionPane.showMessageDialog(this, "Ooops... Failed", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Successfully add category");
        reload();
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void btnDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCategoryActionPerformed
        int row = categoryTable.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(this, "No row is selected! Please select one row", "Select row",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this category?",
                "Delete Category", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        String targetName = categoryTable.getValueAt(row, 1).toString();
        int id = categories.stream().filter(p -> targetName.equals(p.getName())).map(entity.Category::getId).findFirst().orElse(-1);
        
        int rowsAffected = categoryController.deleteCategory(id);

        if (rowsAffected == 0) {
            JOptionPane.showMessageDialog(this, "Ooops... Failed", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) categoryTable.getModel();
        model.removeRow(row);
        JOptionPane.showMessageDialog(this, "Successfully delete category");
        reload();
    }//GEN-LAST:event_btnDeleteCategoryActionPerformed

    private void btnEditCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCategoryActionPerformed
        if (btnEditCategory.isSelected()) {
            int row = categoryTable.getSelectedRow();

            if (row < 0) {
                JOptionPane.showMessageDialog(this, "No row is selected! Please select one row", "Select row",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String targetName = categoryTable.getValueAt(row, 1).toString();
            int id = categories.stream().filter(p -> targetName.equals(p.getName())).map(entity.Category::getId).findFirst().orElse(-1);
            modifiedCategoryId = id;
            
            entity.Category c = categoryController.getCategoryById(id);

            categoryName.setText(c.getName());
            categoryDescription.setText(c.getDescription());

            btnEditCategory.setText("Update");
            categoryTable.clearSelection();
        } else {
            if (!validateFields()) return;
            
            String target = categoryName.getText();
            entity.Category ca = categories.stream().filter(c -> c.getName().equalsIgnoreCase(target) && c.getId() != modifiedCategoryId).findFirst().orElse(null);
            if (ca != null) {
                JOptionPane.showMessageDialog(this, "Category with name '" + target + "' already exist");
                return;
            }

            int rowsAffected = categoryController.updateCategory(categoryName.getText(), categoryDescription.getText(), modifiedCategoryId);

            if (rowsAffected == 0) {
                JOptionPane.showMessageDialog(this, "Ooops... Failed", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            JOptionPane.showMessageDialog(this, "Successfully update category");
            reload();
        }
    }//GEN-LAST:event_btnEditCategoryActionPerformed

    public void reload() {
        DefaultTableModel model = (DefaultTableModel) categoryTable.getModel();

        model.setRowCount(0);

        int rowNum = 1;
        List<entity.Category> res = categoryController.getAllCategories();
        for (entity.Category c : res) {
            model.addRow(new Object[] { rowNum++, c.getName(), c.getDescription() });
            categories.add(c);
        }

        btnEditCategory.setSelected(false);
        categoryName.setText("");
        categoryDescription.setText("");
        btnEditCategory.setText("Edit");
        modifiedCategoryId = -1;
        categoryTable.clearSelection();
    }

    private boolean validateFields() {
        if (categoryName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Category name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnDeleteCategory;
    private javax.swing.JToggleButton btnEditCategory;
    private javax.swing.JTextField categoryDescription;
    private javax.swing.JTextField categoryName;
    private javax.swing.JTable categoryTable;
    private javax.swing.JLabel categoryTitle;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}
