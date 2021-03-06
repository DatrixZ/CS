/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
/**
 *
 * @author datri
 */
public class Login extends javax.swing.JDialog {

    /**
     * Creates new form Main
     */
    private int xMouse;
    private int yMouse;
    private String user;
    private String pass;
    private JFrame frame;

    
    public Login(boolean error, String n) {
        System.out.println("FRAAAAME");
        frame = new JFrame("My dialog asks....");
        frame.setUndecorated( true );
        frame.setVisible( true );
        frame.setLocationRelativeTo( null );
        frame.setIconImage(getIconImage());
        
        initComponents();
        ERROR.setVisible(error);
        
        Username.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                erase();
            }
        });
        Password.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                erase();
            }
        });
        
        if(error)
        addWindowListener( new WindowAdapter() {
            public void windowOpened( WindowEvent e ){
                Password.requestFocus();
            }
        }); 
        
        Username.setText(n);
        //setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setModal(true);
        setVisible(true);
                
    }
    
    public Image getIconImage(){
        Image image = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/Logo.png"));
        return image;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLogin = new javax.swing.JPanel();
        LOGIN = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelClose = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        ERROR = new javax.swing.JLabel();
        jLabelDrag = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLogin.setBackground(new java.awt.Color(51, 51, 51));
        JLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LOGIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button_Login.png"))); // NOI18N
        LOGIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LOGINMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LOGINMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LOGINMouseReleased(evt);
            }
        });
        JLogin.add(LOGIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(166, 166, 166));
        JLogin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 250, 10));

        jSeparator2.setBackground(new java.awt.Color(166, 166, 166));
        JLogin.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 250, 10));

        jLabelClose.setBackground(new java.awt.Color(51, 51, 51));
        jLabelClose.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(204, 204, 204));
        jLabelClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClose.setText("x");
        jLabelClose.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseExited(evt);
            }
        });
        JLogin.add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 40, 30));

        jLabelPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Password.png"))); // NOI18N
        JLogin.add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        jLabelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/User.png"))); // NOI18N
        JLogin.add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        Username.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setToolTipText("");
        Username.setBorder(null);
        Username.setCaretColor(new java.awt.Color(255, 255, 255));
        Username.setOpaque(false);
        JLogin.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 250, 30));

        Password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.setBorder(null);
        Password.setCaretColor(new java.awt.Color(255, 255, 255));
        Password.setOpaque(false);
        JLogin.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 250, 30));

        ERROR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ERROR.setForeground(new java.awt.Color(255, 0, 51));
        ERROR.setText("Datos incorrectos");
        JLogin.add(ERROR, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 100, 20));

        jLabelDrag.setBackground(new java.awt.Color(51, 51, 51));
        jLabelDrag.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelDrag.setForeground(new java.awt.Color(204, 204, 204));
        jLabelDrag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDrag.setVerticalAlignment(javax.swing.SwingConstants.TOP);
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
        JLogin.add(jLabelDrag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo.png"))); // NOI18N
        JLogin.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, -1, -1));

        jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Background.png"))); // NOI18N
        JLogin.add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        getContentPane().add(JLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDragMousePressed
        if(!evt.isMetaDown()){
            xMouse=evt.getX();
            yMouse=evt.getY();
        }
    }//GEN-LAST:event_jLabelDragMousePressed

    private void jLabelDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDragMouseDragged
        if(!evt.isMetaDown()){
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();

            this.setLocation(x - xMouse, y-yMouse);
        }
    }//GEN-LAST:event_jLabelDragMouseDragged

    private void jLabelCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseExited
        jLabelClose.setBackground(new java.awt.Color(51, 51, 51));
        jLabelClose.setForeground(new java.awt.Color(204, 204, 204));
    }//GEN-LAST:event_jLabelCloseMouseExited

    private void jLabelCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseEntered
        jLabelClose.setBackground(new java.awt.Color(255, 0, 51));
        jLabelClose.setForeground(new java.awt.Color(255, 0, 51));
    }//GEN-LAST:event_jLabelCloseMouseEntered

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void LOGINMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGINMouseReleased
        erase();
    }//GEN-LAST:event_LOGINMouseReleased

    private void LOGINMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGINMouseExited
        LOGIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button_Login.png")));
    }//GEN-LAST:event_LOGINMouseExited

    private void LOGINMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOGINMouseEntered
        LOGIN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button_Login2.png")));
    }//GEN-LAST:event_LOGINMouseEntered
    
    public String getUsername(){
        return user;
    }
    
    public String getPass(){
        return pass;
    }
    
    private void erase(){
        if(!Username.getText().equals("") && !new String(Password.getPassword()).equals("")){
            user= Username.getText();
            pass= new String(Password.getPassword());
            frame.dispose();
            this.dispose();
        }
    }
    /**
     * @param args the command line arguments
     */

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ERROR;
    private javax.swing.JPanel JLogin;
    private javax.swing.JLabel LOGIN;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelDrag;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
