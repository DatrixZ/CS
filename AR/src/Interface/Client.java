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
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.HashMap;
/**
 *
 * @author datri
 */
public class Client extends javax.swing.JFrame {

    private int PORT;
    private String server_name;
    Socket SERVER;
    
    private String user;
    private DefaultListModel list;
    private String destination;
    
    private HashMap<String,String> chats;
    
    private int xMouse;
    private int yMouse;
    BufferedReader getter;
    PrintWriter outer;
    
    public Client() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        list = (DefaultListModel) friends.getModel();
        Input.setEditable(false);
        
        chats = new HashMap<String,String>();
        destination="none";
        
        Screen.setEditable(false);
        Input.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                outer.println(destination);
                outer.println(Input.getText());
                Screen.append(user+": "+Input.getText()+"\n");
                chats.put(destination, Screen.getText());
                //System.out.println("OUT "+Input.getText());
                Input.setText("");
                
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Screen = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setIconImage(getIconImage());
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(700, 450));
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 0));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jScrollPane2.setViewportView(jTextPaneSearch);

        jScrollPane3.setBorder(null);

        friends.setBackground(new java.awt.Color(51, 51, 51));
        friends.setForeground(new java.awt.Color(255, 255, 255));
        friends.setModel(new DefaultListModel ());
        friends.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        friends.setToolTipText("");
        friends.setFixedCellHeight(70);
        friends.setSelectionBackground(new java.awt.Color(153, 0, 153));
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        Input.setBackground(new java.awt.Color(51, 51, 51));
        Input.setForeground(new java.awt.Color(255, 255, 255));
        Input.setBorder(null);
        Input.setCaretColor(new java.awt.Color(255, 255, 255));
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

        user_name.setBackground(new java.awt.Color(51, 51, 51));
        user_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        user_name.setForeground(new java.awt.Color(255, 255, 255));
        user_name.setOpaque(true);

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        Screen.setBackground(new java.awt.Color(51, 51, 51));
        Screen.setColumns(20);
        Screen.setForeground(new java.awt.Color(255, 255, 255));
        Screen.setRows(5);
        Screen.setBorder(null);
        jScrollPane1.setViewportView(Screen);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Input, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(user_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Input, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        int x=evt.getXOnScreen();
        int y =evt.getYOnScreen();

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
        if (!evt.getValueIsAdjusting()) {
            System.out.println("CHANGED: "+destination+" -> "+friends.getSelectedValue());
            destination=friends.getSelectedValue();
            Input.setEditable(true);
            Screen.setText(chats.get(destination));
            
        }
    }//GEN-LAST:event_friendsValueChanged
    
    /**
     * @param args the command line arguments
     */

    class MainPanel extends JPanel {

        public MainPanel() {
            setBackground(Color.gray);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }



    class OutsidePanel extends JPanel {

        public OutsidePanel() {
            setLayout(new BorderLayout());
            add(new MainPanel(), BorderLayout.CENTER);
            setBorder(new LineBorder(Color.BLACK, 5));
        }
    }

    public void Resizer() {

        ComponentResizer cr = new ComponentResizer();
        cr.setMinimumSize(new Dimension(300, 300));
        cr.registerComponent(this);
        cr.setSnapSize(new Dimension(10, 10));
        cr.setDragInsets(new Insets(15,15,15,15));
        add(new OutsidePanel());
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
        /*
        Login login = new Login();
        login.setVisible(true);
         */
        Client chat = new Client();
        
        chat.Resizer();
        chat.handler();
       
        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
        */
        
    }
    
    public void setUsername(String u){
        user=u;
    }
    public void handler() throws IOException{
        
        SERVER=new Socket(server_name, PORT);
        getter = new BufferedReader(new InputStreamReader(SERVER.getInputStream()));
        outer = new PrintWriter(SERVER.getOutputStream(),true);
        String x;
        String split[];
        
        while(true){
            x = getter.readLine();
            if (x.startsWith("SUBMITNAME")) {
               // user=getUserName();
                JFrame frame = new JFrame("My dialog asks....");
                frame.setUndecorated( true );
                frame.setVisible( true );
                frame.setLocationRelativeTo( null );
                frame.setIconImage(getIconImage());
                Login login = new Login();
                frame.dispose();
                
                user=login.getUsername();
                
                //System.out.println("In");
                if(user == null)
                    System.exit(0);
                else
                    outer.println(user);
            } 
            else if (x.startsWith("NAMEACCEPTED")) {
                user_name.setText(user);
                setVisible(true);
            } 
            else if (x.startsWith("ADD")) {
                //System.out.println("GET "+x.substring(4));
                addFriend(x.substring(4));
            } 
            else if (x.startsWith("MESSAGE")) {
                System.out.println("GET "+x.substring(8));
                split=x.split(" ");
                //System.out.println(split[1]+" ?= "+destination+":");
                if(split[1].equals(destination+ ":")){
                    Screen.append(x.substring(8) + "\n");
                    chats.put(destination, Screen.getText());
                }
                else{
                    chats.put(split[1].split(":")[0], chats.get(split[1].split(":")[0])+x.substring(8)+"\n");
                }
                System.out.println("Key: "+destination+" // Value: "+chats.get(destination));
            }
        }
    }
    
    private String getUserName() {
        
        Login login = new Login();
        login.setVisible(true);
        
        return JOptionPane.showInputDialog(
            this,
            login.getBase(),
            JOptionPane.PLAIN_MESSAGE);
    }
    
    public void addFriend(String name){
      
        list.addElement(name);
        chats.put(name, "");
    }
    
    private JPanel getPanel(){
        JPanel panel = new JPanel();
        
        return panel;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Input;
    private javax.swing.JTextArea Screen;
    private javax.swing.JList<String> friends;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelDrag;
    private javax.swing.JLabel jLabelMaximize;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPaneSearch;
    private javax.swing.JLabel user_name;
    // End of variables declaration//GEN-END:variables
}
