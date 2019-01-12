package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the Shuriken to collide with things.
 */
public class ShurikenHitStuff implements CollisionListener {

    private Shuriken shuriken;

    /** initialises Lemon collisions. 
     @param shuriken instance of Shuriken*/
    public ShurikenHitStuff(Shuriken shuriken) {
        this.shuriken = shuriken;
    }
    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof Energy) {
            e.getReportingBody().destroy();
        } 
        if(e.getOtherBody() instanceof StaticBody) {
            
            e.getReportingBody().destroy();
            
        }
      }
    }