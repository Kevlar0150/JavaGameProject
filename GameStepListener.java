/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.StaticBody;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import java.util.Random;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Kevin LA
 */
public class GameStepListener implements StepListener {
    
    Strider strider; 
    Game game;
    private int frame, timerFrame;
    public float bossX,bossY;
    public float maxX = 0.3f;
    public float minX = -0.3f;
    public float maxY = 0.3f;
    public float minY = -0.3f;
    
    /**
     * Constructor that initialises the GameStepListener
     * @param strider The player Character
     * @param game  The game
     */
    public GameStepListener(Strider strider, Game game)
    {
       this.strider = strider;
       this.game = game;
    }

    /**
     * Method that occurs before every frame
     * @param e stepevent
     */
    @Override 
   public void preStep(StepEvent e) {
            Random rand = new Random();
        float bossX = minX + rand.nextFloat() * (maxX - minX);
        float bossY = minY + rand.nextFloat() * (maxY - minY);
        float y = strider.getLinearVelocity().y; 
        float x = strider.getLinearVelocity().x;
        if(strider.moveLeft)
        {
                   strider.setLinearVelocity(new Vec2(-10,y));
        }
        if(strider.moveRight)
        {
                strider.setLinearVelocity(new Vec2(10,y));
        }
        strider.applyForce(new Vec2(0,0));
        for(StaticBody body : strider.getWorld().getStaticBodies())
        {
            if(body instanceof shortLaser)
            {
                 shortLaser laserBeam = (shortLaser)body;
                if(laserBeam.movingRight)
                {
                    laserBeam.setPosition(laserBeam.getPosition().add(new Vec2(0.15f,0)));   
                }
                else
                {  
                  laserBeam.setPosition(laserBeam.getPosition().add(new Vec2(-0.15f,0)));  
                }
                if(laserBeam.getPosition().x <= laserBeam.endPointLeft)
                {
                     laserBeam.movingRight = true;
                }              
                else if(laserBeam.getPosition().x >= laserBeam.endPointRight)
                {
                     laserBeam.movingRight = false;
                }
            }
        }
        for(StaticBody beam : strider.getWorld().getStaticBodies())
        {
            if(beam instanceof LaserTurret)
            {
                 LaserTurret laser = (LaserTurret)beam;
                if(laser.movingRight)
                {
                    laser.setPosition(laser.getPosition().add(new Vec2(0.15f,0)));   
                }
                else
                {  
                  laser.setPosition(laser.getPosition().add(new Vec2(-0.15f,0)));  
                }
                if(laser.getPosition().x <= laser.endPointLeft)
                {
                     laser.movingRight = true;
                }              
                else if(laser.getPosition().x >= laser.endPointRight)
                {
                     laser.movingRight = false;
                }
            }
        }
    }
   /**
    * method that happens after every frame
    * @param e stepevent
    */
    @Override 
    public void postStep(StepEvent e) {
        //Frames
        if(frame == 20) //If statement every 20 frames
        {
            if(strider.stamina <= 100)
            {
               strider.stamina += 2;
            }            
        frame = 0; //Reset frame to 0 
        }
        frame++; //Frame increases by 1
        
        if(game.getLevel() == 3)
        {
         if(timerFrame == 20) //If statement every 20 frames
        {
            if(strider.timer<= 1000)
            {
                strider.timer -= 4;
            }
            if(strider.timer <= 0)
            {
                strider.destroy();
            }
            
        timerFrame = 0; //Reset frame to 0 
        }
       timerFrame++; //Frame increases by 1
        }

    }
  
    
}

