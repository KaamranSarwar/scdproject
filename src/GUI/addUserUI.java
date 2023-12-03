package GUI;

import DAO.UserDao;
import Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

/**
 * User interface to add new users
 */
public class addUserUI extends JFrame {

    UserDao userDao=new UserDao();
    User user;
    public addUserUI(User u) {
        user=u;
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        updateTableWithUserData();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new JPanel();
        Backbutton = new JButton();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        Nametxtfield = new JTextField();
        UserNamefield = new JTextField();
        passwordfield = new JTextField();
        ADDbutton = new JButton();
        jScrollPane2 = new JScrollPane();
        Userstable = new JTable();
        ROLEcombobox = new JComboBox<>();
        Deletebutton = new JButton();
        updatebutton = new JButton();
        rolecombolabel=new JLabel("Select Role ");
        Deletebutton.setForeground(new java.awt.Color(255, 0, 51));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setBackground(new java.awt.Color(237, 255, 244));
        Backbutton.setText("Back");
        Backbutton.setForeground(new java.awt.Color(255, 0, 51));
        Backbutton.setFont(new java.awt.Font("Segoe UI Black", 1, 17));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18));
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 18));
        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        rolecombolabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18));
        rolecombolabel.setForeground(new java.awt.Color(255, 102, 102));
        Backbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BackbuttonActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel3.setText("UserName");

        jLabel4.setText("Password");


        UserNamefield.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                UserNamefieldActionPerformed(evt);
            }
        });

        ADDbutton.setText("ADD");
        /**
         * this is button action listner that when clicked add data to the db
         */
        ADDbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ADDbuttonActionPerformed(evt);
            }
        });

        Userstable.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Name",
                        "Username",
                        "Password",
                        "Role"
                }
        ));

        jScrollPane2.setViewportView(Userstable);

        ROLEcombobox.setModel(new DefaultComboBoxModel<>(new String[] { "manager", "sales assistant" }));
        ROLEcombobox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ROLEcomboboxActionPerformed(evt);
            }
        });

        Deletebutton.setText("Delete");

        updatebutton.setText("Update");
/**
 * this is button action listner that when clicked update data to the db
 */
        updatebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });
/**
 * this button delete data from db
 */
        Deletebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletebuttonActionperform(e);
                updateTableWithUserData();
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(126, 126, 126)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(rolecombolabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(ROLEcombobox, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(ADDbutton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(26, 26, 26)
                                                                .addComponent(Deletebutton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(updatebutton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(passwordfield)
                                                                        .addComponent(Nametxtfield)
                                                                        .addComponent(UserNamefield))
                                                                .addGap(185, 185, 185))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(Backbutton)))
                                .addGap(171, 171, 171))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(passwordfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(Backbutton)
                                                                .addGap(27, 27, 27)
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jLabel1)
                                                                                        .addComponent(Nametxtfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(33, 33, 33)
                                                                                .addComponent(jLabel3))
                                                                        .addComponent(UserNamefield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(33, 33, 33)
                                                                .addComponent(jLabel4)))
                                                .addGap(11, 11, 11)
                                                .addComponent(ROLEcombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(rolecombolabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ADDbutton)
                                        .addComponent(Deletebutton)
                                        .addComponent(updatebutton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addGap(88, 88, 88))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>
    JFrame frame;//user update frame
    private void updatebuttonActionPerformed(ActionEvent evt) {

        if(frame!=null){
            frame.dispose();
        }
        frame=new JFrame("update ");
        frame.dispose();
        int selectedrow=Userstable.getSelectedRow();
        System.out.println("selected rw "+selectedrow);
       if(selectedrow>=0){
           String id=Userstable.getValueAt(selectedrow,0).toString();
           String name = Userstable.getValueAt(selectedrow, 1).toString();
           String username = Userstable.getValueAt(selectedrow, 2).toString();
           String password = Userstable.getValueAt(selectedrow, 3).toString();
           String role = Userstable.getValueAt(selectedrow, 4).toString();
           //String name, String id, String role, String password, String username
           User u1=new User(name,id,role,password,username);
           JPanel panel=new JPanel();
           panel.setBackground(new java.awt.Color(237, 255, 244));
           panel.setLayout(new GridBagLayout());
           GridBagConstraints c = new GridBagConstraints();
           c.insets = new Insets(5, 5, 5, 5);
           c.anchor = GridBagConstraints.WEST;
           c.gridy = 0;
           c.weighty = 0;
           JLabel namelabel=new JLabel("Name");
           JTextField nametxtfield=new JTextField(name,20);
           JLabel usernamelabel=new JLabel("Username");
           JTextField usernametextfield=new JTextField(username,20);
           JLabel passwordlabel=new JLabel("Password");
           JTextField passwordtextfield=new JTextField(password,20);
           String[] roles={"manager","sales assistant"};
           JComboBox rolecombo=new JComboBox<>(roles);
           JButton Updatebtn=new JButton("update");
           for (int i = 0; i < rolecombo.getItemCount(); i++) {
               if (rolecombo.getItemAt(i).equals(role)) {
                   rolecombo.setSelectedIndex(i);
                   break;
               }
           }
           panel.add(namelabel,c);
           panel.add(nametxtfield,c);
           c.gridy=1;
           panel.add(usernamelabel,c);
           panel.add(usernametextfield,c);
           c.gridy=2;
           panel.add(passwordlabel,c);
           panel.add(passwordtextfield,c);
           c.gridy=3;
           panel.add(rolecombo,c);
           c.gridy=4;
           panel.add(Updatebtn,c);
           frame.add(panel);
           frame.setVisible(true);
           frame.setSize(400,300);
           frame.setLocationRelativeTo(null);
           frame.setResizable(false);
           /**
            * this is to update the record of the user in the db
            */
           Updatebtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   if(nametxtfield.getText().isEmpty()){
                       JOptionPane.showMessageDialog(null,"Enter name","error",JOptionPane.ERROR_MESSAGE);
                   }
                   else if(usernametextfield.getText().isEmpty()){
                       JOptionPane.showMessageDialog(null,"Enter Username","error",JOptionPane.ERROR_MESSAGE);
                   } else if (passwordtextfield.getText().isEmpty()) {
                       JOptionPane.showMessageDialog(null,"Enter Password","error",JOptionPane.ERROR_MESSAGE);
                   }
                   else{
                       if(!usernametextfield.getText().equals(u1.getUsername())){
                           User U2=new User(u1.getName(),u1.getId(),u1.getRole(),u1.getPassword(),usernametextfield.getText());
                           if(!userDao.getUser(U2)){
                               userDao.updateUserById(U2);
                               updateTableWithUserData();
                               frame.dispose();
                           }
                       }
                       else{
                           String name=nametxtfield.getText();
                           String pass=passwordtextfield.getText();
                           String id=u1.getId();
                           String rol=rolecombo.getSelectedItem().toString();
                           String uname=usernametextfield.getText();
                           User U2=new User(name,id,rol,pass,uname);
                           userDao.updateUserById(U2);
                           updateTableWithUserData();
                           frame.dispose();
                       }
                   }
               }
           });
       }
       else {
           JOptionPane.showMessageDialog(null, "Select the record you want to Update", "Error", JOptionPane.ERROR_MESSAGE);
       }
    }


    private void ROLEcomboboxActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * add button to add user into the db
     * @param evt
     */
    private void ADDbuttonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        if(Nametxtfield.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter name! ","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else if(UserNamefield.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter Username! ","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else if(passwordfield.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter password! ","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
            User user=new User();
            user.setName(Nametxtfield.getText());
            user.setUsername(UserNamefield.getText());
            user.setPassword(passwordfield.getText());
            user.setRole((String) ROLEcombobox.getSelectedItem());
            if(!userDao.getUser(user)){
                userDao.addUser(user);
                updateTableWithUserData();
                Nametxtfield.setText("");
                UserNamefield.setText("");
                passwordfield.setText("");
                JOptionPane.showMessageDialog(null, "User Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"User Already exists with same UserName","Error",JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    private void UserNamefieldActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * fucntion for going back to the homepage when button presses
     * @param evt
     */

    private void BackbuttonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        new managerhome(user).setVisible(true);
        this.dispose();
    }

    /**
     * functiom for the delete the user from the db
     * @param e
     */
    private void deletebuttonActionperform(ActionEvent e) {
        int selectedRow = Userstable.getSelectedRow();
        if (selectedRow >= 0) {
            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                String id=Userstable.getValueAt(selectedRow,0).toString();
                String name = Userstable.getValueAt(selectedRow, 1).toString();
                String username = Userstable.getValueAt(selectedRow, 2).toString();
                String password = Userstable.getValueAt(selectedRow, 3).toString();
                String role = Userstable.getValueAt(selectedRow, 4).toString();

                User user1 = new User();
                user1.setId(id);
                user1.setName(name);
                user1.setUsername(username);
                user1.setPassword(password);
                user1.setRole(role);
                if(!Objects.equals(user1.getUsername(), user.getUsername())){
                    System.out.println(user1.getUsername()+" = "+user.getUsername());
                    userDao.deleteUser(user1);
                    JOptionPane.showMessageDialog(null, "Deleted User Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "User Cannot delete himself", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // User clicked NO or closed the dialog
                JOptionPane.showMessageDialog(null, "Deletion Cancelled", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select the record you want to delete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * this is the function to add data from db to the table
     */
    public void updateTableWithUserData() {
        List<User> userList = userDao.getAllUsers();

        DefaultTableModel model = new DefaultTableModel(new String[]{"userId","Name", "Username", "Password", "Role"}, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                // Set the entire table as non-editable
                return false;
            }
        };

        // Iterate through the list and add each user's data to the table
        for (User user : userList) {
            Object[] rowData = {user.getId(),user.getName(), user.getUsername(), user.getPassword(), user.getRole()};
            model.addRow(rowData);
        }

        Userstable.setModel(model);
    }

    // Variables declaration - do not modify
    private JButton ADDbutton;
    private JButton Backbutton;
    private JButton Deletebutton;
    private JTextField Nametxtfield;
    private JComboBox<String> ROLEcombobox;
    private JTextField UserNamefield;
    private JTable Userstable;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextField passwordfield;
    private JLabel rolecombolabel;
    private JButton updatebutton;
    // End of variables declaration
}
