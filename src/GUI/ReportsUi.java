package GUI;


import DAO.CategoryDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import Model.Category;
import Model.Order;
import Model.Product;
import Model.User;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReportsUi extends javax.swing.JFrame {


    /**
     * Creates new form ReportsUi
     */
    List<Product> products=new ArrayList<>();
    /**
     * Constructs a new ReportsUi interface for the given User.
     *
     * @param u The User object associated with the interface.
     *
     * Initializes the ReportsUi interface by loading all products from the database
     * using the ProductDAO.getAllProducts() method and populates the product table
     * within the interface using the retrieved product data.
     *
     * This interface is positioned at the center of the screen (null location),
     * and its window state is set to maximize upon creation.
     */
    public ReportsUi(User u) {
        user = u;
        initComponents();
        products= ProductDAO.getAllProducts();
        populateProductTable(products);
        this.setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    /**
     * Configures a provided JDateChooser instance to ensure accurate date entry and prevent manual editing of dates.
     * The method disables manual editing of the date, sets a specific date format, and allows selection within a date range.
     *
     * @param dateChooser The JDateChooser component to be configured for date input.
     */
    private void setupDateChooser(JDateChooser dateChooser) {//function to stop entering wrong inputs in datechoser
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
        editor.setEditable(false); // Disallow manual editing
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        editor.setDateFormatString(String.valueOf(sdf)); // Set date format
        dateChooser.setSelectableDateRange(null, null); // Optional: Allow all dates in the calendar
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Inventorypanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        backbtnforinventory = new java.awt.Button();
        searchtextfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        producttable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        categorytree = new javax.swing.JTree();
        Salespanel = new javax.swing.JPanel();
        Backbtn = new java.awt.Button();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Dailyradiobtn = new javax.swing.JRadioButton();
        weeklyradiobtn = new javax.swing.JRadioButton();
        monthlyradiobtn = new javax.swing.JRadioButton();
        previousdate = new JDateChooser();
        nextdate = new JDateChooser();
        setupDateChooser(previousdate);
        setupDateChooser(nextdate);
        Calendar currentDate = Calendar.getInstance();
        previousdate.setMaxSelectableDate(currentDate.getTime());
        nextdate.setMaxSelectableDate(currentDate.getTime());
        generatereportbtn = new java.awt.Button();
        generatepdfbtn = new java.awt.Button();
        profitlabel = new javax.swing.JLabel();
        buttonGroup=new ButtonGroup();
        buttonGroup.add(Dailyradiobtn);
        buttonGroup.add(weeklyradiobtn);
        buttonGroup.add(monthlyradiobtn);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        generatepdfbtn.setVisible(false);
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 21)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enter name of product to Search");
        Inventorypanel.setBackground(new java.awt.Color(237, 255, 244));
        Salespanel.setBackground(new java.awt.Color(237, 255, 244));;
        jScrollPane1.setForeground(new java.awt.Color(255, 102, 102));
        backbtnforinventory.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        backbtnforinventory.setLabel("Back");
        backbtnforinventory.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        backbtnforinventory.setForeground(new java.awt.Color(255, 102, 102));
        backbtnforinventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backbtnforinventoryActionPerformed(e);
            }
        });
        Backbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BackbtnActionPerformed(e);
            }
        });
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
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
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
        weeklyradiobtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weeklyradiobtnActionPerform(e);
            }
        });
        labelforexpireproducts=new JLabel();
        labelforexpireproducts.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        labelforexpireproducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelforexpireproducts.setForeground(new java.awt.Color(255, 102, 102));
        labelforexpireproducts.setText("jLabel3");

        javax.swing.GroupLayout InventorypanelLayout = new javax.swing.GroupLayout(Inventorypanel);
        Inventorypanel.setLayout(InventorypanelLayout);
        InventorypanelLayout.setHorizontalGroup(
                InventorypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InventorypanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(InventorypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                        .addGroup(InventorypanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchtextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addGap(392, 392, 392))
                        .addGroup(InventorypanelLayout.createSequentialGroup()
                                .addGroup(InventorypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(InventorypanelLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(backbtnforinventory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(InventorypanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(labelforexpireproducts, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InventorypanelLayout.setVerticalGroup(
                InventorypanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(InventorypanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(backbtnforinventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        Backbtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Backbtn.setLabel("Back");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Id", "Price", "Customer", "Date"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        Dailyradiobtn.setText("Daily");
        Dailyradiobtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Dailyradiobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DailyradiobtnActionPerformed(evt);
            }
        });

        weeklyradiobtn.setText("Weekly");

        monthlyradiobtn.setText("Monthly");
        monthlyradiobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyradiobtnActionPerformed(evt);
            }
        });

        generatereportbtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        generatereportbtn.setForeground(new java.awt.Color(51, 153, 0));
        generatereportbtn.setLabel("Generate Report");
        generatereportbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatereportbtnActionPerformed(e);
            }
        });

        generatepdfbtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        generatepdfbtn.setLabel("Generate Pdf");


        profitlabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        profitlabel.setForeground(new java.awt.Color(255, 102, 102));
        profitlabel.setText("Profit label");

        javax.swing.GroupLayout SalespanelLayout = new javax.swing.GroupLayout(Salespanel);
        Salespanel.setLayout(SalespanelLayout);
        SalespanelLayout.setHorizontalGroup(
                SalespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalespanelLayout.createSequentialGroup()
                                .addGroup(SalespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(SalespanelLayout.createSequentialGroup()
                                                .addGap(117, 117, 117)
                                                .addComponent(Dailyradiobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(weeklyradiobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(monthlyradiobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(previousdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(29, 29, 29)
                                                .addComponent(nextdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(54, 54, 54)
                                                .addComponent(generatereportbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SalespanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(SalespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(profitlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Backbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SalespanelLayout.createSequentialGroup()
                                                .addGap(219, 219, 219)
                                                .addComponent(generatepdfbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(83, 83, 83))
        );

        SalespanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Dailyradiobtn, monthlyradiobtn, weeklyradiobtn});

        SalespanelLayout.setVerticalGroup(
                SalespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SalespanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(SalespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(SalespanelLayout.createSequentialGroup()
                                                .addComponent(Backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addGroup(SalespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(SalespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(Dailyradiobtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(weeklyradiobtn)
                                                                .addComponent(monthlyradiobtn))
                                                        .addComponent(nextdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(previousdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(SalespanelLayout.createSequentialGroup()
                                                .addComponent(generatereportbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)))
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(profitlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(generatepdfbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
        );

        SalespanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Dailyradiobtn, monthlyradiobtn, weeklyradiobtn});

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
    /**
     * Handles the action performed when the "Back" button in the inventory interface is clicked.
     * Hides the current window and displays the manager's home interface.
     *
     * @param e The ActionEvent triggered when the "Back" button is clicked.
     */
    private void backbtnforinventoryActionPerformed(ActionEvent e) {
        this.setVisible(false);
        new managerhome(user).setVisible(true);
    }
    /**
     * Handles the action performed when the "Generate Report" button is clicked in the inventory interface.
     * Processes the selected radio button choice (Daily, Weekly, Monthly) and retrieves relevant orders and sales data
     * based on the specified date range, displaying the data in the sales table.
     * Displays error messages if the date range or selections are invalid or incomplete.
     *
     * @param e The ActionEvent triggered when the "Generate Report" button is clicked.
     */
    private void generatereportbtnActionPerformed(ActionEvent e) {
        if (buttonGroup.getSelection() != null) {
            ButtonModel selectedRadioButton = buttonGroup.getSelection();
            if (selectedRadioButton == Dailyradiobtn.getModel()) {
                // Daily radio button is selected
                Date selectedDate = nextdate.getDate();
                if (selectedDate == null) {
                    JOptionPane.showMessageDialog(this, "Select a date", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Convert java.util.Date to java.sql.Date
                    java.sql.Date sqlSelectedDate = new java.sql.Date(selectedDate.getTime());

                    List<Order> ordersForDate = OrderDAO.getOrdersWithItemsOnDate(sqlSelectedDate);
                    makesalestable(ordersForDate);
                }
            }
            else if (selectedRadioButton == weeklyradiobtn.getModel()) {
                Date prevdate = previousdate.getDate();
                Date nexdate=nextdate.getDate();
                if (prevdate != null && nexdate != null) {
                    long diffInMillies = Math.abs(nexdate.getTime() - prevdate.getTime());
                    long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                     if(diffInDays==6){
                        java.sql.Date sqlstartdate = new java.sql.Date(nexdate.getTime());
                        java.sql.Date sqlenddate = new java.sql.Date(prevdate.getTime());
                        List<Order> ordersList=OrderDAO.getOrdersBetweenDates(sqlstartdate,sqlenddate);
                        makesalestable(ordersList);
                    }
                     else  {
                         JOptionPane.showMessageDialog(this, "The gap between dates should be one week.", "Error", JOptionPane.ERROR_MESSAGE);
                     }
                } else {
                    JOptionPane.showMessageDialog(this, "Select date", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else if (selectedRadioButton == monthlyradiobtn.getModel()) {
                Date prevdate = previousdate.getDate();
                Date nexdate=nextdate.getDate();
                if (prevdate != null && nexdate != null) {
                    long diffInMillies = Math.abs(nexdate.getTime() - prevdate.getTime());
                    long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                    if(diffInDays==29){
                        java.sql.Date sqlstartdate = new java.sql.Date(nexdate.getTime());
                        java.sql.Date sqlenddate = new java.sql.Date(prevdate.getTime());
                        List<Order> ordersList=OrderDAO.getOrdersBetweenDates(sqlstartdate,sqlenddate);
                        makesalestable(ordersList);
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "The gap between dates should be one Month.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Select date", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            // Handle case when no radio button is selected
            JOptionPane.showMessageDialog(this,"select a Button ","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Handles the action performed when the "Daily" radio button is selected in the sales report interface.
     * Disables the previous date selection.
     * (Currently commented out: retrieves orders with items and displays the sales table.)
     *
     * @param evt The ActionEvent triggered when the "Daily" radio button is selected.
     */
    private void DailyradiobtnActionPerformed(ActionEvent evt) {
        previousdate.setEnabled(false);
        /*List<Order> orders = OrderDAO.getOrdersWithItems();
        makesalestable(orders);*/
    }
    /**
     * Populates the sales table with data obtained from the provided list of orders.
     * Creates a DefaultTableModel to display Order ID, Order Price, Customer Name, and Order Date columns.
     *
     * @param orders The list of Order objects containing sales data to populate the table.
     */
    private void makesalestable(List<Order> orders) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };

        model.addColumn("Order ID");
        model.addColumn("Order Price");
        model.addColumn("Customer Name");
        model.addColumn("Order Date");

        for (Order order : orders) {
            Object[] rowData = {
                    order.getId(),
                    order.getTotal(),
                    order.getCustomerName(),
                    order.getTimestamp()
            };
            model.addRow(rowData);
        }

        jTable1.setModel(model);
        writeInProfitlabel(jTable1);
    }

    private void monthlyradiobtnActionPerformed(ActionEvent evt) {
        previousdate.setEnabled(true);
    }
    private void weeklyradiobtnActionPerform(ActionEvent e) {
        previousdate.setEnabled(true);
    }

    /**
     * if back button is pressed then this fucntion is called it takes to the homepage
     * @param evt
     */
    private void BackbtnActionPerformed(ActionEvent evt) {
        this.dispose();
        new managerhome(user).setVisible(true);
    }

    /**
     * when the typed some text in the textfield then it gets the products with the name typed in the textfield
     * @param e
     */
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
        System.out.println(selectedText);
        if (!searchtextfield.getText().isEmpty()&&selectedPath==null) {
            String name = searchtextfield.getText();
            List<Product> p;
            p = ProductDAO.getProductsByName(name);
            populateProductTable(p);
        }
         if (!searchtextfield.getText().isEmpty() && selectedText != null) {
            System.out.println("main wala   "+selectedText);
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
        else if(selectedText!=null){
            System.out.println(selectedText);
            if(selectedText.equals("Categories")&&!searchtextfield.getText().isEmpty()){
                String name = searchtextfield.getText();
                List<Product> p=ProductDAO.getProductsByName(name);
                populateProductTable(p);
            }
        }
         else if (selectedText!= null) {
            List<Product> p = ProductDAO.getProductsByCategoryAndSubcategories(selectedText);
            populateProductTable(p);
        } else if (searchtextfield.getText().isEmpty()) {
            List<Product> p=ProductDAO.getAllProducts();
            populateProductTable(p);
        }
    }
    /**
     * Handles the event triggered when a node is selected in the category tree.
     * Retrieves the selected node from the tree and performs actions based on the selected node's data:
     * 1. Retrieves the category ID from the database and retrieves products based on categories and subcategories.
     * 2. Populates the product table with the retrieved products.
     * If the selected node is "Categories," retrieves all products and populates the product table.
     *
     * Note: Assumes that category nodes have identifiers and proper handling for "Categories" node selection.
     */
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
    /**
     * Populates the product table with product information, highlighting rows
     * where the expiry date is within 15 days.
     *
     * @param products A list of Product objects containing product information
     */
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
    /**
     * Constructs a DefaultTreeModel representing the category hierarchy.
     * The tree model is built based on the provided list of Category objects.
     *
     * @return A DefaultTreeModel representing the category hierarchy
     */
    public static DefaultTreeModel getCategoryTree() {
        List<Category> allCategories = CategoryDAO.getAllCategory();
        DefaultMutableTreeNode root = buildCategoryTree(allCategories);
        return new DefaultTreeModel(root);
    }
    /**
     * Builds a category tree using the provided list of Category objects.
     *
     * @param categories A list of Category objects to construct the tree
     * @return The root node of the constructed tree
     */
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
    /**
     * Counts the number of rows with expiration dates within 15 days in the specified table.
     * Updates the label displaying the count along with the selected category text.
     *
     * @param table The JTable to analyze for rows with expiring dates
     */
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
        TreePath selectedPath=categorytree.getSelectionPath();
        String selectedText=null;
        if(selectedPath!=null){
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath.getLastPathComponent();
            selectedText= selectedNode.getUserObject().toString();
        }
        if(selectedText==null){
            selectedText=" Categories ";
        }
        labelforexpireproducts.setText("The number of products in \n"+selectedText+" "+table.getRowCount());
    }
    /**
     * Calculates the total Sales from the specified column in the provided table.
     * Updates the profit label with the calculated total.
     *
     * @param table The JTable from which to calculate the profit
     */
    private void writeInProfitlabel(JTable table) {
        double totalProfit = 0.0;
        int columnToCalculate = 1;

        for (int row = 0; row < table.getRowCount(); row++) {
            Object value = table.getValueAt(row, columnToCalculate);
            if (value instanceof Double) {
                totalProfit += (Double) value;
            }
        }
        profitlabel.setText("Total Sales is: " + totalProfit);
    }


    // Variables declaration - do not modify
    private final User user;
    private java.awt.Button Backbtn;
    private javax.swing.JRadioButton Dailyradiobtn;
    private javax.swing.JPanel Inventorypanel;
    private java.awt.Button backbtnforinventory;
    private javax.swing.JPanel Salespanel;
    private javax.swing.JTree categorytree;
    private java.awt.Button generatepdfbtn;
    private java.awt.Button generatereportbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelforexpireproducts;
    private javax.swing.JRadioButton monthlyradiobtn;
    private com.toedter.calendar.JDateChooser nextdate;
    private com.toedter.calendar.JDateChooser previousdate;
    private javax.swing.JTable producttable;
    private javax.swing.JLabel profitlabel;
    private javax.swing.JTextField searchtextfield;
    private javax.swing.JRadioButton weeklyradiobtn;
    private ButtonGroup buttonGroup;
    // End of variables declaration
}


