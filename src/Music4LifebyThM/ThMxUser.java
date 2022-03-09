package Music4LifebyThM;
//Shoichi | The Emperor of ThM Empire | ID : 6131501066
//Copyright claim | For Educational Purposes Only

import static Music4LifebyThM.ThMxAdmin.Music_Name;
import static Music4LifebyThM.ThMxAdmin.Music_Path;
import static Music4LifebyThM.ThMxAdmin.Music_Pic;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author Shoichi
 */
class ThMxUser extends javax.swing.JFrame {

    static int xMouse,yMouse;
    int index;
    int permission_id;
    int switchcount;
    static int switchloop;
    int numQueueinTable = 0;
    ThMxAdmin SongLibrary = new ThMxAdmin();
    static ThMxMusicPlayer userPlayer = new ThMxMusicPlayer();
    static QueueArray QName = new QueueArray();
    static QueueArray QPath = new QueueArray();
    String QSong, QPathSong;
    
    public ThMxUser() {
        this.setUndecorated(true);
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        bg_userPanel.setBackground(new Color(0,0,0,0));
        callNextMusic();
        ThMxLoginPanel ThMxLogin = new ThMxLoginPanel();
        if(ThMxLogin.idlogin == 0)
        {
            lbl_account.setText("Administrator");
            lbl_account.setForeground(new java.awt.Color(119, 221, 119));
            permission_id = 999;
        }
        else if(ThMxLogin.idlogin == 1)
        {
            lbl_account.setText("GUEST");
            lbl_account.setForeground(new java.awt.Color(0, 0, 0));
            permission_id = 0;
        }
        else if(ThMxLogin.idlogin == 2)
        {
            lbl_account.setText("Shoichi");
            lbl_account.setForeground(new java.awt.Color(251, 204, 209));
            permission_id = 1;
        }
        else if(ThMxLogin.idlogin == 3)
        {
            lbl_account.setText("HOBO");
            lbl_account.setForeground(new java.awt.Color(119, 158, 203));
            permission_id = 1;
        }
        else
        {
            lbl_account.setText("GUEST");
            lbl_account.setForeground(new java.awt.Color(0, 0, 0));
            permission_id = 0;
        }
    }

    private void callPrevMusic(){
        index = index - 1;
        if ((index > 0) && (index <= Music_Name.getSize())) {
            lbl_currentList.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            QPathSong = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
            QSong = Music_Name.getElementByIndex(index);
        } else {
            index = Music_Name.getSize();
            lbl_currentList.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            QPathSong = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
            QSong = Music_Name.getElementByIndex(index);
        }
    }                
    
    private void callNextMusic(){
        index = index + 1;
        if ((index > 0) && (index <= Music_Name.getSize())) {
            lbl_currentList.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            QPathSong = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
            QSong = Music_Name.getElementByIndex(index);
        } else {
            index = 1;
            lbl_currentList.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            QPathSong = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
            QSong = Music_Name.getElementByIndex(index);
        }  
    }
    
    public static void songDequeue(){
        DefaultTableModel model = (DefaultTableModel) QueueSongTable.getModel();
        userPlayer.StopMusic();
        QName.dequeue();
        QPath.dequeue();

        lbl_numQC.setText(Integer.toString(QName.getCapacity()));
        lbl_numSongInQ.setText(Integer.toString(QName.getSize()));
        if (!QName.isEmpty()) {
            userPlayer.PlayMusic(QPath.peek());
            lbl_peek.setText(QName.peek());
        }
        if (QName.getSize() != 0) {
            model.setRowCount(0);
            for (int i = QName.front; i < (QName.front + QName.size); i++) {
                model.addRow(new Object[]{String.valueOf(QName.data[i % QName.data.length]), String.valueOf(QPath.data[i % QPath.data.length])});
            }
        }
        if (QName.isEmpty()) {
            model.setRowCount(0);
            lbl_peek.setText("Playlist (Queue) is Empty");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_userPanel = new javax.swing.JPanel();
        bt_goAdmin = new javax.swing.JLabel();
        lbl_numSongInQ = new javax.swing.JLabel();
        lbl_songInQ = new javax.swing.JLabel();
        lbl_numQC = new javax.swing.JLabel();
        lbl_QueueCapacity = new javax.swing.JLabel();
        lbl_peek = new javax.swing.JLabel();
        lbl_currentList = new javax.swing.JLabel();
        bt_prev = new javax.swing.JLabel();
        lbl_loopDetected = new javax.swing.JLabel();
        lblt_loopDetected = new javax.swing.JLabel();
        bt_loop = new javax.swing.JLabel();
        bt_play = new javax.swing.JLabel();
        bt_resume = new javax.swing.JLabel();
        bt_volumeUP = new javax.swing.JLabel();
        bt_volumeDOWN = new javax.swing.JLabel();
        bt_next = new javax.swing.JLabel();
        bt_enqueue = new javax.swing.JLabel();
        bt_dequeue = new javax.swing.JLabel();
        lbl_currentindex = new javax.swing.JLabel();
        lbl_beforeOf = new javax.swing.JLabel();
        lbl_of = new javax.swing.JLabel();
        lbl_size = new javax.swing.JLabel();
        bt_back = new javax.swing.JLabel();
        bt_exit = new javax.swing.JLabel();
        lbl_account = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        QueueSongTable = new javax.swing.JTable();
        lbl_mPic = new javax.swing.JLabel();
        bg_userStructure = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg_userPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bg_userPanelMouseDragged(evt);
            }
        });
        bg_userPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bg_userPanelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bg_userPanelMousePressed(evt);
            }
        });
        bg_userPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_goAdmin.setFont(new java.awt.Font("TH Baijam", 1, 24)); // NOI18N
        bt_goAdmin.setText("System Control");
        bt_goAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_goAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_goAdminMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt_goAdminMouseReleased(evt);
            }
        });
        bg_userPanel.add(bt_goAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        lbl_numSongInQ.setFont(new java.awt.Font("TH Baijam", 0, 24)); // NOI18N
        lbl_numSongInQ.setText("0");
        bg_userPanel.add(lbl_numSongInQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 580, 50, -1));

        lbl_songInQ.setFont(new java.awt.Font("TH Baijam", 0, 24)); // NOI18N
        lbl_songInQ.setText("Numbers of Song in Queue : ");
        bg_userPanel.add(lbl_songInQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        lbl_numQC.setFont(new java.awt.Font("TH Baijam", 0, 24)); // NOI18N
        lbl_numQC.setText("0");
        bg_userPanel.add(lbl_numQC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 60, -1));

        lbl_QueueCapacity.setFont(new java.awt.Font("TH Baijam", 0, 24)); // NOI18N
        lbl_QueueCapacity.setText("Queue Capacity : ");
        bg_userPanel.add(lbl_QueueCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, -1, -1));

        lbl_peek.setFont(new java.awt.Font("Great Attraction", 0, 36)); // NOI18N
        lbl_peek.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_peek.setText("Queue is Empty");
        bg_userPanel.add(lbl_peek, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 490, 540, -1));

        lbl_currentList.setFont(new java.awt.Font("TH Chakra Petch", 0, 30)); // NOI18N
        lbl_currentList.setText("Arashi - Love so Sweet");
        bg_userPanel.add(lbl_currentList, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 470, 30));

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
        bg_userPanel.add(bt_prev, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        lbl_loopDetected.setFont(new java.awt.Font("TH Chakra Petch", 1, 24)); // NOI18N
        lbl_loopDetected.setText("Off");
        bg_userPanel.add(lbl_loopDetected, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 590, -1, -1));

        lblt_loopDetected.setFont(new java.awt.Font("TH Chakra Petch", 1, 24)); // NOI18N
        lblt_loopDetected.setText("Loop:");
        bg_userPanel.add(lblt_loopDetected, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 590, -1, -1));

        bt_loop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_loop.png"))); // NOI18N
        bt_loop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_loopMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_loopMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_loopMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bt_loopMouseReleased(evt);
            }
        });
        bg_userPanel.add(bt_loop, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

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
        bg_userPanel.add(bt_play, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, -1));

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
        bg_userPanel.add(bt_resume, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));

        bt_volumeUP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_soundup.png"))); // NOI18N
        bt_volumeUP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_volumeUPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_volumeUPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_volumeUPMouseExited(evt);
            }
        });
        bg_userPanel.add(bt_volumeUP, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, -1, -1));

        bt_volumeDOWN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_sounddown.png"))); // NOI18N
        bt_volumeDOWN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_volumeDOWNMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_volumeDOWNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_volumeDOWNMouseExited(evt);
            }
        });
        bg_userPanel.add(bt_volumeDOWN, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, -1, -1));

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
        bg_userPanel.add(bt_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, -1, -1));

        bt_enqueue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_enqueue.png"))); // NOI18N
        bt_enqueue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_enqueueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_enqueueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_enqueueMouseExited(evt);
            }
        });
        bg_userPanel.add(bt_enqueue, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        bt_dequeue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_dequeue.png"))); // NOI18N
        bt_dequeue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_dequeueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_dequeueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_dequeueMouseExited(evt);
            }
        });
        bg_userPanel.add(bt_dequeue, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, -1, -1));

        lbl_currentindex.setFont(new java.awt.Font("TH Baijam", 1, 24)); // NOI18N
        lbl_currentindex.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_currentindex.setText("0");
        bg_userPanel.add(lbl_currentindex, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 30, -1));

        lbl_beforeOf.setFont(new java.awt.Font("TH Baijam", 1, 24)); // NOI18N
        lbl_beforeOf.setText("Song in Library: ");
        bg_userPanel.add(lbl_beforeOf, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 140, -1));

        lbl_of.setFont(new java.awt.Font("TH Baijam", 1, 24)); // NOI18N
        lbl_of.setText("Of");
        bg_userPanel.add(lbl_of, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 20, -1));

        lbl_size.setFont(new java.awt.Font("TH Baijam", 1, 24)); // NOI18N
        lbl_size.setText("0");
        bg_userPanel.add(lbl_size, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 40, -1));

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
        bg_userPanel.add(bt_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

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
        bg_userPanel.add(bt_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, -1));

        lbl_account.setFont(new java.awt.Font("TH Baijam", 1, 24)); // NOI18N
        lbl_account.setForeground(new java.awt.Color(51, 153, 0));
        lbl_account.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_account.setText("None");
        bg_userPanel.add(lbl_account, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 220, -1));

        QueueSongTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Artist - Name", "[Song] Path"
            }
        ));
        jScrollPane1.setViewportView(QueueSongTable);

        bg_userPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, 460, 320));

        lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/AlreadyDead.png"))); // NOI18N
        bg_userPanel.add(lbl_mPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 230, -1));

        bg_userStructure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/userStructure.png"))); // NOI18N
        bg_userPanel.add(bg_userStructure, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg_userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bg_userPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bg_userPanelMouseClicked

    }//GEN-LAST:event_bg_userPanelMouseClicked

    private void bg_userPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bg_userPanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_bg_userPanelMouseDragged

    private void bg_userPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bg_userPanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_bg_userPanelMousePressed

    private void bt_prevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_prevMouseClicked
        index = index - 1;
        if ((index > 0) && (index <= Music_Name.getSize())) {
            lbl_currentList.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            QPathSong = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
            QSong = Music_Name.getElementByIndex(index);
        } else {
            index = Music_Name.getSize();
            lbl_currentList.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            QPathSong = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
            QSong = Music_Name.getElementByIndex(index);
        }
    }//GEN-LAST:event_bt_prevMouseClicked

    private void bt_prevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_prevMouseEntered
        bt_prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_prevOver.png")));
    }//GEN-LAST:event_bt_prevMouseEntered

    private void bt_prevMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_prevMouseExited
        bt_prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_prev.png")));
    }//GEN-LAST:event_bt_prevMouseExited

    private void bt_loopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_loopMouseClicked

    }//GEN-LAST:event_bt_loopMouseClicked

    private void bt_loopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_loopMouseEntered
        bt_loop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_loopOver.png")));
    }//GEN-LAST:event_bt_loopMouseEntered

    private void bt_loopMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_loopMouseExited
        bt_loop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_loop.png")));
    }//GEN-LAST:event_bt_loopMouseExited

    private void bt_loopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_loopMouseReleased
        if(permission_id >= 1)
        {
            switch(switchloop)
            {
                case 0:
                    switchloop = 1;
                    System.out.println(switchloop+" -> Loop on");
                    lbl_loopDetected.setText("On");
                    lbl_loopDetected.setForeground(new Color(255, 0, 0));
                    break;
                case 1:
                    switchloop = 0;
                    System.out.println(switchloop+" -> Loop off");
                    lbl_loopDetected.setText("Off");
                    lbl_loopDetected.setForeground(new Color(0, 0, 0));
                    break;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Error: You're don't have permission to perform this action, Please Login first","Error : Unregistered account",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bt_loopMouseReleased

    private void bt_playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_playMouseClicked
        
    }//GEN-LAST:event_bt_playMouseClicked

    private void bt_playMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_playMouseEntered
        bt_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_playOver.png")));
    }//GEN-LAST:event_bt_playMouseEntered

    private void bt_playMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_playMouseExited
        bt_play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_play.png")));
    }//GEN-LAST:event_bt_playMouseExited

    private void bt_playMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_playMouseReleased
        userPlayer.StopMusic();
        switchcount = 0;
        if(!QName.isEmpty()){
          userPlayer.PlayMusic(QPath.peek());  
        }
        else{
            JOptionPane.showMessageDialog(this,"Error: Please enqueue song","Error: Empty Queue",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bt_playMouseReleased

    private void bt_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nextMouseClicked
         index = index + 1;
        if ((index > 0) && (index <= Music_Name.getSize())) {
            lbl_currentList.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            QPathSong = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
            QSong = Music_Name.getElementByIndex(index);
        } else {
            index = 1;
            lbl_currentList.setText(Music_Name.getElementByIndex(index));
            lbl_currentindex.setText(Integer.toString(index));
            lbl_size.setText(Integer.toString(Music_Name.getSize()));
            lbl_mPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/AlbumCover/"+Music_Pic.getElementByIndex(index))));
            QPathSong = "/Music4LifeByThM/Music/"+Music_Path.getElementByIndex(index);
            QSong = Music_Name.getElementByIndex(index);
        }
    }//GEN-LAST:event_bt_nextMouseClicked

    private void bt_nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nextMouseEntered
        bt_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_nextOver.png")));
    }//GEN-LAST:event_bt_nextMouseEntered

    private void bt_nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nextMouseExited
        bt_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_next.png")));
    }//GEN-LAST:event_bt_nextMouseExited

    private void bt_resumeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_resumeMouseEntered
        bt_resume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_resumeOver.png")));
    }//GEN-LAST:event_bt_resumeMouseEntered

    private void bt_resumeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_resumeMouseExited
        bt_resume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_resume.png")));
    }//GEN-LAST:event_bt_resumeMouseExited

    private void bt_volumeUPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_volumeUPMouseEntered
        bt_volumeUP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_soundupOver.png")));
    }//GEN-LAST:event_bt_volumeUPMouseEntered

    private void bt_volumeUPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_volumeUPMouseExited
        bt_volumeUP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_soundup.png")));
    }//GEN-LAST:event_bt_volumeUPMouseExited

    private void bt_volumeDOWNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_volumeDOWNMouseEntered
        bt_volumeDOWN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_sounddownOver.png")));
    }//GEN-LAST:event_bt_volumeDOWNMouseEntered

    private void bt_volumeDOWNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_volumeDOWNMouseExited
        bt_volumeDOWN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_sounddown.png")));
    }//GEN-LAST:event_bt_volumeDOWNMouseExited

    private void bt_enqueueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_enqueueMouseEntered
        bt_enqueue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_enqueueOver.png")));
    }//GEN-LAST:event_bt_enqueueMouseEntered

    private void bt_enqueueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_enqueueMouseExited
        bt_enqueue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_enqueue.png")));
    }//GEN-LAST:event_bt_enqueueMouseExited

    private void bt_dequeueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_dequeueMouseEntered
        bt_dequeue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_dequeueOver.png")));
    }//GEN-LAST:event_bt_dequeueMouseEntered

    private void bt_dequeueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_dequeueMouseExited
        bt_dequeue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music4LifebyThM/images/UI/bt_dequeue.png")));
    }//GEN-LAST:event_bt_dequeueMouseExited

    private void bt_volumeUPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_volumeUPMouseClicked
        volumeUpControl(0.1);
    }//GEN-LAST:event_bt_volumeUPMouseClicked

    private void bt_volumeDOWNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_volumeDOWNMouseClicked
        volumeDownControl(0.1);
    }//GEN-LAST:event_bt_volumeDOWNMouseClicked

    private void bt_enqueueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_enqueueMouseClicked
        DefaultTableModel model = (DefaultTableModel) QueueSongTable.getModel();
        String SongName = QSong;
        String SongPath = QPathSong;
        
        if(permission_id >= 1)
        {
        QName.enqueue(QSong);
        QPath.enqueue(QPathSong);
        
        for(int i = numQueueinTable; i<= numQueueinTable; i++)
        {
            model.addRow(new Object[]{String.valueOf(SongName),String.valueOf(SongPath)});
        }
        numQueueinTable++;
        
        lbl_numQC.setText(Integer.toString(QName.getCapacity()));
        lbl_numSongInQ.setText(Integer.toString(QName.getSize()));
        lbl_peek.setText(QName.peek());
        }
        else
        {
            System.out.println("Error : You don't have permission to perform this action, Please Login");
            JOptionPane.showMessageDialog(this,"Error: You're don't have permission to perform this action, Please Login first","Error : Unregistered account",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bt_enqueueMouseClicked

    private void bt_dequeueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_dequeueMouseClicked
        DefaultTableModel model = (DefaultTableModel) QueueSongTable.getModel();
        switchcount = 0;
        if(permission_id >= 1)
        {
            userPlayer.StopMusic();
            QName.dequeue();
            QPath.dequeue();
            
            lbl_numQC.setText(Integer.toString(QName.getCapacity()));
            lbl_numSongInQ.setText(Integer.toString(QName.getSize()));
            if(!QName.isEmpty())
            {
            userPlayer.PlayMusic(QPath.peek());
            lbl_peek.setText(QName.peek()); 
            }
            if(QName.getSize() != 0)
            {
                model.setRowCount(0);
                for (int i = QName.front; i < (QName.front+QName.size); i++)
                {
                    model.addRow(new Object[]{String.valueOf(QName.data[i%QName.data.length]),String.valueOf(QPath.data[i%QPath.data.length])});
                }      
            }
            if(QName.isEmpty())
            {
                model.setRowCount(0);
                lbl_peek.setText("Playlist (Queue) is Empty");
            }
        }
        else
        {
            System.out.println("Error : You don't have permission to perform this action, Please Login");
            JOptionPane.showMessageDialog(this,"Error: You're don't have permission to perform this action, Please Login first","Error : Unregistered account",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_bt_dequeueMouseClicked
 
    private void bt_resumeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_resumeMouseReleased
        switch(switchcount)
        {
            case 0:
                switchcount = 1;
                userPlayer.PauseMusic();;
                break;
            case 1:
                switchcount = 0;
                userPlayer.StopMusic();
                if(!QName.isEmpty())
                {
                    userPlayer.ResumeMusic();
                }
                else{
                    JOptionPane.showMessageDialog(this,"Error: Please enqueue song","Error: Empty Queue",JOptionPane.WARNING_MESSAGE);
                }
                break;
        }
    }//GEN-LAST:event_bt_resumeMouseReleased

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

    private void bt_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_exitMouseEntered
        bt_exit.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_bt_exitMouseEntered

    private void bt_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_exitMouseExited
        bt_exit.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_bt_exitMouseExited

    private void bt_exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_exitMouseReleased
        this.dispose();
    }//GEN-LAST:event_bt_exitMouseReleased

    private void bt_goAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_goAdminMouseEntered
        bt_goAdmin.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_bt_goAdminMouseEntered

    private void bt_goAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_goAdminMouseExited
        bt_goAdmin.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_bt_goAdminMouseExited

    private void bt_goAdminMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_goAdminMouseReleased
        if (permission_id == 999)
        {
           ThMxAdmin ThMxAdmin = new ThMxAdmin();
           ThMxAdmin.setVisible(true);
           ThMxAdmin.pack();
           ThMxAdmin.setLocationRelativeTo(null);
           ThMxAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Error: You're not administrator.","Error: Permission restrict",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bt_goAdminMouseReleased

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
            java.util.logging.Logger.getLogger(ThMxUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThMxUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThMxUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThMxUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThMxUser().setVisible(true);
            }
        });
    }
    
    private void volumeDownControl(Double valueToPlusMinus)
    {
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        //for(Mixer.Info mixerInfo : mixers)
        //{
            Mixer mixer = AudioSystem.getMixer(mixers[0]);
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            for(Line.Info lineInfo : lineInfos)
            {
                Line line = null;
                boolean opened = true;
                try
                {
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    if(!opened)
                    {
                        line.open();
                    }
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volControl.getValue();
                    Double volumeToCut = valueToPlusMinus;
                    float changedCalc = (float) ((float)currentVolume-(double)volumeToCut);
                    volControl.setValue(changedCalc); 
                }
                catch (LineUnavailableException lineException)
                {
                }
                catch (IllegalArgumentException illException)
                {   
                }
                finally
                {
                    if(line != null && !opened)
                    {
                        line.close();  
                    }
                }
                
            }
            
        //}
    }
    
    private void volumeUpControl(Double valueToPlusMinus)
    {
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        //for(Mixer.Info mixerInfo : mixers)
        //{
            Mixer mixer = AudioSystem.getMixer(mixers[0]);//mixerInfo
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            for(Line.Info lineInfo : lineInfos)
            {
                Line line = null;
                boolean opened = true;
                try
                {
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    if(!opened){
                        line.open();
                    }
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volControl.getValue();
                    Double volumeToCut = valueToPlusMinus;
                    float changedCalc = (float) ((float)currentVolume+(double)volumeToCut);
                    volControl.setValue(changedCalc);  
                }
                catch (LineUnavailableException lineException)
                {
                }
                catch (IllegalArgumentException illException)
                {   
                }
                finally
                {
                    if(line != null && !opened)
                    {
                        line.close();  
                    }
                }
                
            }
            
        //}
    }
    
    private void volumeControl(Double valueToPlusMinus)
    {
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        //for(Mixer.Info mixerInfo : mixers)
        //{
            Mixer mixer = AudioSystem.getMixer(mixers[0]);
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            for(Line.Info lineInfo : lineInfos)
            {
                Line line = null;
                boolean opened = true;
                try
                {
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    if(!opened){
                        line.open();
                    }
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    float currentVolume = volControl.getValue();
                    Double volumeToCut = valueToPlusMinus;
                    float changedCalc = (float) ((double)volumeToCut);
                    volControl.setValue(changedCalc);  
                }
                catch (LineUnavailableException lineException)
                {
                }
                catch (IllegalArgumentException illException)
                {   
                }
                finally
                {
                    if(line != null && !opened)
                    {
                        line.close();  
                    }
                }
                
            }
            
        //}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable QueueSongTable;
    private javax.swing.JPanel bg_userPanel;
    private javax.swing.JLabel bg_userStructure;
    private javax.swing.JLabel bt_back;
    private javax.swing.JLabel bt_dequeue;
    private javax.swing.JLabel bt_enqueue;
    private javax.swing.JLabel bt_exit;
    private javax.swing.JLabel bt_goAdmin;
    private javax.swing.JLabel bt_loop;
    private javax.swing.JLabel bt_next;
    private javax.swing.JLabel bt_play;
    private javax.swing.JLabel bt_prev;
    private javax.swing.JLabel bt_resume;
    private javax.swing.JLabel bt_volumeDOWN;
    private javax.swing.JLabel bt_volumeUP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_QueueCapacity;
    private javax.swing.JLabel lbl_account;
    private javax.swing.JLabel lbl_beforeOf;
    private javax.swing.JLabel lbl_currentList;
    private javax.swing.JLabel lbl_currentindex;
    private javax.swing.JLabel lbl_loopDetected;
    private javax.swing.JLabel lbl_mPic;
    private static javax.swing.JLabel lbl_numQC;
    private static javax.swing.JLabel lbl_numSongInQ;
    private javax.swing.JLabel lbl_of;
    private static javax.swing.JLabel lbl_peek;
    private javax.swing.JLabel lbl_size;
    private javax.swing.JLabel lbl_songInQ;
    private javax.swing.JLabel lblt_loopDetected;
    // End of variables declaration//GEN-END:variables
}

