package Music4LifebyThM;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class ThMxLoginPanel extends javax.swing.JFrame {

    static int xMouse,yMouse;
    public static int idlogin;
    
    public void set_id(int id)
    {
        idlogin = id;
    }
    public int get_idlogin()
    {
        return idlogin;
    }
    
    public ThMxLoginPanel() {
        this.setUndecorated(true);
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        bg_loginpanel.setBackground(new Color(0,0,0,0));
        txtf_username.setBackground(new Color(0,0,0,0));
        txtf_password.setBackground(new Color(0,0,0,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_loginpanel = new javax.swing.JPanel();
        lbl_warning = new javax.swing.JLabel();
        bt_exitsystem = new javax.swing.JLabel();
        txtf_username = new javax.swing.JTextField();
        txtf_password = new javax.swing.JPasswordField();
        bt_login = new javax.swing.JLabel();
        bt_loginasguest = new javax.swing.JLabel();
        bg_loginform = new javax.swing.JLabel();
        bg_loginstructure = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg_loginpanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bg_loginpanelMouseDragged(evt);
            }
        });
        bg_loginpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bg_loginpanelMousePressed(evt);
            }
        });
        bg_loginpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_warning.setFont(new java.awt.Font("TH Chakra Petch", 0, 24)); // NOI18N
        lbl_warning.setForeground(new java.awt.Color(255, 51, 0));
        lbl_warning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg_loginpanel.add(lbl_warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 450, 30));

        bt_exitsystem.setFont(new java.awt.Font("TH Chakra Petch", 1, 36)); // NOI18N
        bt_exitsystem.setForeground(new java.awt.Color(248, 92, 77));
        bt_exitsystem.setText("EXIT");
        bt_exitsystem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bt_exitsystemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bt_exitsystemFocusLost(evt);
            }
        });
        bt_exitsystem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_exitsystemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_exitsystemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_exitsystemMouseExited(evt);
            }
        });
        bg_loginpanel.add(bt_exitsystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 670, -1, -1));

        txtf_username.setFont(new java.awt.Font("TH Baijam", 1, 24)); // NOI18N
        txtf_username.setForeground(new java.awt.Color(102, 102, 102));
        txtf_username.setText("Enter Username here!");
        txtf_username.setBorder(null);
        txtf_username.setOpaque(false);
        txtf_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtf_usernameFocusGained(evt);
            }
        });
        txtf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtf_usernameActionPerformed(evt);
            }
        });
        bg_loginpanel.add(txtf_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 310, -1));

        txtf_password.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtf_password.setForeground(new java.awt.Color(102, 102, 102));
        txtf_password.setText("Password Here");
        txtf_password.setToolTipText("");
        txtf_password.setBorder(null);
        txtf_password.setOpaque(false);
        txtf_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtf_passwordFocusGained(evt);
            }
        });
        txtf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtf_passwordActionPerformed(evt);
            }
        });
        bg_loginpanel.add(txtf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 310, 30));

        bt_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_login.png"))); // NOI18N
        bt_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt_loginMouseReleased(evt);
            }
        });
        bg_loginpanel.add(bt_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, -1, -1));

        bt_loginasguest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_loginasguest.png"))); // NOI18N
        bt_loginasguest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt_loginasguestMouseReleased(evt);
            }
        });
        bg_loginpanel.add(bt_loginasguest, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 570, -1, -1));

        bg_loginform.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/LoginForm.png"))); // NOI18N
        bg_loginpanel.add(bg_loginform, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 310, 230));

        bg_loginstructure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bg_loginStructure.png"))); // NOI18N
        bg_loginpanel.add(bg_loginstructure, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_loginpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_loginpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtf_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf_usernameFocusGained
        txtf_username.setText("");
    }//GEN-LAST:event_txtf_usernameFocusGained

    private void txtf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtf_usernameActionPerformed

    }//GEN-LAST:event_txtf_usernameActionPerformed

    private void txtf_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf_passwordFocusGained
        txtf_password.setText("");
    }//GEN-LAST:event_txtf_passwordFocusGained

    private void txtf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtf_passwordActionPerformed

    }//GEN-LAST:event_txtf_passwordActionPerformed

    private void bt_exitsystemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_exitsystemMouseClicked
        System.exit(0);
    }//GEN-LAST:event_bt_exitsystemMouseClicked

    private void bt_exitsystemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_exitsystemFocusGained

    }//GEN-LAST:event_bt_exitsystemFocusGained

    private void bt_exitsystemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_exitsystemFocusLost

    }//GEN-LAST:event_bt_exitsystemFocusLost

    private void bt_exitsystemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_exitsystemMouseEntered
        bt_exitsystem.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_bt_exitsystemMouseEntered

    private void bt_exitsystemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_exitsystemMouseExited
        bt_exitsystem.setForeground(new Color(248, 92, 77));
    }//GEN-LAST:event_bt_exitsystemMouseExited

    private void bg_loginpanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bg_loginpanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_bg_loginpanelMousePressed

    private void bg_loginpanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bg_loginpanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_bg_loginpanelMouseDragged

    private void bt_loginMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_loginMouseReleased
         String loginusername = txtf_username.getText();
        String loginpassword = txtf_password.getText();
        final String acc_admin = "admin";
        final String acc_admin_password = "1234";
        final String acc_customer = "shoichi";
        final String acc_cus_password = "1234";
        final String acc_customer1 = "hobo";
        final String acc_cus_password1 = "1234";

        if(loginusername.equals(acc_admin) && loginpassword.equals(new String(acc_admin_password)))
        {
            lbl_warning.setText("Successful Login");
            set_id(0);
            ThMxAdmin ThMxAdmin = new ThMxAdmin();
            ThMxAdmin.setVisible(true);
            ThMxAdmin.pack();
            ThMxAdmin.setLocationRelativeTo(null);
            ThMxAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        else if(loginusername.equals(acc_customer) && loginpassword.equals(new String(acc_cus_password)))
        {
            lbl_warning.setText("Successful Login");
            idlogin = 2;
            ThMxUser ThMxUser = new ThMxUser();
            ThMxUser.setVisible(true);
            ThMxUser.pack();
            ThMxUser.setLocationRelativeTo(null);
            ThMxUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        else if(loginusername.equals(acc_customer1) && loginpassword.equals(new String(acc_cus_password1)))
        {
            lbl_warning.setText("Successful Login");
            idlogin = 3;
            ThMxUser ThMxUser = new ThMxUser();
            ThMxUser.setVisible(true);
            ThMxUser.pack();
            ThMxUser.setLocationRelativeTo(null);
            ThMxUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        else
        {
            lbl_warning.setText("Incorrect, Try Again or Please Login As Guest");
        }
    }//GEN-LAST:event_bt_loginMouseReleased

    private void bt_loginasguestMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_loginasguestMouseReleased
        idlogin = 1;
        ThMxUser ThMxUser = new ThMxUser();
        ThMxUser.setVisible(true);
        ThMxUser.pack();
        ThMxUser.setLocationRelativeTo(null);
        ThMxUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_bt_loginasguestMouseReleased

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
            java.util.logging.Logger.getLogger(ThMxLoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThMxLoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThMxLoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThMxLoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThMxLoginPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg_loginform;
    private javax.swing.JPanel bg_loginpanel;
    private javax.swing.JLabel bg_loginstructure;
    private javax.swing.JLabel bt_exitsystem;
    private javax.swing.JLabel bt_login;
    private javax.swing.JLabel bt_loginasguest;
    private javax.swing.JLabel lbl_warning;
    private javax.swing.JPasswordField txtf_password;
    private javax.swing.JTextField txtf_username;
    // End of variables declaration//GEN-END:variables
}
