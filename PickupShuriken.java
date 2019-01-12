package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the ninja to collect things.
 */
public class PickupShuriken implements CollisionListener {
    private Strider ninja;
    
    /**
     * The constructor
     * @param ninja The player character
     */
    public PickupShuriken(Strider ninja) {
        this.ninja = ninja;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == ninja) {//If Shuriken touches ninja
            ninja.numOfShuriken += 5; // Increase the amount of shurikens that the player has
            e.getReportingBody().destroy();//Destroy that instance of Shuriken.
        }
    }
}
