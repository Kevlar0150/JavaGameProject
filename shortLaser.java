/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
/**
 * Class ShortLaser that is a static body and has a sensor attached
 * @author Kevin LA
 */
public class shortLaser extends StaticBody implements SensorListener{
    
    private static final BodyImage laserImage = new BodyImage("data/Laser.gif",10f); 
    private Strider ninja;
    public float endPointRight, endPointLeft;
    public boolean movingRight = true;
    
       /**
        * Constructor that initialises short laser
        * @param world The world
        * @param ninja The Player character
        * @param endLeft end point left side
        * @param endRight end point right side
        */
        public shortLaser(World world,Strider ninja,float endLeft,float endRight)
        {
            super(world);
            this.ninja = ninja;
            this.endPointRight = endRight;
            this.endPointLeft = endLeft;
            Shape Laser = new PolygonShape(
         -6.56f,0.26f, 6.67f,0.28f, 6.67f,0.07f, -6.7f,0.02f);
                Sensor LaserSensor= new Sensor(this,Laser);
           LaserSensor.addSensorListener(this);
            addImage(laserImage);                                                         
        }
@Override
    public void beginContact(SensorEvent e) {
        if(e.getContactBody().equals(ninja))
        {
            if(ninja.shieldCount >=1)
            {
                ninja.shieldCount-= 50;
            }
            if(ninja.shieldCount == 0)
            {
              ninja.decreaseHealthCount(ninja.healthCount);
            }
        } 
    }
    @Override
    public void endContact(SensorEvent e) 
    {
        
    }
}

