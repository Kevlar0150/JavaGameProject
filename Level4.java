package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Kevin LA
 */
public class Level4 extends GameLevel {
    
    private Boss boss;
    private Shuriken shuriken;   
    private Strider strider;
    @Override
    public void populate(Game game){
        super.populate(game);
        this.setGravity(20);
        
       // make the ground
        Shape groundShape = new BoxShape(30, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -15));
        Body ceiling = new StaticBody(this, groundShape);
        ceiling.setPosition(new Vec2(0,15));
       
        // make the boss
        boss = new Boss(this,-20,20);
        boss.setPosition(new Vec2(0,0));
        boss.addCollisionListener(new TouchedBoss(this.getPlayer()));//Player touches boss and gets damaged
        
        // make a platform
        Shape platformShape = new BoxShape(5, 0.5f);
        Shape platformShape2 = new BoxShape(6, 0.5f);
        Shape wallShape = new BoxShape(0.5f, 30f);
        Body wall = new StaticBody(this, wallShape);
        wall.setPosition(new Vec2(-23.0f, -12.0f));
        Body wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(23.0f, -12.0f));          
    }    
  
     /**
     * Initialises the start position of the character for level 1
     * @return new Vec2 The position
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(-15f, -13f);
    }
    /**
     * Initialises the start position of door for level 1
     * @return new Vec2 The position
     */
    @Override
    public Vec2 doorPosition() {
        return new Vec2(023, -12);
    }
    /**
     * Method that returns whether the level is completed or not
     * @return true or false
     */
    @Override
    public boolean isCompleted() {
       if(boss.getDefeated()== 1)
       {
           return true;
       }
       else
       {
           return false;
       }
    }
}

