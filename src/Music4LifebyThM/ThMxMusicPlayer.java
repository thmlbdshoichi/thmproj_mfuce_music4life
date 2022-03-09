package Music4LifebyThM;
//Shoichi | ThM Empire | 6131501066
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class ThMxMusicPlayer {
    
    //FileInputStream FIS;
    //BufferedInputStream BIS;
    private InputStream IS;
    public static Player player;
    public long pauseLocation;
    public long songTotalLength;
    public String fileLocation;
    private String musicFilePath;
    ThMxUser ThMxUser;
    
    public void StopMusic()
    {
        if(player != null)
        {
            player.close();
            /*pauseLocation = 0;
            songTotalLength = 0;*/
        }
    }
    
    public void PauseMusic()
    {
        if(player != null)
        {
            try {
                pauseLocation = IS.available();
                player.close();
            } 
            catch (IOException ex) 
            {
            
            }
        }
    }
    
    public void PlayMusic(String path)
    {
        try 
        {
            this.musicFilePath = path;
            IS = this.getClass().getResourceAsStream(path);
            //FIS = new FileInputStream(path);
            //BIS = new BufferedInputStream(FIS);
            player = new Player(IS);
            songTotalLength = IS.available();
            fileLocation = this.getClass().getResourceAsStream(path)+"";
        } 
        catch (FileNotFoundException | JavaLayerException ex) 
        {
            
        } 
        catch (IOException ex) 
        {
            //Logger.getLogger(ThMxMusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread()
        {
            @Override
            public void run()
            {
                try 
                {
                    player.play();
                    if(player.isComplete() && ThMxUser.switchloop == 1)
                    {
                        PlayMusic(musicFilePath);
                    }
                    else if(player.isComplete())
                    {
                        ThMxUser.songDequeue();
                    }
                } 
                catch (JavaLayerException ex) 
                {
                
                }
            }

            private void Play(String fileLocation) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }.start();
    }
    
    public void adminPlayMusic(String path)
    {
        try 
        {
            this.musicFilePath = path;
            IS = this.getClass().getResourceAsStream(path);
            //FIS = new FileInputStream(path);
            //BIS = new BufferedInputStream(FIS);
            player = new Player(IS);
            songTotalLength = IS.available();
            fileLocation = this.getClass().getResourceAsStream(path)+"";
        } 
        catch (FileNotFoundException | JavaLayerException ex) 
        {
            
        } 
        catch (IOException ex) 
        {
            //Logger.getLogger(ThMxMusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread()
        {
            @Override
            public void run()
            {
                try 
                {
                    player.play();
                } 
                catch (JavaLayerException ex) 
                {
                
                }
            }

            private void Play(String fileLocation) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }.start();
    }
    
    public void ResumeMusic()
    {
        try 
        {
            IS = this.getClass().getResourceAsStream( musicFilePath );
            IS.skip(songTotalLength - pauseLocation);
            player = new Player(IS);
        } 
        catch (FileNotFoundException | JavaLayerException ex) 
        {
            
        } 
        catch (IOException ex) 
        {
            //Logger.getLogger(ThMxMusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread()
        {
            @Override
            public void run()
            {
                try 
                {
                    player.play();
                    if(player.isComplete() && ThMxUser.switchloop == 1)
                    {
                        PlayMusic(musicFilePath);
                    }
                    else if(player.isComplete())
                    {
                        ThMxUser.songDequeue();
                    }
                } 
                catch (JavaLayerException ex) 
                {
                
                }
            }
        }.start();
    }
    
    public void adminResumeMusic()
    {
        try 
        {
            IS = this.getClass().getResourceAsStream( musicFilePath );
            IS.skip(songTotalLength - pauseLocation);
            player = new Player(IS);
        } 
        catch (FileNotFoundException | JavaLayerException ex) 
        {
            
        } 
        catch (IOException ex) 
        {
            //Logger.getLogger(ThMxMusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread()
        {
            @Override
            public void run()
            {
                try 
                {
                    player.play();
                } 
                catch (JavaLayerException ex) 
                {
                
                }
            }
        }.start();
    }
    
    public boolean statusMusic()
    {
        return player.isComplete();
    }
    
    
}
