package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the ninja to collect things.
 */
public class PickupEnergy implements CollisionListener {
    private Strider ninja;
    
    /**
     * Constructor
     * @param ninja The Player Character 
     */
    public PickupEnergy(Strider ninja) {
        this.ninja = ninja;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == ninja) {
            ninja.incrementenergyCount();
            ninja.increaseStaminaCount();
            e.getReportingBody().destroy();
        }
    }
}
