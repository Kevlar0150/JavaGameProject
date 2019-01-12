/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
* Class for the Boss that extends StaticBodyt
* and Implements StepListener to spawn bullets
* every so often.
**/
public class Boss extends StaticBody implements StepListener{

    private static final Shape shape = new PolygonShape(
        -4.42f,3.19f, -4.41f,-2.99f, 4.82f,-3.0f, 4.7f,3.48f, -4.29f,3.49f);
    
    private static final BodyImage image =
        new BodyImage("data/Boss.png", 7.0f);
 
    private int bossHealth;
    private int framecount = 0;  // Timer to shoot the bullets
    public int defeated;
    public float endPointRight, endPointLeft;
    public boolean movingRight = true;
    public boolean facingRight = false;
   
    /**
     * Constructor that initialises variables and fixtures
     * @param world The world
     * @param endLeft End point left
     * @param endRight  End point right
     */
    public Boss(World world,float endLeft,float endRight) {
        super(world, shape);
       
         this.endPointRight = endRight;
         this.endPointLeft = endLeft;
        SolidFixture chickWeight = new SolidFixture(this, shape, 6);
        this.addCollisionListener(new BossGetHit(this));
        getWorld().addStepListener(this);
        bossHealth = 8;
        addImage(image);
    }
    /** Get Health of the boss
    * @return an int variable called bossHealth 
    **/
    public int getHealthPoints() {
        return bossHealth;
    }
    /**
    * Method that is called to destroy the boss
    * This is called when the boss gets hit 
    * no return value or parameters.
    **/
    public void bossIsDead(){
        if(bossHealth <=0){
        this.destroy();
        defeated = 1;
        }
    }
    /**
    * a method which is used to return whether an enemy is defeated
    * or not. Used to go to next level
    * @return int variable called defeated.
    **/
     public int getDefeated() {
        return defeated;
    }
     /**
    * a method which is used to reduce health of boss
    **/
    public void reduceHealthPoints() {
        bossHealth -= 1;
    }
   /**
    * Method that allows the boss to shoot bullets
    * Spawns projectiles at position of Boss.
    **/
   public void ShootBullets(){    
        BossBullet bullet = new BossBullet(this.getWorld(), this);
        bullet.setPosition(new Vec2((this.getPosition().x + 0.5f * -1) ,this.getPosition().y));
    }
    @Override // Before frame
    public void preStep(StepEvent se) {
    }
    @Override//After frames
    public void postStep(StepEvent se) {

    for(StaticBody body1 : this.getWorld().getStaticBodies())
        {
        if(body1 instanceof Boss)
            {
                  Boss boss = (Boss)body1;
                if(boss.movingRight)
                {
                    boss.setPosition(boss.getPosition().add(new Vec2(0.15f,0)));   
                }
                else
                {  
                  boss.setPosition(boss.getPosition().add(new Vec2(-0.15f,0)));  
                }
                if(boss.getPosition().x <= boss.endPointLeft)
                {
                     boss.movingRight = true;
                }              
                else if(boss.getPosition().x >= boss.endPointRight)
                {
                     boss.movingRight = false;
                }
            }
        }
    if(framecount >= 90){
       ShootBullets();
        framecount = 0;    
    }
    if(framecount < 0){
        framecount = 0;
    }
    framecount += 1;
    }
}