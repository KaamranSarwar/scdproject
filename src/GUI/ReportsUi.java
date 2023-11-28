package GUI;


import DAO.CategoryDAO;
import DAO.ProductDAO;
import Model.Category;
import Model.Product;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReportsUi extends javax.swing.JFrame {


    /**
     * Creates new form ReportsUi
     */
    List<Product> products=new ArrayList<>();
    public ReportsUi() {
        initComponents();
        products= ProductDAO.getAllProducts();
        populateProductTable(products);
        this.setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Inventorypanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Logoutforinventory = new java.awt.Button();
        searchtextfield = new javax.swing.JTextField();
        searchbtn = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        producttable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        categorytree = new javax.swing.JTree();
        Salespanel = new javax.swing.JPanel();
        logoutforsales = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enter name of product to Search");

        Logoutforinventory.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Logoutforinventory.setLabel("Log Out");

        searchbtn.setBackground(new java.awt.Color(51, 102, 255));
        searchbtn.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        searchbtn.setForeground(new java.awt.Color(255, 255, 255));
        searchbtn.setLabel("Search");
        searchtextfield.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                searchtextfieldActionPerformed(e);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Select Category");

        producttable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null}
                },
                new String [] {
                        "Id", "Name", "Description", "Total Packs", "Quantity per pack", "Total Quantity", "Price", "Category Name", "Expiry Date"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        jScrollPane1.setViewportView(producttable);

        categorytree.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        categorytree.setModel(getCategoryTree());
        jScrollPane2.setViewportView(categorytree);
        categorytree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                listnerfortree();
            }
        });
        labelforexpireproducts=new JLabel();
        labelforexpireproducts.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        labelforexpireproducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelforexpireproducts.setText("jLabel3");

        javax.swing.GroupLayout InventorypanelLayout = new javax.swing.GroupLayout(Inventorypanel);
        Inventorypanel.setLayout(InventorypanelLayout);
        InventorypanelLayout.setHorizontalGroup(
                InventorypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InventorypanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(InventorypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                        .addGroup(InventorypanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchtextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addGap(392, 392, 392))
                        .addGroup(InventorypanelLayout.createSequentialGroup()
                                .addGroup(InventorypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(InventorypanelLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(Logoutforinventory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(InventorypanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(labelforexpireproducts, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InventorypanelLayout.setVerticalGroup(
                InventorypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(InventorypanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(Logoutforinventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(InventorypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(searchtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(2, 2, 2)
                                .addGroup(InventorypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(InventorypanelLayout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelforexpireproducts, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Inventory Reports", Inventorypanel);

        logoutforsales.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        logoutforsales.setLabel("Log Out");

        javax.swing.GroupLayout SalespanelLayout = new javax.swing.GroupLayout(Salespanel);
        Salespanel.setLayout(SalespanelLayout);
        SalespanelLayout.setHorizontalGroup(
                SalespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SalespanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(logoutforsales, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(803, Short.MAX_VALUE))
        );
        SalespanelLayout.setVerticalGroup(
                SalespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SalespanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(logoutforsales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(581, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sales Report", Salespanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
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

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        TreePath selectedPath = categorytree.getSelectionPath();
        int parentID = 0;
        String selectedText=null;
        if (selectedPath != null) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath.getLastPathComponent();
            selectedText= selectedNode.getUserObject().toString();
            parentID = CategoryDAO.getID(selectedText);
        }
        if(searchtextfield.getText().isEmpty()&&selectedPath==null){
            JOptionPane.showMessageDialog(this,"Enter product name","Error",JOptionPane.ERROR_MESSAGE);
        }
        if(selectedPath==null&&searchtextfield.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Select the category","Error",JOptionPane.ERROR_MESSAGE);
        }
        if (!searchtextfield.getText().isEmpty() && selectedPath != null) {
            String name = searchtextfield.getText();
            List<Product> productsByCategory = ProductDAO.getProductsByCategoryAndSubcategories(selectedText);
            List<Product> productsByName = ProductDAO.getProductsByName(name);

            Set<Integer> categoryIds = new HashSet<>();
            List<Product> combinedList = new ArrayList<>();

            // Store category IDs from the selected category
            for (Product product : productsByCategory) {
                categoryIds.add(product.getCategoryID());
            }

            // Add products from the search results that match the selected category
            for (Product product : productsByName) {
                if (categoryIds.contains(product.getCategoryID())) {
                    combinedList.add(product);
                }
            }

            populateProductTable(combinedList);
        }



        else if(!searchtextfield.getText().isEmpty()){
            String name=searchtextfield.getText();
            List<Product> p=ProductDAO.getProductsByCategoryAndSubcategories(name);
            populateProductTable(p);
        }
        else if(selectedPath!=null){
            List<Product> p=ProductDAO.getProductsByCategoryAndSubcategories(selectedText);
            populateProductTable(p);
        }
    }

    private void searchtextfieldActionPerformed(KeyEvent e) {
        // TODO add your handling code here:
        TreePath selectedPath = categorytree.getSelectionPath();
        int parentID = 0;
        String selectedText=null;
        if (selectedPath != null) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath.getLastPathComponent();
            selectedText= selectedNode.getUserObject().toString();
            parentID = CategoryDAO.getID(selectedText);
        }
        if(selectedText.equals("Categories")&&!searchtextfield.getText().isEmpty()){
            String name = searchtextfield.getText();
            List<Product> p=ProductDAO.getProductsByName(name);
            populateProductTable(p);
        }
        else if (!searchtextfield.getText().isEmpty() && selectedPath != null) {
            String name = searchtextfield.getText();
            List<Product> productsByCategory = ProductDAO.getProductsByCategoryAndSubcategories(selectedText);
            List<Product> productsByName = ProductDAO.getProductsByName(name);
            Set<Integer> categoryIds = new HashSet<>();
            List<Product> combinedList = new ArrayList<>();

            // Store category IDs from the selected category
            for (Product product : productsByCategory) {
                categoryIds.add(product.getCategoryID());
            }

            // Add products from the search results that match the selected category
            for (Product product : productsByName) {
                if (categoryIds.contains(product.getCategoryID())) {
                    combinedList.add(product);
                }
            }

            populateProductTable(combinedList);
        } else if (!searchtextfield.getText().isEmpty()) {
            String name = searchtextfield.getText();
            List<Product> p;

            if (selectedText.equals("Categories")) {
                p = ProductDAO.getProductsByName(name);
            } else {
                p = ProductDAO.getProductsByCategoryAndSubcategories(selectedText);
            }

            populateProductTable(p);
        } else if (selectedPath != null) {
            List<Product> p = ProductDAO.getProductsByCategoryAndSubcategories(selectedText);
            populateProductTable(p);
        }
    }
    private void listnerfortree(){
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) categorytree.getLastSelectedPathComponent();

        if (selectedNode != null) {
            Object selectedObject = selectedNode.getUserObject();
            // Assuming your category nodes have some identifier for categories
                int categoryId =CategoryDAO.getID((String) selectedObject);
                List<Product> products = ProductDAO.getProductsByCategoryAndSubcategories(selectedObject.toString());
                populateProductTable(products);
        }
        if(selectedNode.getUserObject().equals("Categories")&&selectedNode!=null){
            List<Product> products1=ProductDAO.getAllProducts();
            populateProductTable(products1);
        }
    }
    public void populateProductTable(List<Product> products) {
        DefaultTableModel model = (DefaultTableModel) producttable.getModel();
        model.setRowCount(0);

        DefaultTableCellRenderer defaultRenderer = new DefaultTableCellRenderer();
        defaultRenderer.setHorizontalAlignment(JLabel.LEFT);

        producttable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Check if the expiry date is within 15 days
                Object expDateValue = table.getValueAt(row, 8); // Assuming column index 8 is for the expiry date
                if (expDateValue instanceof Date) {
                    Date expDate = (Date) expDateValue;
                    long millisUntilExpiry = expDate.getTime() - new Date().getTime();
                    long daysUntilExpiry = TimeUnit.DAYS.convert(millisUntilExpiry, TimeUnit.MILLISECONDS);

                    if (daysUntilExpiry <= 15 && daysUntilExpiry >= 0) {
                        c.setBackground(Color.RED);
                        c.setForeground(Color.WHITE);
                    } else {
                        // Set default background and foreground colors for other rows
                        c.setBackground(table.getBackground());
                        c.setForeground(table.getForeground());
                    }
                }
                return c;
            }
        });

        for (Product product : products) {
            Object[] row = {
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getTotalPacks(),
                    product.getQuantityInPack(),
                    product.getTotalQuantity(),
                    product.getPrice(),
                    CategoryDAO.getName(product.getCategoryID()),
                    product.getExpDate()
            };

            model.addRow(row);
        }

        producttable.getColumnModel().getColumn(8).setCellRenderer(defaultRenderer); // Set default renderer for the expiry date column
        countRedRows(producttable);
    }
    public static DefaultTreeModel getCategoryTree() {
        List<Category> allCategories = CategoryDAO.getAllCategory();
        DefaultMutableTreeNode root = buildCategoryTree(allCategories);
        return new DefaultTreeModel(root);
    }

    public static DefaultMutableTreeNode buildCategoryTree(List<Category> categories) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categories"); // You can set any root name you prefer
        Map<Integer, DefaultMutableTreeNode> parentNodeMap = new HashMap<>();
        for (Category category : categories) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(category.getName());
            parentNodeMap.put(category.getId(), node);
            if (category.getParentID() > 0) {
                DefaultMutableTreeNode parentNode = parentNodeMap.get(category.getParentID());
                parentNode.add(node);
            } else {
                root.add(node);
            }
        }
        return root;
    }
    public void countRedRows(JTable table) {
        int redRowCount = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            Object expDateValue = table.getValueAt(i, 8); // Assuming column index 8 is for the expiry date
            if (expDateValue instanceof Date) {
                Date expDate = (Date) expDateValue;
                long millisUntilExpiry = expDate.getTime() - new Date().getTime();
                long daysUntilExpiry = TimeUnit.DAYS.convert(millisUntilExpiry, TimeUnit.MILLISECONDS);

                if (daysUntilExpiry <= 15 && daysUntilExpiry >= 0) {
                    redRowCount++;
                }
            }
        }
        labelforexpireproducts.setText("The number of products \n"+" near to expiry are: "+redRowCount);
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
            java.util.logging.Logger.getLogger(ReportsUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportsUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportsUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportsUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportsUi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel Inventorypanel;
    private java.awt.Button Logoutforinventory;
    private javax.swing.JPanel Salespanel;
    private javax.swing.JTree categorytree;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Button logoutforsales;
    private javax.swing.JTable producttable;
    private java.awt.Button searchbtn;
    private javax.swing.JTextField searchtextfield;
    int countOfExpiredProducts;
    private javax.swing.JLabel labelforexpireproducts;
    // End of variables declaration
}

