package ui.MainMenu;

import data.dominio.Avatar;
import javax.swing.JOptionPane;
import ui.base.BasePanel;

/**
 *
 * @param <V>
 */
public class AvatarsJPanel<V extends MainMenuView> extends javax.swing.JPanel implements BasePanel<V> {

    private V view;
    private String avatarName = "";
    private String avatarImage = "";

    /**
     * Creates new form AvatarsJPanel.
     */
    public AvatarsJPanel() {
        initComponents();
    }

    @Override
    public void setView(final V view) {
        this.view = view;
    }

    private void createAvatar() {
        if (!this.avatarWasSelected()) {
            JOptionPane.showMessageDialog(this, "No se a seleccionado un avatar", "Avatar no seleccionado", JOptionPane.QUESTION_MESSAGE);
            return;
        }
    //    this.view.createAvatar(avatarName, avatarImage);
     //   this.view.createPlayer(view.getAvatar());
    }

    private boolean avatarWasSelected() {
        return !avatarName.equalsIgnoreCase("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("all")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAvatar1 = new javax.swing.JButton();
        btnAvatar2 = new javax.swing.JButton();
        btnAvatar3 = new javax.swing.JButton();
        btnAvatar4 = new javax.swing.JButton();
        btnAvatar5 = new javax.swing.JButton();
        lblAvatar4 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblAvatar1 = new javax.swing.JLabel();
        lblAvatar2 = new javax.swing.JLabel();
        lblAvatar3 = new javax.swing.JLabel();
        lblAvatar5 = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 153));
        setForeground(new java.awt.Color(204, 255, 51));
        setPreferredSize(new java.awt.Dimension(1280, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAvatar1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        btnAvatar1.setForeground(new java.awt.Color(0, 153, 153));
        btnAvatar1.setText("AvatarsAASD");
        btnAvatar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAvatar1.setBorderPainted(false);
        btnAvatar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAvatar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar1ActionPerformed(evt);
            }
        });
        add(btnAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 130, 130));

        btnAvatar2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        btnAvatar2.setForeground(new java.awt.Color(0, 153, 153));
        btnAvatar2.setText("AvatarsAASD");
        btnAvatar2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAvatar2.setBorderPainted(false);
        btnAvatar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAvatar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar2ActionPerformed(evt);
            }
        });
        add(btnAvatar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 130, 130));

        btnAvatar3.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        btnAvatar3.setForeground(new java.awt.Color(0, 153, 153));
        btnAvatar3.setText("AvatarsAASD");
        btnAvatar3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAvatar3.setBorderPainted(false);
        btnAvatar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAvatar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar3ActionPerformed(evt);
            }
        });
        add(btnAvatar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 130, 130));

        btnAvatar4.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        btnAvatar4.setForeground(new java.awt.Color(0, 153, 153));
        btnAvatar4.setText("AvatarsAASD");
        btnAvatar4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAvatar4.setBorderPainted(false);
        btnAvatar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAvatar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar4ActionPerformed(evt);
            }
        });
        add(btnAvatar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, 130, 130));

        btnAvatar5.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        btnAvatar5.setForeground(new java.awt.Color(0, 153, 153));
        btnAvatar5.setText("AvatarsAASD");
        btnAvatar5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAvatar5.setBorderPainted(false);
        btnAvatar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAvatar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatar5ActionPerformed(evt);
            }
        });
        add(btnAvatar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 180, 130, 130));

        lblAvatar4.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        lblAvatar4.setForeground(new java.awt.Color(0, 153, 153));
        lblAvatar4.setText("ION");
        add(lblAvatar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 320, 60, 20));

        lblTitle.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 153, 153));
        lblTitle.setText("CHOOSE YOUR AVATAR");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 510, 70));

        lblAvatar1.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        lblAvatar1.setForeground(new java.awt.Color(0, 153, 153));
        lblAvatar1.setText("SIR");
        add(lblAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 40, 20));

        lblAvatar2.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        lblAvatar2.setForeground(new java.awt.Color(0, 153, 153));
        lblAvatar2.setText("ORK");
        add(lblAvatar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 50, 20));

        lblAvatar3.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        lblAvatar3.setForeground(new java.awt.Color(0, 153, 153));
        lblAvatar3.setText("LIS");
        add(lblAvatar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 30, 20));

        lblAvatar5.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        lblAvatar5.setForeground(new java.awt.Color(0, 153, 153));
        lblAvatar5.setText("DON");
        add(lblAvatar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 320, 60, 20));

        btnSelect.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 36)); // NOI18N
        btnSelect.setForeground(new java.awt.Color(0, 153, 153));
        btnSelect.setText("SELECT");
        btnSelect.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSelect.setBorderPainted(false);
        btnSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });
        add(btnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 610, 240, 80));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        this.createAvatar();
        if (!this.avatarWasSelected()) {
            return;
        }
       // this.view.displayLobbyPanel();

    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnAvatar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar1ActionPerformed
        // TODO add your handling code here:
        this.avatarName = "SIR";
        this.avatarImage = "imagen1";
    }//GEN-LAST:event_btnAvatar1ActionPerformed

    private void btnAvatar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar2ActionPerformed
        // TODO add your handling code here:
        this.avatarName = "ORK";
        this.avatarImage = "imagen2";

    }//GEN-LAST:event_btnAvatar2ActionPerformed

    private void btnAvatar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar3ActionPerformed
        // TODO add your handling code here:
        this.avatarName = "LIS";
        this.avatarImage = "imagen3";

    }//GEN-LAST:event_btnAvatar3ActionPerformed

    private void btnAvatar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar4ActionPerformed
        // TODO add your handling code here:
        this.avatarName = "ION";
        this.avatarImage = "imagen4";

    }//GEN-LAST:event_btnAvatar4ActionPerformed

    private void btnAvatar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatar5ActionPerformed
        // TODO add your handling code here:
        this.avatarName = "DON";
        this.avatarImage = "imagen5";

    }//GEN-LAST:event_btnAvatar5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvatar1;
    private javax.swing.JButton btnAvatar2;
    private javax.swing.JButton btnAvatar3;
    private javax.swing.JButton btnAvatar4;
    private javax.swing.JButton btnAvatar5;
    private javax.swing.JButton btnSelect;
    private javax.swing.JLabel lblAvatar1;
    private javax.swing.JLabel lblAvatar2;
    private javax.swing.JLabel lblAvatar3;
    private javax.swing.JLabel lblAvatar4;
    private javax.swing.JLabel lblAvatar5;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables

}
