/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.CategoryDAO;
import DAO.OrderDAO;
import DAO.OrderItemDAO;
import DAO.ProductDAO;
import Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
/**
 *Cart Interface which displays the items in the cart.
 *
 */
public class CartGUI extends javax.swing.JFrame {

    /**
     * Creates new form ItemGUi
     */
    public CartGUI(List<Product> p,Cart c) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        cart = c;
        products = p;
        loadItemsTable();
        setTotalBillLabel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        confirmOrderButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        quantityField = new javax.swing.JTextField();
        javax.swing.JLabel quantiyLabel4 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearCartButton = new javax.swing.JButton();
        totalPriceLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(237, 255, 244));

        jPanel2.setBackground(new java.awt.Color(72, 250, 141));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer's Cart");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        backButton.setBackground(new java.awt.Color(234, 236, 234));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        confirmOrderButton.setBackground(new java.awt.Color(234, 236, 234));
        confirmOrderButton.setForeground(new java.awt.Color(0, 204, 0));
        confirmOrderButton.setText(" Confirm Order");
        confirmOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmOrderButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(backButton)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                                .addGap(46, 46, 46)
                                .addComponent(confirmOrderButton)
                                .addGap(83, 83, 83))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(confirmOrderButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton)
                                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(237, 255, 244));

        quantityField.setBackground(new java.awt.Color(234, 236, 234));
        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });

        quantiyLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quantiyLabel4.setForeground(new java.awt.Color(255, 102, 102));
        quantiyLabel4.setText("Enter Quantity to update");

        updateButton.setBackground(new java.awt.Color(234, 236, 234));
        updateButton.setForeground(new java.awt.Color(0, 204, 0));
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(234, 236, 234));
        deleteButton.setForeground(new java.awt.Color(245, 16, 36));
        deleteButton.setText("Delete");
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        clearCartButton.setBackground(new java.awt.Color(234, 236, 234));
        clearCartButton.setForeground(new java.awt.Color(245, 16, 36));
        clearCartButton.setText("Clear Cart");
        clearCartButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clearCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearCartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(quantiyLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, updateButton});

        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(clearCartButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(quantiyLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(updateButton)
                                                .addComponent(deleteButton)))
                                .addContainerGap())
        );

        totalPriceLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalPriceLabel.setForeground(new java.awt.Color(255, 102, 102));
        totalPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalPriceLabel.setText("Total Bill Price : 0.0");

        jPanel4.setBackground(new java.awt.Color(237, 255, 244));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(255, 102, 102))); // NOI18N

        itemsTable.setBackground(new java.awt.Color(234, 236, 234));
        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Name", "Per Unit Price", "Quantity", "Total Price"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(itemsTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane1)
                                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(totalPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(87, 87, 87))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(87, 87, 87)))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
                                .addComponent(totalPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(114, 114, 114)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(114, 114, 114)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(cart.getItems().isEmpty())
        {
            new AssistantGUI().setVisible(true);

        }
        else
        {
            new AssistantGUI(products,cart).setVisible(true);
        }
        this.dispose();
    }

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int selectedRow = itemsTable.getSelectedRow();
        if(selectedRow == -1)
        {
            JOptionPane.showMessageDialog(this,"Select Item from table to update","Item Not Selected",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            if(quantityField.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Enter Quantity to update","Empty Quantity Field",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int newQuantity = 0;
            try
            {
                newQuantity = Integer.parseInt(quantityField.getText());
            }
            catch (NumberFormatException n)
            {
                JOptionPane.showMessageDialog(this,"Too much Quantity Entered","Invalid Quantity",JOptionPane.INFORMATION_MESSAGE);
                quantityField.setText("");
                return;
            }

            if(newQuantity==0)
            {
                JOptionPane.showMessageDialog(this,"Please Enter Value Greater than 0","Quantity To be Updated",JOptionPane.INFORMATION_MESSAGE);
                quantityField.setText("");
                return;
            }
            int id = (int)itemsTable.getValueAt(selectedRow,0);
            int RemainingQuantity = getProductQuantity(id);
            int totalQuantity = cart.getItem(id).getQuantityOrdered() + RemainingQuantity;
            if(newQuantity > totalQuantity)
            {
                JOptionPane.showMessageDialog(this,"Entered Quantity is more than Total Available quantity.\nTotal Available Quantity of " +cart.getItem(id).getProduct().getName()+" is "+ totalQuantity,"Quantity Exceeds",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            cart.getItem(id).setQuantityOrdered(newQuantity);
            int newRemainingQuantity = totalQuantity - newQuantity;
            setProductQuantity(newRemainingQuantity,id);
            loadItemsTable();
            setTotalBillLabel();
            quantityField.setText("");
            JOptionPane.showMessageDialog(this,"Quantity of "+ cart.getItem(id).getProduct().getName() + " Updated ","Quantity Updated",JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int selectedRow = itemsTable.getSelectedRow();
        if(selectedRow == -1)
        {
            JOptionPane.showMessageDialog(this,"Select item from table to delete","Item Not Selected",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {

            int id = (int)itemsTable.getValueAt(selectedRow,0);
            Item item = cart.getItem(id);
            int totalQuantity = item.getQuantityOrdered();
            updateProductQuantity(totalQuantity,id);
            cart.removeItem(item);
            loadItemsTable();
            setTotalBillLabel();
        }
    }

    private void clearCartButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cart.clear();
        loadItemsTable();
        setTotalBillLabel();
    }

    private void confirmOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(cart.getItems().isEmpty())
        {
            ImageIcon icon = new ImageIcon("empty-cart.png");
            int preferredWidth = 30;
            int preferredHeight = 30;
            Image scaledImage = icon.getImage().getScaledInstance(preferredWidth, preferredHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JOptionPane.showMessageDialog(this,"No Items in the Cart","Empty Cart",JOptionPane.INFORMATION_MESSAGE,scaledIcon);
            return;
        }
        String name = JOptionPane.showInputDialog(this,"Enter Customer Name");
        if(name == null)
        {
            return;
        }
        if(name.isEmpty())
        {
            name = "UnKnown";
        }
        String price = JOptionPane.showInputDialog(this,"Enter amount paid By customer");
        int paidPrice = 0;
        if(price == null)
        {
            return;
        }
        while (!validatePrice(price))
        {
            price = JOptionPane.showInputDialog(this,"Enter Numbers only for amount given by customer.\nOr Customer's amount must be greater than or equal to "+(int)cart.getTotal());
        }
        paidPrice = Integer.parseInt(price);
        for(Item i : cart.getItems() )
        {
            int id = i.getProduct().getId();
            int tp = getTotalPacks(id);
            int tq = getTotalQuantity(id);
            ProductDAO.updateProductQuantity(tp,tq,id);
        }
        ProductDAO.deleteSoldProducts();
        Order order = cart.generateOrder(name);
        OrderDAO.addOrder(order);
        new billGUI(order,paidPrice).setVisible(true);
        this.dispose();
        OrderItemDAO.addOrderItems(order);

    }
    public void loadItemsTable() {
        DefaultTableModel model = (DefaultTableModel) itemsTable.getModel();
        model.setRowCount(0);
        for (Item i : cart.getItems()) {
            Object[] row = {
                    i.getProduct().getId(),
                    i.getProduct().getName(),
                    i.getProduct().getPrice(),
                    i.getQuantityOrdered(),
                    i.getTotal()};
            model.addRow(row);
        }
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.LEFT);
        for(int i = 0; i < itemsTable.getColumnCount();i++)
        {
            itemsTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }
    private boolean validatePrice(String p)
    {
        int price = 0;
        try {
            price = Integer.parseInt(p);
        }
        catch (NumberFormatException n)
        {
            return false;
        }

        return price >= (int) cart.getTotal();

    }
    private void setTotalBillLabel()
    {
        double total = cart.getTotal();
        totalPriceLabel.setText("Total Bill Price : "+ (int)total);
    }
    private void updateProductQuantity(int quantity ,int id)
    {
        for(Product p : products)
        {
            if(p.getId() == id)
            {
                p.setTotalQuantity(p.getTotalQuantity()+quantity);
                p.setTotalPacks(p.getTotalQuantity()/p.getQuantityInPack());
                return;
            }
        }
    }
    private void setProductQuantity(int quantity ,int id)
    {
        for(Product p : products)
        {
            if(p.getId() == id)
            {
                p.setTotalQuantity(quantity);
                p.setTotalPacks(p.getTotalQuantity()/p.getQuantityInPack());
                return;
            }
        }
    }
    private int getProductQuantity(int id)
    {
        for(Product p : products)
        {
            if(p.getId() == id)
            {
                return p.getTotalQuantity();
            }
        }
        return 0;
    }

    Cart cart;
    List<Product> products;
    // Variables declaration - do not modify
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearCartButton;
    private javax.swing.JButton confirmOrderButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTable itemsTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField quantityField;
    private javax.swing.JLabel totalPriceLabel;
    private javax.swing.JButton updateButton;
    private int getTotalQuantity(int id)
    {
        for(Product p : products)
        {
            if(p.getId() == id)
            {
                return p.getTotalQuantity();
            }
        }
        return 0;
    }
    private int getTotalPacks(int id)
    {
        for(Product p : products)
        {
            if(p.getId() == id)
            {
                return p.getTotalPacks();
            }
        }
        return 0;
    }

    // End of variables declaration
}



