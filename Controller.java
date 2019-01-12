package game;

import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.SoundClip;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * @author Kevin LA
 */

/**
 * Controller to handle the player character (Strider)
 */
public class Controller extends KeyAdapter {
    private Strider body;
    private EnemyRobot robotBody;
    private Shuriken shuriken;
    private WorldView view;
    private SoundClip shurikenThrow;
    
    boolean faceRight = true;
     
    /**
     * Constructor to initialise the controller
     * @param body The player character
     * @param view The game view
     */
    public Controller(Strider body,WorldView view) {
        this.body = body;
        this.view = view;
    }
    /**
     * Method for when key is pressed
     * @param e The key pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_B && body.jumpAmount > 0) //If B and jumpAmount is more than
                                                          // 0 then jump
        { // B = jump
            Vec2 v = body.getLinearVelocity();
            
                body.applyImpulse(new Vec2(0,3.5f));
                body.jumpAmount--; //Decrease jump count when player has jumped
                                    // Used for double jump
                                    
                if(faceRight == true)
            {
             body.removeAllImages();
                body.addImage(Strider.getJumpRight());
            }
            else if(faceRight == false)
            {
            body.removeAllImages();
                body.addImage(Strider.getJumpLeft());
            }
                
                // Debug System.out.println(body.jumpAmount);               
        }
        if (code == KeyEvent.VK_A) {
            body.moveLeft = true; // 1 = walk left using boolean "moveLeft" Make true
            body.removeAllImages();
            body.addImage(Strider.getWalkLeft());
            faceRight = false;
        } else if (code == KeyEvent.VK_D) {
            body.moveRight = true; // 2 = walk right using boolean "moveRight" Make true
            body.removeAllImages();
            body.addImage(Strider.getWalkRight());
            faceRight = true;
            
        } 
        else if (code == KeyEvent.VK_K)
        {
            if(body.numOfShuriken > 0)
            {
                if(faceRight == true)
                {
                    if(body.stamina >= 20)
                    {
                      body.removeAllImages();
                body.addImage(Strider.getThrowRight());
                shuriken = new Shuriken(view.getWorld());
                shuriken.applyImpulse(new Vec2(50,0));
                shuriken.setPosition(new Vec2(body.getPosition())); 
                body.numOfShuriken--;
                body.decreaseStaminaCount();
               /* try {
            shurikenThrow= new SoundClip("data/throwShuriken.mp3");   // Open an audio input stream
            shurikenThrow.play();
        } 
                catch (UnsupportedAudioFileException|IOException|LineUnavailableException c) {
            System.out.println(c);
        }  */
                    }
                }
                else if (faceRight == false)
                {
                    if(body.stamina >= 20)
                    {
                     body.removeAllImages();
                body.addImage(Strider.getThrowLeft());
                shuriken = new Shuriken(view.getWorld());
                shuriken.applyImpulse(new Vec2(-50,0));
                shuriken.setPosition(new Vec2(body.getPosition()));  
                body.numOfShuriken--;
                body.decreaseStaminaCount();
              /*  try {
            shurikenThrow= new SoundClip("data/throwShuriken.mp3");   // Open an audio input stream
            shurikenThrow.play();
        } 
                catch (UnsupportedAudioFileException|IOException|LineUnavailableException c) {
            System.out.println(c);
        }  */
                    }
               
                }
            }
        }
               
    }
    
    /**
     * Method for when key is released
     * a@param e The key released
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.moveLeft = false; // Make boolean false when key is released
            if (body.getLinearVelocity().y != 0)
            {
                body.setLinearVelocity(new Vec2(0, body.getLinearVelocity().y));             
            }
            body.removeAllImages();
            body.addImage(Strider.getIdleLeft());
            body.faceRight = false;
        } else if (code == KeyEvent.VK_D) {
            body.moveRight = false; // Make boolean false when key is released
            if (body.getLinearVelocity().y != 0)
            {
                body.setLinearVelocity(new Vec2(0, body.getLinearVelocity().y));
            }
             body.removeAllImages();
                body.addImage(Strider.getIdleRight());
                body.faceRight = true;
        }
        else if (code == KeyEvent.VK_S) {
            
                if(faceRight == true)
            {
             body.removeAllImages();
                body.addImage(Strider.getIdleRight());
            }
            else if(faceRight == false)
            {
            body.removeAllImages();
                body.addImage(Strider.getIdleLeft());
            }
        }
        else if (code == KeyEvent.VK_K) {
            if(faceRight == true)
            {
             body.removeAllImages();
                body.addImage(Strider.getIdleRight());
            }
            else if(faceRight == false)
            {
            body.removeAllImages();
                body.addImage(Strider.getIdleLeft());
            }
        }
        if(code == KeyEvent.VK_W)
        {
          body.climbUp=false;
        }
    }
    public void setBody(Strider body) {
        this.body = body;
    }
}

