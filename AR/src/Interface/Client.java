/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Image;
import java.awt.Toolkit;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.lang.Object;
import sun.java2d.SunGraphicsEnvironment;
import java.awt.GraphicsConfiguration;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.HashMap;


import java.security.*;
import java.security.Key;
import javax.crypto.KeyGenerator;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.imageio.ImageIO;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author datri
 */
public class Client extends javax.swing.JFrame {

    private int PORT;
    private String server_name;
    Socket SERVER;
    
    private String user="";
    private DefaultListModel list;
    private String destination;
    
    private HashMap<String,String> chats;
    private HashMap<String,String> claves;
    
    private boolean borrando = false;
    
    private int xMouse;
    private int yMouse;
    BufferedReader getter;
    PrintWriter outer;
    KeyPair keys;
    PublicKey RSA;
    PublicKey ServerRSA;
    String IVC;
    StyledDocument doc;
    SimpleAttributeSet left;
    SimpleAttributeSet right;
    
    String initVector;
    public Client() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        list = (DefaultListModel) friends.getModel();     
        doc = Screen.getStyledDocument();
        
        left = new SimpleAttributeSet();
        right = new SimpleAttributeSet();
        
        StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);

        StyleConstants.setSpaceAbove(left, 2);
        StyleConstants.setSpaceAbove(right, 2);
        StyleConstants.setSpaceBelow(left, 2);
        StyleConstants.setSpaceBelow(right, 2);
        
        Input.setEditable(false);
      
        chats = new HashMap<String,String>();
        claves = new HashMap<String, String>();
        IVC = "8u87y6t5r4efghyt";    
        destination = "none";
        
        keys = generateKeyPair();
        System.out.println("PUBLIC KEY:\n "+keys.getPublic());
        
        Screen.setEditable(false);
        
        Input.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!Input.getText().equals("")){
                    
                    outer.println("MESSAGE");
                    outer.println(destination);
                    outer.println(encryptAES(claves.get(destination), IVC, Input.getText().getBytes()));
                    try{
                        doc.setParagraphAttributes(doc.getLength(), 1, right, false);
                        doc.insertString(doc.getLength(), Input.getText()+"\n", right);
                        //Screen.append(user+": "+Input.getText()+"\n");
                    }catch(Exception ex){}
                    
                    chats.put(destination, Screen.getText());
                    //System.out.println("OUT "+Input.getText());
                    Input.setText("");
                }
            }
        
        });
        //------------------------------------PUERTO Y SERVIDOR-----------------------------------------
        PORT=9001;
        server_name="localhost";
    }
    
    public Image getIconImage(){
        Image image = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/Logo.png"));
        return image;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneSearch = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        friends = new javax.swing.JList<>();
        Input = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabelClose = new javax.swing.JLabel();
        jLabelMinimize = new javax.swing.JLabel();
        jLabelDrag = new javax.swing.JLabel();
        jLabelMaximize = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        Friend = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Screen = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setIconImage(getIconImage());
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(700, 450));
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jTextPaneSearch.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(jTextPaneSearch);

        jScrollPane3.setBorder(null);

        friends.setBackground(new java.awt.Color(51, 51, 51));
        friends.setForeground(new java.awt.Color(255, 255, 255));
        friends.setModel(new DefaultListModel ());
        friends.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        friends.setToolTipText("");
        friends.setFixedCellHeight(70);
        friends.setSelectionBackground(new java.awt.Color(0, 153, 153));
        friends.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                friendsValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(friends);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        Input.setBackground(new java.awt.Color(51, 51, 51));
        Input.setForeground(new java.awt.Color(255, 255, 255));
        Input.setBorder(null);
        Input.setCaretColor(new java.awt.Color(255, 255, 255));
        Input.setMargin(new java.awt.Insets(2, 5, 2, 2));
        Input.setMaximumSize(new java.awt.Dimension(50, 50));
        Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(92, 25));

        jLabelClose.setBackground(new java.awt.Color(51, 51, 51));
        jLabelClose.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(204, 204, 204));
        jLabelClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClose.setText("x");
        jLabelClose.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseReleased(evt);
            }
        });

        jLabelMinimize.setBackground(new java.awt.Color(51, 51, 51));
        jLabelMinimize.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelMinimize.setForeground(new java.awt.Color(204, 204, 204));
        jLabelMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinimize.setText("–");
        jLabelMinimize.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseReleased(evt);
            }
        });

        jLabelDrag.setBackground(new java.awt.Color(51, 51, 51));
        jLabelDrag.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelDrag.setForeground(new java.awt.Color(204, 204, 204));
        jLabelDrag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDrag.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelDrag.setFocusable(false);
        jLabelDrag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelDragMouseDragged(evt);
            }
        });
        jLabelDrag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelDragMousePressed(evt);
            }
        });

        jLabelMaximize.setBackground(new java.awt.Color(51, 51, 51));
        jLabelMaximize.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelMaximize.setForeground(new java.awt.Color(204, 204, 204));
        jLabelMaximize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMaximize.setText("[ ]");
        jLabelMaximize.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMaximizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMaximizeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelMaximizeMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDrag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelMaximize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDrag, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelMaximize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        user_name.setBackground(new java.awt.Color(0, 153, 153));
        user_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        user_name.setForeground(new java.awt.Color(255, 255, 255));
        user_name.setOpaque(true);

        Friend.setBackground(new java.awt.Color(0, 153, 153));
        Friend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Friend.setForeground(new java.awt.Color(255, 255, 255));
        Friend.setOpaque(true);

        jScrollPane4.setBorder(null);

        Screen.setBackground(new java.awt.Color(0, 153, 153));
        Screen.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        Screen.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Screen.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(Screen);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IMAGE");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(user_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Friend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Input, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Friend, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Input, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseEntered
        jLabelClose.setBackground(new java.awt.Color(255, 0, 51));
        jLabelClose.setForeground(new java.awt.Color(255, 0, 51));
    }//GEN-LAST:event_jLabelCloseMouseEntered

    private void jLabelCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseExited
        jLabelClose.setBackground(new java.awt.Color(51, 51, 51));
        jLabelClose.setForeground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jLabelCloseMouseExited

    private void jLabelMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseEntered
        jLabelMinimize.setBackground(new java.awt.Color(90, 90, 90));
        jLabelMinimize.setForeground(new java.awt.Color(163, 73, 255));
    }//GEN-LAST:event_jLabelMinimizeMouseEntered

    private void jLabelMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseExited
        jLabelMinimize.setBackground(new java.awt.Color(51, 51, 51));
        jLabelMinimize.setForeground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jLabelMinimizeMouseExited

    private void InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputActionPerformed

    private void jLabelCloseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseReleased
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseReleased

    private void jLabelDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDragMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_jLabelDragMousePressed

    private void jLabelDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDragMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - xMouse-10, y-yMouse-7);
    }//GEN-LAST:event_jLabelDragMouseDragged

    private void jLabelMaximizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMaximizeMouseEntered
        jLabelMaximize.setBackground(new java.awt.Color(90, 90, 90));
        jLabelMaximize.setForeground(new java.awt.Color(163, 73, 255));
    }//GEN-LAST:event_jLabelMaximizeMouseEntered

    private void jLabelMaximizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMaximizeMouseExited
        jLabelMaximize.setBackground(new java.awt.Color(51, 51, 51));
        jLabelMaximize.setForeground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jLabelMaximizeMouseExited

    private void jLabelMinimizeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseReleased
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizeMouseReleased

    private void jLabelMaximizeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMaximizeMouseReleased
        /*GraphicsDevice myDevice = this.getGraphicsConfiguration().getDevice();
        for(GraphicsDevice gd:GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()){
            if(this.getLocation().getX() >= gd.getDefaultConfiguration().getBounds().getMinX() &&
                this.getLocation().getX() < gd.getDefaultConfiguration().getBounds().getMaxX() &&
                this.getLocation().getY() >= gd.getDefaultConfiguration().getBounds().getMinY() &&
                this.getLocation().getY() < gd.getDefaultConfiguration().getBounds().getMaxY())
                myDevice=gd;
        }
        */
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        Rectangle usableBounds = SunGraphicsEnvironment.getUsableBounds(gd);
        setMaximizedBounds(usableBounds);
        setExtendedState(MAXIMIZED_BOTH);
        //this.setExtendedState(this.getExtendedState() | Frame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_jLabelMaximizeMouseReleased

    private void friendsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_friendsValueChanged
        if (!borrando && !evt.getValueIsAdjusting()) {
            System.out.println("CHANGED: "+destination+" -> "+friends.getSelectedValue());
            destination=friends.getSelectedValue();
            Input.setEditable(true);
            Screen.setText(chats.get(destination));
            Friend.setText(destination);
            
            if(claves.get(destination).equals("none")){
                outer.println("RSA_Request");
                outer.println(destination);
            }
        }
    }//GEN-LAST:event_friendsValueChanged

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
        final JFileChooser fc = new JFileChooser();
        
        int returnVal = fc.showOpenDialog(this);
        try{
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
           
            BufferedImage image = ImageIO.read(file);
            Image resize = image.getScaledInstance(300, -1, 0);
            
            WritableRaster raster = image.getRaster();
            DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
            
            /*
                encryptAES(claves.get(destination), IVC, data.getData()); 
            */
            Screen.insertIcon(new ImageIcon(resize));
            //doc.insertString(doc.getLength(), "Opening: " + file.getAbsolutePath()+"\n", left);
             
        } else {
            doc.insertString(doc.getLength(), "OPen action cancelled\n", left);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jLabel1MouseReleased

    public void Resizer() {

        ComponentResizer cr = new ComponentResizer();
        cr.setMinimumSize(new Dimension(300, 300));
        cr.registerComponent(this);
        cr.setSnapSize(new Dimension(10, 10));
        cr.setDragInsets(new Insets(15,15,15,15));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    
    public static void main(String args[]) throws Exception{
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        Client chat = new Client();
        
        chat.Resizer();
        chat.handler();        
    }
    
    public void handler() throws IOException{
        
        SERVER = new Socket(server_name, PORT);
        getter = new BufferedReader(new InputStreamReader(SERVER.getInputStream()));
        outer = new PrintWriter(SERVER.getOutputStream(),true);
        String pass = null;
        boolean error = false;
        String x;
        String d;
        String m;
        ServerRSA = getRSA(getter.readLine());  //Cogemos la RSA del servidor
        
        while(true){
            x = getter.readLine();
            System.out.println("GET "+x);
            
            switch(x){
                case "SUBMITNAME":      Login login = new Login(error,user);
                                        user=login.getUsername();
                                        pass=login.getPass();
                                        System.out.println(user+" "+pass);
                                        if(user == null)
                                            System.exit(0);
                                        else{
                                            outer.println(Base64.getEncoder().encodeToString(encryptRSA(user,ServerRSA)));
                                            outer.println(Base64.getEncoder().encodeToString(encryptRSA(encodeHash(pass),ServerRSA)));
                                        }
                                        error=true;
                                        break;
                                        
                case "NAMEACCEPTED":    user_name.setText(user);
                                        outer.println("RSA_Register");
                                        outer.println(Base64.getEncoder().encodeToString(keys.getPublic().getEncoded()));
                                        setVisible(true);
                                        break;
                                        
                case "ADD":             addFriend(getter.readLine());
                                        break;
                
                case "REMOVE":          removeFriend(getter.readLine());
                                        break;
                                        
                case "RSA_Request":     RSA = getRSA(getter.readLine());
                                        String AES = generateAESKey();
                                        claves.put(destination, AES);
                                        outer.println("RSA_Push");
                                        outer.println(destination);
                                        outer.println(Base64.getEncoder().encodeToString(encryptRSA(AES, RSA)));
                                        break;
                                        
                case "RSA_Insert":      String u = getter.readLine();
                                        String rsa_get =getter.readLine();
                                        claves.put(u, decryptRSA(Base64.getDecoder().decode(rsa_get.getBytes()),keys.getPrivate()));
                                        break;
                
                case "MESSAGE":         d = getter.readLine();
                                        m = getter.readLine();
                                        if(d.equals(destination)){
                                            
                                            try{
                                                //doc.setParagraphAttributes(0, doc.getLength(), left, false);
                                                //doc.insertString(0, d+"\n", left);
                                                doc.setParagraphAttributes(doc.getLength(), 1, left, false);
                                                doc.insertString(doc.getLength(), decryptAES(claves.get(d),IVC,m) + "\n", left);
                                                
                                            }catch(Exception ex){}
                                            //Screen.append(d+"\n");
                                            //Screen.append(decryptAES(claves.get(d),IVC,m) + "\n");                        
                                        }
                                        chats.put(d, chats.get(d)+decryptAES(claves.get(d),IVC,m)+"\n"); 
                                        break;
            }
        }
    }
    
    public void removeFriend(String name){
        borrando = true;
        friends.clearSelection();
        list.removeElement(name);
        chats.put(name, "");
        claves.put(name, "none");
        borrando = false;
    }
    public void addFriend(String name){
        System.out.println("AddFriend "+name);
        list.addElement(name);
        chats.put(name, "");
        claves.put(name, "none");
        System.out.println("RSA Send");
    }
    
    ////////////////////////ENCRIPTACION///////////////////////////////////
    
    // ENCRIPTAR CON CLAVE AES
    public static String encryptAES(String key, String initVector, byte[] mensaje) {

    	try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher encriptador = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            encriptador.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] cifrado = encriptador.doFinal(mensaje);

            return Base64.getEncoder().encodeToString(cifrado);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    // DESENCRIPTAR CON CLAVE AES
    public static String decryptAES(String key, String initVector, String cifrado) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher encriptador = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            encriptador.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] mensaje = encriptador.doFinal(Base64.getDecoder().decode(cifrado));

            return new String(mensaje);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
    //GENERADOR DE CLAVES AES
    public static String generateAESKey(){
        String AESkey = null;
        try{ 
            Key key;
            SecureRandom rand = new SecureRandom();
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(256, rand);
            key = generator.generateKey();
            AESkey=Base64.getEncoder().encodeToString(key.getEncoded()).substring(0, 16);
        }catch(Exception e){
            e.printStackTrace();
        }
        return AESkey;
    }
    
    // GENERAR PAR DE CLAVES (PUBLICA Y PRIVADA)
    public static KeyPair generateKeyPair(){
        
        KeyPair keyPair = null;
        try {
            
            KeyPairGenerator rsaKeyGen = KeyPairGenerator.getInstance("RSA");
            rsaKeyGen.initialize(1024);
            keyPair = rsaKeyGen.generateKeyPair();
            //PublicKey publicKey = keyPair.getPublic();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyPair;
    }

    // ENCRIPTAR CON RSA PUBLICA
    public static byte[] encryptRSA(String mensaje, PublicKey key){
        byte[] cifrado = null;
        try {
            Cipher encriptador = Cipher.getInstance("RSA");
            encriptador.init(Cipher.ENCRYPT_MODE, key);
            cifrado = encriptador.doFinal(mensaje.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cifrado;
    }

    // DESENCRIPTAR CON RSA PRIVADA
    public static String decryptRSA(byte[] cifrado, PrivateKey key){
        byte[] mensaje = null;
        try {
            Cipher encriptador = Cipher.getInstance("RSA");
            encriptador.init(Cipher.DECRYPT_MODE, key);
            mensaje = encriptador.doFinal(cifrado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(mensaje);
    }
    
    //CONVERSOR STRING TO PUBLIC KEY
    private PublicKey getRSA(String rsa_key){
        PublicKey pubKey=null;
        try{
           System.out.println("RSA metodo get:\n "+rsa_key);
           
            byte[] publicBytes = Base64.getDecoder().decode(rsa_key.getBytes());
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            pubKey = keyFactory.generatePublic(keySpec);
            System.out.println("Result "+pubKey);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("End getRSA()");
        return pubKey;
    }
    
    //HASH
    public static String encodeHash (String password){
        String hashed = null;
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            hashed= Base64.getEncoder().encodeToString(hash);
        }

        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return hashed;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Friend;
    private javax.swing.JTextField Input;
    private javax.swing.JTextPane Screen;
    private javax.swing.JList<String> friends;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelDrag;
    private javax.swing.JLabel jLabelMaximize;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPaneSearch;
    private javax.swing.JLabel user_name;
    // End of variables declaration//GEN-END:variables
}
