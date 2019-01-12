package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class PortalListener implements CollisionListener {
    private Game game;
    private SoundClip nextLevel;
    /**
     * Constructor for PortalListener
     * @param game The game
     */
    public PortalListener(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Strider player = game.getPlayer();
        boolean levelDone = game.isCurrentLevelCompleted();
        System.out.println(levelDone);
        if (e.getOtherBody() == player && levelDone) {
            System.out.println("Going to next level...");
            try {
            nextLevel= new SoundClip("data/NextLevel.mp3");   // Open an audio input stream
            nextLevel.play();
        } 
                catch (UnsupportedAudioFileException|IOException|LineUnavailableException c) {
            System.out.println(c);
        }  
            game.goNextLevel();
            
        }
    }
}
