/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *Collision Listener when player touches robot
 * @author Kevin LA
 */
public class TouchedRobot implements CollisionListener {
    private Strider ninja;
    /**
     * Constructor that initialises TouchedRobot
     * @param ninja The player character
     */
    public TouchedRobot(Strider ninja) {
        this.ninja = ninja;
    }
    /**
     * Collide event
     * @param e The enemyrobot body
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == ninja) {
            ninja.decreaseenergyCount(); // Decrease energy when ninja touch robot
            ninja.decreaseHealthCount(1);
        }
    }
}