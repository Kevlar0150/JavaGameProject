package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author Kevin LA
 */

/**
 * Class for BossGetHit. This is for when the boss collides with
 * player projectile
 */
public class BossGetHit implements CollisionListener {

    private Boss boss;
    private SoundClip hitBoss;
    /**
     * Constructor to initialise    
     * @param boss The boss
     */
    public BossGetHit(Boss boss) {
        this.boss = boss;
    }
    
    /**
     * Collision method for when an object of class Shuriken
     * collides with an Object of Boss.
     * @param e The OtherBody
     */
    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof Shuriken) {
            if(e.getReportingBody() instanceof Boss) {
            boss.reduceHealthPoints();
            boss.bossIsDead();
            e.getOtherBody().destroy();
             try {
            hitBoss= new SoundClip("data/hitRobot.mp3");   // Open an audio input stream
            hitBoss.play();
        } 
                catch (UnsupportedAudioFileException|IOException|LineUnavailableException c) {
            System.out.println(c);
        }  
            } 
        } 
    }
}