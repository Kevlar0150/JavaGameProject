/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
/**
 * Class for LaserTurret
 * @author Kevin LA
 */
public class LaserTurret extends StaticBody{
    
    private static final BodyImage laserImage = new BodyImage("data/Laser.png",3f); 
    public float endPointRight, endPointLeft;
    public boolean movingRight = true;
       
        /**
         * The constructor for LaserTurret
         * @param world The world
         * @param endLeft End point left
         * @param endRight End point right
         */
        public LaserTurret(World world, float endLeft,float endRight)
        {
            super(world);
            this.endPointLeft = endLeft;
            this.endPointRight = endRight;
            Shape Laser = new PolygonShape(
            -0.108f,0.703f, -0.741f,0.08f, -0.104f,-0.585f, 0.59f,-0.094f, 0.009f,0.703f);
            SolidFixture LaserFixture = new SolidFixture(this,Laser);
            addImage(laserImage);              
        }
}

