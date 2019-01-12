/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Class for Help3
 * @author Kevin LA
 */
public class Help3 extends StaticBody  implements SensorListener{
    
    private static final BodyImage helpImage = new BodyImage("data/Help.png",2);  
     private static final BodyImage helpTextImage = new BodyImage("data/Help3.png",8);  
  
    private Strider ninja;

    /**
     * Constructor that initialises instances of Help3
     * @param world the world
     * @param ninja the player character
     */
    public Help3(World world, Strider ninja) {
        super(world);
        this.ninja=ninja;

         Shape help3 = new PolygonShape(
            -0.647f,-0.697f, 0.709f,-0.687f, 0.7f,0.75f, -0.713f,0.756f, -0.706f,-0.65f);
         Shape help3Sensor = new PolygonShape(
                 -2.24f,4.1f, -2.05f,-4.17f, 1.65f,-4.18f, 1.82f,4.24f, -2.05f,4.25f
             );
           GhostlyFixture help3Fixture = new GhostlyFixture(this,help3);
           Sensor helpSensor1 = new Sensor(this, help3Sensor);
           helpSensor1.addSensorListener(this);
           
        addImage(helpImage);
    }

    /**
     * Method for when Player character leaves Help3
     * Sensor
     * @param e the sensor
     */
    @Override
    public void beginContact(SensorEvent e) {
        if(e.getContactBody().equals(ninja))
        {
               //touchQuestion = true;
               addImage(helpTextImage);
        } 
    }
    /**
     * Method for when Player character leaves Help3
     * Sensor
     * @param e the sensor
     */
    @Override
    public void endContact(SensorEvent e) {
        if(e.getContactBody().equals(ninja))
        {
            removeAllImages();
            addImage(helpImage);
        }
    }
  
    
    
    
}

