package Music4LifebyThM;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class ThMxAdmin extends javax.swing.JFrame {

    public static DLL Music_Name = new DLL();
    public static DLL Music_Path = new DLL();
    public static DLL Music_Pic = new DLL();
    ThMxMusicPlayer adminPlayer = new ThMxMusicPlayer();
    public int switchcount;
    static int xMouse,yMouse;
    int index;
    String CurrentsongPath;

    public ThMxAdmin() {
        this.setUndecorated(true);
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        bg_adminPanel.setBackground(new Color(0,0,0,0));
        txt_mName.setBackground(new Color(0,0,0,0));
        txt_mPath.setBackground(new Color(0,0,0,0));
        txt_mPic.setBackground(new Color(0,0,0,0));
        //
        if(Music_Name.getSize() == 0)
        {
            initialMS();
        }
        else
        {
        }
        callNextMusic();    
    }
    
    public static void initialMS(){

        //1
        Music_Name.addLast("Ichika Nito - I miss you");
        Music_Path.addLast("Ichika Nito - I miss you.mp3");
        Music_Pic.addLast("imissyou.png"); 
    }
    
    private void callPrevMusic(){
        index = index - 1;
        if ((index > 0) && (index <= Music_Name.getSize())) {
            lbl_currentMusic.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            CurrentsongPath = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
        } else {
            index = Music_Name.getSize();
            lbl_currentMusic.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            CurrentsongPath = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
        }
    }
    
    private void callNextMusic(){
        index = index + 1;
        if ((index > 0) && (index <= Music_Name.getSize())) {
            lbl_currentMusic.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            CurrentsongPath = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
        } else {
            index = 1;
            lbl_currentMusic.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            CurrentsongPath = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_adminPanel = new javax.swing.JPanel();
        bt_goUser = new javax.swing.JLabel();
        bt_back = new javax.swing.JLabel();
        bt_exit = new javax.swing.JLabel();
        lbl_currentMusic = new javax.swing.JLabel();
        lbl_currentindex = new javax.swing.JLabel();
        lbl_of = new javax.swing.JLabel();
        lbl_size = new javax.swing.JLabel();
        txt_mPic = new javax.swing.JTextField();
        txt_mPath = new javax.swing.JTextField();
        txt_mName = new javax.swing.JTextField();
        bg_formMusic = new javax.swing.JLabel();
        bg_mPic = new javax.swing.JPanel();
        lbl_mPic = new javax.swing.JLabel();
        bt_prev = new javax.swing.JLabel();
        bt_pause = new javax.swing.JLabel();
        bt_play = new javax.swing.JLabel();
        bt_resume = new javax.swing.JLabel();
        bt_next = new javax.swing.JLabel();
        bt_addFirst = new javax.swing.JLabel();
        bt_addLast = new javax.swing.JLabel();
        bt_revFirst = new javax.swing.JLabel();
        bt_revLast = new javax.swing.JLabel();
        bg_adminStructure = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg_adminPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bg_adminPanelMouseDragged(evt);
            }
        });
        bg_adminPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bg_adminPanelMousePressed(evt);
            }
        });
        bg_adminPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_goUser.setFont(new java.awt.Font("TH Baijam", 1, 24)); // NOI18N
        bt_goUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bt_goUser.setText("USER");
        bt_goUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_goUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_goUserMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt_goUserMouseReleased(evt);
            }
        });
        bg_adminPanel.add(bt_goUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, 70, -1));

        bt_back.setFont(new java.awt.Font("TH Baijam", 1, 24)); // NOI18N
        bt_back.setText("<-");
        bt_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_backMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt_backMouseReleased(evt);
            }
        });
        bg_adminPanel.add(bt_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 490, -1, -1));

        bt_exit.setFont(new java.awt.Font("TH Baijam", 1, 24)); // NOI18N
        bt_exit.setText("X");
        bt_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_exitMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt_exitMouseReleased(evt);
            }
        });
        bg_adminPanel.add(bt_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, -1, -1));

        lbl_currentMusic.setFont(new java.awt.Font("TH Chakra Petch", 1, 24)); // NOI18N
        lbl_currentMusic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_currentMusic.setText("Clairo - Hello");
        bg_adminPanel.add(lbl_currentMusic, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 520, 50));

        lbl_currentindex.setFont(new java.awt.Font("TH Baijam", 1, 18)); // NOI18N
        lbl_currentindex.setText("1");
        bg_adminPanel.add(lbl_currentindex, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, -1, -1));

        lbl_of.setFont(new java.awt.Font("TH Baijam", 1, 18)); // NOI18N
        lbl_of.setText("Of");
        bg_adminPanel.add(lbl_of, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 20, -1));

        lbl_size.setFont(new java.awt.Font("TH Baijam", 1, 18)); // NOI18N
        lbl_size.setText("10");
        bg_adminPanel.add(lbl_size, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, -1, -1));

        txt_mPic.setFont(new java.awt.Font("TH Baijam", 1, 24)); // NOI18N
        txt_mPic.setText("default.png");
        txt_mPic.setBorder(null);
        txt_mPic.setOpaque(false);
        txt_mPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mPicActionPerformed(evt);
            }
        });
        bg_adminPanel.add(txt_mPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 750, 380, 30));

        txt_mPath.setFont(new java.awt.Font("TH Baijam", 1, 24)); // NOI18N
        txt_mPath.setText("Name.mp3");
        txt_mPath.setBorder(null);
        txt_mPath.setOpaque(false);
        txt_mPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mPathActionPerformed(evt);
            }
        });
        bg_adminPanel.add(txt_mPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 380, 30));

        txt_mName.setFont(new java.awt.Font("TH Baijam", 1, 24)); // NOI18N
        txt_mName.setText("Name Here!");
        txt_mName.setBorder(null);
        txt_mName.setOpaque(false);
        txt_mName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mNameActionPerformed(evt);
            }
        });
        bg_adminPanel.add(txt_mName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, 380, 30));

        bg_formMusic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/FormMusicDetails.png"))); // NOI18N
        bg_adminPanel.add(bg_formMusic, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 380, -1));

        javax.swing.GroupLayout bg_mPicLayout = new javax.swing.GroupLayout(bg_mPic);
        bg_mPic.setLayout(bg_mPicLayout);
        bg_mPicLayout.setHorizontalGroup(
            bg_mPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_mPicLayout.createSequentialGroup()
                .addComponent(lbl_mPic)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bg_mPicLayout.setVerticalGroup(
            bg_mPicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg_mPicLayout.createSequentialGroup()
                .addComponent(lbl_mPic)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg_adminPanel.add(bg_mPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 230, 220));

        bt_prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_prev.png"))); // NOI18N
        bt_prev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_prevMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_prevMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_prevMouseExited(evt);
            }
        });
        bg_adminPanel.add(bt_prev, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        bt_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_pause.png"))); // NOI18N
        bt_pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_pauseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_pauseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_pauseMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt_pauseMouseReleased(evt);
            }
        });
        bg_adminPanel.add(bt_pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, -1, -1));

        bt_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_play.png"))); // NOI18N
        bt_play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_playMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_playMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_playMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt_playMouseReleased(evt);
            }
        });
        bg_adminPanel.add(bt_play, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, -1, -1));

        bt_resume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_resume.png"))); // NOI18N
        bt_resume.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_resumeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_resumeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt_resumeMouseReleased(evt);
            }
        });
        bg_adminPanel.add(bt_resume, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));

        bt_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_next.png"))); // NOI18N
        bt_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_nextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_nextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_nextMouseExited(evt);
            }
        });
        bg_adminPanel.add(bt_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, -1, -1));

        bt_addFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_addFirst.png"))); // NOI18N
        bt_addFirst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_addFirstMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_addFirstMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_addFirstMouseExited(evt);
            }
        });
        bg_adminPanel.add(bt_addFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 800, -1, -1));

        bt_addLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_addLast.png"))); // NOI18N
        bt_addLast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_addLastMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_addLastMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_addLastMouseExited(evt);
            }
        });
        bg_adminPanel.add(bt_addLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 800, -1, -1));

        bt_revFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_revFirst.png"))); // NOI18N
        bt_revFirst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_revFirstMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_revFirstMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_revFirstMouseExited(evt);
            }
        });
        bg_adminPanel.add(bt_revFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 800, -1, -1));

        bt_revLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_revLast.png"))); // NOI18N
        bt_revLast.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_revLastMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_revLastMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_revLastMouseExited(evt);
            }
        });
        bg_adminPanel.add(bt_revLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 800, -1, -1));

        bg_adminStructure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bg_adminStructure.png"))); // NOI18N
        bg_adminPanel.add(bg_adminStructure, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 900));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_adminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_adminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_prevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_prevMouseEntered
        bt_prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_prevOver.png")));
    }//GEN-LAST:event_bt_prevMouseEntered

    private void bt_prevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_prevMouseExited
        bt_prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_prev.png")));
    }//GEN-LAST:event_bt_prevMouseExited

    private void bt_pauseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_pauseMouseEntered
        bt_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_pauseOver.png")));
    }//GEN-LAST:event_bt_pauseMouseEntered

    private void bt_pauseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_pauseMouseExited
        bt_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_pause.png")));
    }//GEN-LAST:event_bt_pauseMouseExited

    private void bt_playMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_playMouseEntered
        bt_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_playOver.png")));
    }//GEN-LAST:event_bt_playMouseEntered

    private void bt_playMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_playMouseExited
        bt_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_play.png")));
    }//GEN-LAST:event_bt_playMouseExited

    private void bt_nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nextMouseEntered
        bt_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_nextOver.png")));
    }//GEN-LAST:event_bt_nextMouseEntered

    private void bt_nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nextMouseExited
        bt_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_next.png")));
    }//GEN-LAST:event_bt_nextMouseExited

    private void txt_mNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mNameActionPerformed

    private void txt_mPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mPathActionPerformed

    private void txt_mPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mPicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mPicActionPerformed

    private void bt_addFirstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_addFirstMouseClicked
        String name;
        String path;
        String pic;
        name = txt_mName.getText();
        Music_Name.addFirst(name);
        path = txt_mPath.getText();
        Music_Path.addFirst(path);
        pic = txt_mPic.getText();
        Music_Pic.addFirst(pic);
        lbl_size.setText(Integer.toString(Music_Name.getSize()));
    }//GEN-LAST:event_bt_addFirstMouseClicked

    private void bt_addFirstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_addFirstMouseEntered
        bt_addFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_addFirstOver.png")));
    }//GEN-LAST:event_bt_addFirstMouseEntered

    private void bt_addFirstMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_addFirstMouseExited
        bt_addFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_addFirst.png")));
    }//GEN-LAST:event_bt_addFirstMouseExited

    private void bt_addLastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_addLastMouseClicked
        String name;
        String path;
        String pic;
        name = txt_mName.getText();
        Music_Name.addLast(name);
        path = txt_mPath.getText();
        Music_Path.addLast(path);
        pic = txt_mPic.getText();
        Music_Pic.addLast(pic);
        lbl_size.setText(Integer.toString(Music_Name.getSize()));
    }//GEN-LAST:event_bt_addLastMouseClicked

    private void bt_addLastMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_addLastMouseEntered
        bt_addLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_addLastOver.png")));
    }//GEN-LAST:event_bt_addLastMouseEntered

    private void bt_addLastMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_addLastMouseExited
        bt_addLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_addLast.png")));
    }//GEN-LAST:event_bt_addLastMouseExited

    private void bt_revFirstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_revFirstMouseClicked
        Music_Name.removeFirst();
        Music_Path.removeFirst();
        Music_Pic.removeFirst();
        lbl_size.setText(Integer.toString(Music_Name.getSize()));
    }//GEN-LAST:event_bt_revFirstMouseClicked

    private void bt_revFirstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_revFirstMouseEntered
        bt_revFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_revFirstOver.png")));
    }//GEN-LAST:event_bt_revFirstMouseEntered

    private void bt_revFirstMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_revFirstMouseExited
        bt_revFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_revFirst.png")));
    }//GEN-LAST:event_bt_revFirstMouseExited

    private void bt_revLastMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_revLastMouseClicked
        Music_Name.removeLast();
        Music_Path.removeLast();
        Music_Pic.removeLast();
        lbl_size.setText(Integer.toString(Music_Name.getSize()));
    }//GEN-LAST:event_bt_revLastMouseClicked

    private void bt_revLastMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_revLastMouseEntered
        bt_revLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_revLastOver.png")));
    }//GEN-LAST:event_bt_revLastMouseEntered

    private void bt_revLastMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_revLastMouseExited
        bt_revLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_revLast.png")));
    }//GEN-LAST:event_bt_revLastMouseExited

    private void bt_prevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_prevMouseClicked
        index = index - 1;
        if ((index > 0) && (index <= Music_Name.getSize())) {
            lbl_currentMusic.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            CurrentsongPath = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
        } else {
            index = Music_Name.getSize();
            lbl_currentMusic.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            CurrentsongPath = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
        }
    }//GEN-LAST:event_bt_prevMouseClicked

    private void bt_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nextMouseClicked
        index = index + 1;
        if ((index > 0) && (index <= Music_Name.getSize())) {
            lbl_currentMusic.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            CurrentsongPath = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
        } else {
            index = 1;
            lbl_currentMusic.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            CurrentsongPath = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
        }
    }//GEN-LAST:event_bt_nextMouseClicked

    private void bt_playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_playMouseClicked
        //player.play();
    }//GEN-LAST:event_bt_playMouseClicked

    private void bt_pauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_pauseMouseClicked
        //player.stop();
        //player.pause();
    }//GEN-LAST:event_bt_pauseMouseClicked

    private void bt_pauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_pauseMouseReleased
        switchcount = 1;
        adminPlayer.PauseMusic();
    }//GEN-LAST:event_bt_pauseMouseReleased

    private void bg_adminPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bg_adminPanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_bg_adminPanelMousePressed

    private void bg_adminPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bg_adminPanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_bg_adminPanelMouseDragged

    private void bt_playMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_playMouseReleased
        adminPlayer.StopMusic();
        switchcount = 0;
        adminPlayer.adminPlayMusic(CurrentsongPath);

    }//GEN-LAST:event_bt_playMouseReleased

    private void bt_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_exitMouseEntered
        bt_exit.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_bt_exitMouseEntered

    private void bt_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_exitMouseExited
        bt_exit.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_bt_exitMouseExited

    private void bt_exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_exitMouseReleased
        this.dispose();
    }//GEN-LAST:event_bt_exitMouseReleased

    private void bt_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_backMouseEntered
        bt_back.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_bt_backMouseEntered

    private void bt_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_backMouseExited
        bt_back.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_bt_backMouseExited

    private void bt_backMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_backMouseReleased
        ThMxLoginPanel THMxLoginPanel = new ThMxLoginPanel();
        THMxLoginPanel.setVisible(true);
        THMxLoginPanel.pack();
        THMxLoginPanel.setLocationRelativeTo(null);
        THMxLoginPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_bt_backMouseReleased

    private void bt_resumeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_resumeMouseEntered
        bt_resume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_resumeOver.png")));
    }//GEN-LAST:event_bt_resumeMouseEntered

    private void bt_resumeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_resumeMouseExited
        bt_resume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_resume.png")));
    }//GEN-LAST:event_bt_resumeMouseExited

    private void bt_resumeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_resumeMouseReleased
        switch(switchcount)
        {
            case 0:
                switchcount = 1;
                adminPlayer.PauseMusic();;
                break;
            case 1:
                switchcount = 0;
                adminPlayer.StopMusic();
                adminPlayer.adminResumeMusic();
                break;
        }
    }//GEN-LAST:event_bt_resumeMouseReleased

    private void bt_goUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_goUserMouseEntered
        bt_goUser.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_bt_goUserMouseEntered

    private void bt_goUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_goUserMouseExited
        bt_goUser.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_bt_goUserMouseExited

    private void bt_goUserMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_goUserMouseReleased
        ThMxLoginPanel.idlogin = 0;
        ThMxUser ThMxUser  = new ThMxUser();
        ThMxUser.setVisible(true);
        ThMxUser.pack();
        ThMxUser.setLocationRelativeTo(null);
        ThMxUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_bt_goUserMouseReleased

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThMxAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThMxAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThMxAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThMxAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThMxAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg_adminPanel;
    private javax.swing.JLabel bg_adminStructure;
    private javax.swing.JLabel bg_formMusic;
    private javax.swing.JPanel bg_mPic;
    private javax.swing.JLabel bt_addFirst;
    private javax.swing.JLabel bt_addLast;
    private javax.swing.JLabel bt_back;
    private javax.swing.JLabel bt_exit;
    private javax.swing.JLabel bt_goUser;
    private javax.swing.JLabel bt_next;
    private javax.swing.JLabel bt_pause;
    private javax.swing.JLabel bt_play;
    private javax.swing.JLabel bt_prev;
    private javax.swing.JLabel bt_resume;
    private javax.swing.JLabel bt_revFirst;
    private javax.swing.JLabel bt_revLast;
    private javax.swing.JLabel lbl_currentMusic;
    private javax.swing.JLabel lbl_currentindex;
    private javax.swing.JLabel lbl_mPic;
    private javax.swing.JLabel lbl_of;
    private javax.swing.JLabel lbl_size;
    private javax.swing.JTextField txt_mName;
    private javax.swing.JTextField txt_mPath;
    private javax.swing.JTextField txt_mPic;
    // End of variables declaration//GEN-END:variables
}
