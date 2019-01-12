package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the ninja to collect things.
 */
public class PickUpKey implements CollisionListener {
    private Strider ninja;
    
    /**
     * Constructor
     * @param ninja The Player character 
     */
    public PickUpKey(Strider ninja) {
        this.ninja = ninja;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == ninja) {//IF key touches ninja
            ninja.increasekeyCard(); //Increase player keyCard Quantity *See Strider class for function
            e.getReportingBody().destroy();//Destroy the keyCard
        }
    }
}
