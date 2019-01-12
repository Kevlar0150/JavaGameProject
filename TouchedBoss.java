/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *
 * @author Kevin LA
 */
public class TouchedBoss implements CollisionListener {
    private Strider ninja;
    /**
     * Constructor that initialise the TouchedBoss
     * @param ninja The player character
     */
    public TouchedBoss(Strider ninja) {
        this.ninja = ninja;
    }
    /**
     * Collide event for when boss touches player
     * @param e The enemy boss Body
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == ninja) {
            ninja.decreaseHealthCount(1);
        }
    }
}