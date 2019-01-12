/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;
/** 
 * Collision listener for when strider touches the ground
 * @author Kevin LA
 */
public class StriderTouchGround implements CollisionListener{
     private Strider strider;
     /**
      * Constructor that initialises StriderTouchGround
      * @param strider The player character
      */
    public StriderTouchGround(Strider strider)
    {
        this.strider = strider;
    }
    @Override
    public void collide(CollisionEvent b) {
        if(b.getOtherBody() instanceof StaticBody){ 
           // When Player touches ground
            //System.out.println("jump Reset"); 
            strider.jumpAmount = 2;

           //Destroy the character when health is 0 
           //e.getReportingBody().destroy();
        }
    }
}

