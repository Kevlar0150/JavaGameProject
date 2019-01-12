package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 *
 * @author Kevin LA
 */

/**
 * A class for the projectile the boss will shoot.
 * 
 */
public class BossBullet extends Walker implements StepListener {
    private int frame;
 
    private static final Shape bulletshape = new PolygonShape(-1.03f,0.84f, -0.96f,-0.93f, 0.81f,-0.94f, 0.88f,0.95f, -0.98f,0.91f);
    private static final BodyImage bulletimage = new BodyImage("data/Strider_Shuriken.gif", 3);
    /**
     * Constructor that initialises BossBullet
     * @param world The world
     * @param boss  The Boss enemy
     */
    public BossBullet(World world, Boss boss) {
        super(world, bulletshape);
        addImage(bulletimage);
        SolidFixture bullet = new SolidFixture(this, bulletshape);
        bullet.setRestitution(10);
        this.setGravityScale(3.0f);    
        getWorld().addStepListener(this); 
    }
    @Override
    public void preStep(StepEvent se) {   
    }
    @Override
    public void postStep(StepEvent se) {
        if(frame >= 300){
            this.destroy();
        }
        frame += 1;
    }
}