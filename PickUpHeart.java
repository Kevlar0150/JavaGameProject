package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the ninja to collect things.
 */
public class PickUpHeart implements CollisionListener {
    private Strider ninja;
    
    /**
     * Constructor for PickUpHEart
     * @param ninja The Player Character
     */
    public PickUpHeart(Strider ninja) {
        this.ninja = ninja;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == ninja) {//If Heart touches ninja
            ninja.incrementHealthCount();
            e.getReportingBody().destroy();//Destroy that instance of Heart
        }
    }
}
