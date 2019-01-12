/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;

/**
 *
 * @author Kevin LA
 */

/**
 * Class used for AI movement
 */
public class EnemyRobotTouchStaticBody implements CollisionListener{
     private EnemyRobot robot;
     private int rSpeed1, rSpeed2;
     private int lSpeed1, lSpeed2;
     private SecurityCamera camera;
     private boolean walkRight = true;
     /**
      * Constructor that initialises EnemyRobotTouchStaticBody
      * @param robot The enemy robot
      * @param camera The security camera
      */
    public EnemyRobotTouchStaticBody(EnemyRobot robot,SecurityCamera camera)
    {
        this.robot = robot;
        this.camera = camera;
    }
    
    /**
     * Method that allows robot to change direction when
     * colliding with static body.
     * @param b The enemyrobot body
     */
    @Override
    public void collide(CollisionEvent b) {
        
        if(b.getOtherBody() instanceof StaticBody || b.getOtherBody() instanceof DynamicBody){ 
            //Speed at which the robot walks left and right.
          rSpeed1 = 5;
          rSpeed2 = 10;
          lSpeed1 = -5;
          lSpeed2 = -10;
          if(camera.Detected == true )
            {
                rSpeed1 = rSpeed2; // If character is detected, Robots are alert    
                lSpeed1 = lSpeed2; // and move faster
            }
          if(camera.hasBeenDetected == true)
          {
                rSpeed1 = rSpeed2; // If character is detected, Robots are alert    
                lSpeed1 = lSpeed2; // and move faster
                //camera.hasBeenDetected = true;
          }
            
            if(robot.getPosition().x <= 5 ) // If robot collides with wall and is facing left
                                            // turn robot to face right
            {
            robot.startWalking(rSpeed1);
            robot.removeAllImages();
            robot.addImage(robot.getRobotImageRight());
            }
            if (robot.getPosition().x >= 10) // If robot collides with wall and is facing right
                                            // turn robot to face left
            {
            robot.startWalking(lSpeed1);
            robot.removeAllImages();
            robot.addImage(robot.getRobotimage()); 
            }      
            
        }
    }
}

