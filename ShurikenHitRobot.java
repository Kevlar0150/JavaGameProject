/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * CollisionListener for when ShurikenHitsRobot
 * @author Kevin LA
 */
public class ShurikenHitRobot implements CollisionListener {
   
    
    private EnemyRobot robot;
    private SoundClip hitRobot;

    /**
     * Constructor for ShurikenHitRobot
     * @param robot The enemy robot
     */
    public ShurikenHitRobot(EnemyRobot robot){
        this.robot = robot;  
    }
    /**
     * Collide method for when shuriken collides with instance of Robot
     * @param e the sensor
     */
    @Override
    public void collide(CollisionEvent e) 
    {
        //If shurikenBody touches EnemyRobot
        if(e.getOtherBody() instanceof Shuriken) { //If the body is an instance shuriken
            if(e.getReportingBody() instanceof EnemyRobot)//If the reporting body (Shuriken) touches 
                                                          // an instance of EnemyRobot
            {
            e.getOtherBody().destroy();//Destroys the shuriken
            robot.decreaseRobotHealth();//Call decreaseRobotHealth function *See EnemyRobot class
            robot.robotDie(); //Call RobotDie function *See EnemyRobot class
             try {
            hitRobot= new SoundClip("data/hitRobot.mp3");   // Open an audio input stream
            hitRobot.play();
        } 
                catch (UnsupportedAudioFileException|IOException|LineUnavailableException c) {
            System.out.println(c);
        }  
            }
         }
        }
    }

            
       