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
 * Class for when EnemyRobotTouchStaticBodyNoTurret
 * Different from the other class as these robots will not be affected by
 * the turret
 */
public class EnemyRobotTouchStaticBodyNoTurret implements CollisionListener{
     private EnemyRobot robot;
     private int rSpeed1;
     private int lSpeed1;
    
     private boolean walkRight = true;
     /**
      * Constructor 
      * @param robot The enemy robot 
      */
    public EnemyRobotTouchStaticBodyNoTurret(EnemyRobot robot)
    {
        this.robot = robot;
       
    }
    //RobotCollision with walls
    @Override
    public void collide(CollisionEvent b) {
        
        if(b.getOtherBody() instanceof StaticBody || b.getOtherBody() instanceof DynamicBody){ 
            //Speed at which the robot walks left and right.
          rSpeed1 = 5;
          lSpeed1 = -5;
          
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

