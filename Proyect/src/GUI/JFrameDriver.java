/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Domain.Driver;
import Domain.Janitor;
import File.FileDriver;
import File.SerializableDriver;
import Utility.Path;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JFrameDriver extends javax.swing.JFrame{

    boolean isQualified;
    String path = "./Driver.dat";


    /**
     * Creates new form JFrameEmployee
     */
    public JFrameDriver() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        isQualified = false;
         buttonGroupOption.add(option1);
        buttonGroupOption.add(option2);

    }

    /**
     *
     * @return @throws IOException
     */
//    public boolean insertMethod() throws IOException{
//      fileDriver= new SerializableDriver(fileDriver);
//      seriaDriver.(driver);
//        System.out.println("Ingresado con exito");
//        return true;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Message = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        buttonGroupOption = new javax.swing.ButtonGroup();
        jTabbedPaneEmployee = new javax.swing.JTabbedPane();
        jPanelInsert = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        labelLastName = new javax.swing.JLabel();
        labelIdentification = new javax.swing.JLabel();
        labelDayHours = new javax.swing.JLabel();
        labelNigthHours = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jTextFieldIdentification = new javax.swing.JTextField();
        jTextFieldDayHours = new javax.swing.JTextField();
        jTextFieldNigthHours = new javax.swing.JTextField();
        Insert = new javax.swing.JButton();
        Qualified = new javax.swing.JLabel();
        option1 = new javax.swing.JRadioButton();
        option2 = new javax.swing.JRadioButton();
        jButtonWindowPrincipal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelMessage = new javax.swing.JLabel();
        jLabelLicense = new javax.swing.JLabel();
        jTextFieldLicense = new javax.swing.JTextField();
        jLabelTimeWorked = new javax.swing.JLabel();
        jTextFieldTimeWorked = new javax.swing.JTextField();
        jPanelSearch = new javax.swing.JPanel();
        jLabelNameSearch = new javax.swing.JLabel();
        jTextFieldNameSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaNameSearch = new javax.swing.JTextArea();
        jPanelActualize = new javax.swing.JPanel();
        jPanelDelete = new javax.swing.JPanel();
        labelIdentificationDelete = new javax.swing.JLabel();
        jTextFieldIdentificationDelete = new javax.swing.JTextField();
        jButtonDelete = new javax.swing.JButton();
        message = new javax.swing.JLabel();

        Message.setBackground(new java.awt.Color(204, 255, 153));
        Message.setFont(new java.awt.Font("Felix Titling", 1, 12)); // NOI18N
        Message.setText("Enter the name");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(530, 520));
        setMinimumSize(new java.awt.Dimension(530, 520));
        setPreferredSize(new java.awt.Dimension(530, 520));
        setSize(new java.awt.Dimension(530, 520));
        getContentPane().setLayout(null);

        jTabbedPaneEmployee.setMaximumSize(new java.awt.Dimension(530, 520));
        jTabbedPaneEmployee.setMinimumSize(new java.awt.Dimension(530, 520));
        jTabbedPaneEmployee.setPreferredSize(new java.awt.Dimension(530, 520));
        jTabbedPaneEmployee.setRequestFocusEnabled(false);

        jPanelInsert.setMaximumSize(new java.awt.Dimension(600, 600));
        jPanelInsert.setMinimumSize(new java.awt.Dimension(600, 600));
        jPanelInsert.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanelInsert.setLayout(null);

        labelName.setText("Name");
        jPanelInsert.add(labelName);
        labelName.setBounds(100, 20, 60, 30);

        labelLastName.setText("Last Name");
        jPanelInsert.add(labelLastName);
        labelLastName.setBounds(100, 70, 80, 30);

        labelIdentification.setText("Identification");
        jPanelInsert.add(labelIdentification);
        labelIdentification.setBounds(100, 110, 80, 40);

        labelDayHours.setText("Day Hours");
        jPanelInsert.add(labelDayHours);
        labelDayHours.setBounds(100, 160, 70, 30);

        labelNigthHours.setText("Nigth Hours");
        jPanelInsert.add(labelNigthHours);
        labelNigthHours.setBounds(100, 200, 70, 30);
        jPanelInsert.add(jTextFieldName);
        jTextFieldName.setBounds(200, 20, 140, 30);

        jTextFieldLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLastNameActionPerformed(evt);
            }
        });
        jPanelInsert.add(jTextFieldLastName);
        jTextFieldLastName.setBounds(200, 70, 140, 30);

        jTextFieldIdentification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdentificationActionPerformed(evt);
            }
        });
        jPanelInsert.add(jTextFieldIdentification);
        jTextFieldIdentification.setBounds(200, 120, 140, 28);
        jPanelInsert.add(jTextFieldDayHours);
        jTextFieldDayHours.setBounds(200, 160, 140, 27);
        jPanelInsert.add(jTextFieldNigthHours);
        jTextFieldNigthHours.setBounds(200, 200, 140, 27);

        Insert.setBackground(new java.awt.Color(76, 175, 80));
        Insert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Insert.setForeground(new java.awt.Color(255, 255, 255));
        Insert.setText("Insert");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });
        jPanelInsert.add(Insert);
        Insert.setBounds(170, 390, 113, 32);

        Qualified.setText("Qualified");
        jPanelInsert.add(Qualified);
        Qualified.setBounds(100, 340, 60, 20);

        option1.setText("Yes");
        jPanelInsert.add(option1);
        option1.setBounds(210, 330, 50, 30);

        option2.setText("No");
        jPanelInsert.add(option2);
        option2.setBounds(280, 330, 50, 30);

        jButtonWindowPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/baseline_home_black_18dp.png"))); // NOI18N
        jButtonWindowPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWindowPrincipalActionPerformed(evt);
            }
        });
        jPanelInsert.add(jButtonWindowPrincipal);
        jButtonWindowPrincipal.setBounds(400, 380, 51, 45);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Driver");
        jPanelInsert.add(jLabel1);
        jLabel1.setBounds(10, 10, 130, 30);
        jPanelInsert.add(jLabelMessage);
        jLabelMessage.setBounds(10, 390, 140, 40);

        jLabelLicense.setText("License");
        jPanelInsert.add(jLabelLicense);
        jLabelLicense.setBounds(100, 250, 70, 20);
        jPanelInsert.add(jTextFieldLicense);
        jTextFieldLicense.setBounds(200, 240, 140, 30);

        jLabelTimeWorked.setText("Time Worked");
        jPanelInsert.add(jLabelTimeWorked);
        jLabelTimeWorked.setBounds(100, 290, 70, 20);
        jPanelInsert.add(jTextFieldTimeWorked);
        jTextFieldTimeWorked.setBounds(200, 290, 140, 30);

        jTabbedPaneEmployee.addTab("Insert", jPanelInsert);

        jLabelNameSearch.setText("Name Search");

        jTextFieldNameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameSearchActionPerformed(evt);
            }
        });
        jTextFieldNameSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNameSearchKeyReleased(evt);
            }
        });

        jTextAreaNameSearch.setColumns(20);
        jTextAreaNameSearch.setRows(5);
        jScrollPane1.setViewportView(jTextAreaNameSearch);

        javax.swing.GroupLayout jPanelSearchLayout = new javax.swing.GroupLayout(jPanelSearch);
        jPanelSearch.setLayout(jPanelSearchLayout);
        jPanelSearchLayout.setHorizontalGroup(
            jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelSearchLayout.createSequentialGroup()
                        .addComponent(jLabelNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(331, Short.MAX_VALUE))
        );
        jPanelSearchLayout.setVerticalGroup(
            jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        jTabbedPaneEmployee.addTab("Search", jPanelSearch);

        javax.swing.GroupLayout jPanelActualizeLayout = new javax.swing.GroupLayout(jPanelActualize);
        jPanelActualize.setLayout(jPanelActualizeLayout);
        jPanelActualizeLayout.setHorizontalGroup(
            jPanelActualizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );
        jPanelActualizeLayout.setVerticalGroup(
            jPanelActualizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        jTabbedPaneEmployee.addTab("Update", jPanelActualize);

        labelIdentificationDelete.setText("Identification");

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDeleteLayout = new javax.swing.GroupLayout(jPanelDelete);
        jPanelDelete.setLayout(jPanelDeleteLayout);
        jPanelDeleteLayout.setHorizontalGroup(
            jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeleteLayout.createSequentialGroup()
                .addGroup(jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDeleteLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(labelIdentificationDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jTextFieldIdentificationDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDeleteLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jButtonDelete))
                    .addGroup(jPanelDeleteLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanelDeleteLayout.setVerticalGroup(
            jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeleteLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanelDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdentificationDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdentificationDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jButtonDelete)
                .addGap(62, 62, 62)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jTabbedPaneEmployee.addTab("Delete", jPanelDelete);

        getContentPane().add(jTabbedPaneEmployee);
        jTabbedPaneEmployee.setBounds(0, 0, 530, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jTextFieldIdentificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdentificationActionPerformed
//        jTextFieldName.getText(),jTextFieldLastName.getText(),
//                                   Integer.parseInt(jTextFieldIdentification.getText()),
//                                    "" , Integer.parseInt(jTextFieldDayHours.getText()),
//                                   Integer.parseInt(jTextFieldNigthHours.getText()),isQualified
    }//GEN-LAST:event_jTextFieldIdentificationActionPerformed

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed

        jLabelMessage.setVisible(true);
        jLabelMessage.setText("Successfully inserted vehicle");
        if (option1.isSelected()) {
            isQualified = true;
             option2.setSelected(false);
        }
       
        if (option2.isSelected()) {
            isQualified = false;
//            option1.setSelected(false);
        }
      

        try {
             Driver driver = new Driver(jTextFieldLicense.getText(),
                Integer.parseInt(jTextFieldNigthHours.getText()),
                Integer.parseInt(jTextFieldDayHours.getText()),
                Integer.parseInt(jTextFieldTimeWorked.getText()),
                isQualified,
                jTextFieldName.getText(), jTextFieldLastName.getText(),
                Integer.parseInt(jTextFieldIdentification.getText()));
          
           SerializableDriver seriaDriver = new SerializableDriver(Path.pathDriver);
            seriaDriver.serialize(driver);
        } catch (IOException e) {
            Logger.getLogger(JFrameDriver.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFrameDriver.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("se inserto");

        jTextFieldName.setText("");
        jTextFieldLastName.setText("");
        jTextFieldIdentification.setText("");
        jTextFieldDayHours.setText("");
        jTextFieldNigthHours.setText("");
        jTextFieldLicense.setText("");
        jTextFieldTimeWorked.setText("");
        option1.setSelected(false);
        option2.setSelected(false);
       
        

    }//GEN-LAST:event_InsertActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
//        try {
//            driverFile.deleteRecord(12);
//        } catch (IOException ex) {
//            Logger.getLogger(JFrameDriver.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTextFieldNameSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameSearchActionPerformed

    private void jTextFieldNameSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNameSearchKeyReleased
        String information = "";

//        for (int i = 0; i < fileDriver.length(); i++) {
//            if(fileDriver.empiezaPor(jTextFieldNameSearch.getText()))
//                information+=fileDriver.get(i).toString()+"\n";
//            jTextAreaNameSearch.setText(information);
//        }

    }//GEN-LAST:event_jTextFieldNameSearchKeyReleased

    private void jTextFieldLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLastNameActionPerformed

    private void jButtonWindowPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWindowPrincipalActionPerformed
        WindowRegistration frame_backhome = new WindowRegistration();
        frame_backhome.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonWindowPrincipalActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Insert;
    private javax.swing.JLabel Message;
    private javax.swing.JLabel Qualified;
    private javax.swing.ButtonGroup buttonGroupOption;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonWindowPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLicense;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelNameSearch;
    private javax.swing.JLabel jLabelTimeWorked;
    private javax.swing.JPanel jPanelActualize;
    private javax.swing.JPanel jPanelDelete;
    private javax.swing.JPanel jPanelInsert;
    private javax.swing.JPanel jPanelSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPaneEmployee;
    private javax.swing.JTextArea jTextAreaNameSearch;
    private javax.swing.JTextField jTextFieldDayHours;
    private javax.swing.JTextField jTextFieldIdentification;
    private javax.swing.JTextField jTextFieldIdentificationDelete;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldLicense;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldNameSearch;
    private javax.swing.JTextField jTextFieldNigthHours;
    private javax.swing.JTextField jTextFieldTimeWorked;
    private javax.swing.JLabel labelDayHours;
    private javax.swing.JLabel labelIdentification;
    private javax.swing.JLabel labelIdentificationDelete;
    private javax.swing.JLabel labelLastName;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelNigthHours;
    private javax.swing.JLabel message;
    private javax.swing.JRadioButton option1;
    private javax.swing.JRadioButton option2;
    // End of variables declaration//GEN-END:variables
}