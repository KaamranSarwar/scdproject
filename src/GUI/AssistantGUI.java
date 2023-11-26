/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import DAO.ProductDAO;
import Model.Item;
import Model.Product;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaamr
 */
public class AssistantGUI extends javax.swing.JFrame {

    /**
     * Creates new form AssistantGUI
     */
    public AssistantGUI() {
        initComponents();

        items = new ArrayList<>();
        products = ProductDAO.getAllProducts();
        setCartLabel();
        populateProductTable(products);
        setLocationRelativeTo(null);

    }
    public AssistantGUI(List<Product> p,List<Item> i) {
        initComponents();
        items = i;
        products = p;
        setCartLabel();
        populateProductTable(products);
        setLocationRelativeTo(null);

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cartButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        quantityRbutton = new javax.swing.JRadioButton();
        packetRadioButton4 = new javax.swing.JRadioButton();
        quantiyLabel4 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        quantityField = new javax.swing.JTextField();

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(quantityRbutton);
        buttonGroup.add(packetRadioButton4);
        quantityRbutton.setSelected(true);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Products");

        cartButton.setText("CART");
        cartButton.setMaximumSize(new java.awt.Dimension(85, 23));
        cartButton.setMinimumSize(new java.awt.Dimension(85, 23));
        cartButton.setPreferredSize(new java.awt.Dimension(85, 23));

        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(logOutButton)
                                .addGap(172, 172, 172)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(145, 145, 145)
                                .addComponent(cartButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cartButton, logOutButton});

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cartButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(logOutButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cartButton, logOutButton});

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Search Product");

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        productTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Name", "Description", "Total Packs", "Quantity Per Pack", "Total Quantity", "Price"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );

        quantityRbutton.setText("Total Quantity");
        quantityRbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityRbuttonquantityRbuttonActionPerformed(evt);
            }
        });

        packetRadioButton4.setText("Packet");
        packetRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packetRadioButton4packetRadioButtonActionPerformed(evt);
            }
        });

        quantiyLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        quantiyLabel4.setText("Enter Quantity");

        addButton.setText("ADD ITEM");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(quantiyLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(quantityRbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(packetRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                                .addComponent(addButton)
                                .addGap(16, 16, 16))
        );
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(quantiyLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(3, 3, 3))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(quantityRbutton)
                                                        .addComponent(packetRadioButton4)
                                                        .addComponent(addButton))))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setupQuantityField();

        pack();
    }// </editor-fold>

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        showItems();
    }

    private void quantityRbuttonquantityRbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        quantiyLabel4.setText("Enter Quantity");
        quantityField.setText("");
    }

    private void packetRadioButton4packetRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        quantiyLabel4.setText("Enter Packets");
        quantityField.setText("");
    }

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        String searchQuery = searchField.getText().trim();
        List<Product> products = ProductDAO.getProductsByName(searchQuery);
        populateProductTable(products);

    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int selectedRow = productTable.getSelectedRow();
        if(selectedRow == -1)
        {
            JOptionPane.showMessageDialog(this,"Select product from table First","Product Not Selected",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(quantityField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Enter Quantity first","Empty Quantity Field",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int quantity = Integer.parseInt(quantityField.getText());

        if(quantity==0)
        {
            JOptionPane.showMessageDialog(this,"Please Enter Value Greater than 0","Quantity To buy",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        int Id =(int)model.getValueAt(selectedRow,0);
        int TotalPacks =(int)model.getValueAt(selectedRow,3);
        int TotalQuantity = (int)model.getValueAt(selectedRow,5);
        int QinP = (int)model.getValueAt(selectedRow,4);
        int totalOrderedQuantity=0;
        if(quantityRbutton.isSelected())
        {
            if(quantity > TotalQuantity)
            {
                JOptionPane.showMessageDialog(this,"You Entered Quantity More than that We have","Quantity Exceeds",JOptionPane.ERROR_MESSAGE);
                return;
            }
            totalOrderedQuantity = quantity;
            int remainingQuantity = TotalQuantity-totalOrderedQuantity;
            model.setValueAt(remainingQuantity,selectedRow,5); // updating quantity in table
            int remainingPacks = (TotalQuantity-totalOrderedQuantity)/QinP;
            model.setValueAt(remainingPacks,selectedRow,3);// updating number of packs
            updateLocalProducts(Id,remainingQuantity,remainingPacks);
        }
        else
        {
            if(quantity > TotalPacks)
            {
                JOptionPane.showMessageDialog(this,"You Entered Packs More than that We have","Number of PACK Exceeds",JOptionPane.ERROR_MESSAGE);
                return;
            }
            totalOrderedQuantity = quantity * QinP;
            int remainingQuantity = TotalQuantity-totalOrderedQuantity;
            int remainingPacks = TotalPacks-quantity;
            model.setValueAt(remainingPacks,selectedRow,3);
            model.setValueAt(remainingQuantity,selectedRow,5);
            updateLocalProducts(Id,remainingQuantity,remainingPacks);
        }
        String name = (String) model.getValueAt(selectedRow,1);
        double price = (double) model.getValueAt(selectedRow,6);
        Product p = new Product(Id,name,price);
        Item item = new Item(p,totalOrderedQuantity);
        if(checkItems(Id))
        {
            updateItems(item);

        }
        else
        {
            items.add(item);
        }
        setCartLabel();
        quantityField.setText("");
        productTable.clearSelection();
        JOptionPane.showMessageDialog(this,"Item added to cart","Item Added",JOptionPane.INFORMATION_MESSAGE);
    }

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void setupQuantityField() {//function to allow only integer values user cannot add alphabets or special characters
        PlainDocument doc = (PlainDocument) quantityField.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d*")) { // Allows only digits
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
    private boolean checkItems(int Id) {
        for (Item i : items)
        {
            if(i.getProduct().getId() == Id)
            {
                return true;
            }

        }
        return false;
    }
    private void showItems()
    {
        for(Item i : items)
        {
            Product p = i.getProduct();
            System.out.println("ID : " +p.getId());
            System.out.println("Name : " +p.getName());
            System.out.println("Price : " +p.getPrice());
            System.out.println("Total Quantity Ordered : " +i.getQuantityOrdered());
            System.out.println("Total price : " +i.getTotal());
        }
    }


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
            java.util.logging.Logger.getLogger(AssistantGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssistantGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssistantGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssistantGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssistantGUI().setVisible(true);
            }
        });
    }
    public void populateProductTable(List<Product> products) {
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        model.setRowCount(0);

        for (Product product : products) {
            Object[] row = {
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getTotalPacks(),
                    product.getQuantityInPack(),
                    product.getTotalQuantity(),
                    product.getPrice()};
            model.addRow(row);
        }
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.LEFT);
        for(int i = 0; i < productTable.getColumnCount();i++)
        {
            productTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }
    private void updateLocalProducts(int id, int quantity,int packs)
    {
        for(Product p : products)
        {
            if(p.getId() == id)
            {
                p.setTotalQuantity(quantity);
                p.setTotalPacks(packs);
                return;
            }
        }
    }

    private void setCartLabel()
    {
        int s = items.size();
        if(s == 0)
        {
            cartButton.setText("CART");

        }
        else
        {
            cartButton.setText("CART " + s);
        }
    }

    private void updateItems(Item item)
    {
        for(Item i : items)
        {
            if(i.getProduct().getId() == item.getProduct().getId())
            {
                i.setQuantityOrdered(i.getQuantityOrdered()+item.getQuantityOrdered());
                return;
            }
        }
    }


    // Variables declaration - do not modify
    private List<Product> products;
    private List<Item> items;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cartButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JRadioButton packetRadioButton4;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField quantityField;
    private javax.swing.JRadioButton quantityRbutton;
    private javax.swing.JLabel quantiyLabel4;
    private javax.swing.JTextField searchField;
    // End of variables declaration
}
