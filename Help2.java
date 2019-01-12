/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * Class for Help2
 * @author Kevin LA
 */
public class Help2 extends StaticBody implements SensorListener{
    
    private static final BodyImage helpImage = new BodyImage("data/Help.png",2);  
     private static final BodyImage helpTextImage = new BodyImage("data/Help2.png",8);  
  
    private Strider ninja;
  
    /**
     * Constructor that initialises instances of Help2
     * @param world the world
     * @param ninja the player character
     */
    public Help2(World world, Strider ninja) {
        super(world);
        this.ninja=ninja;

         Shape help2 = new PolygonShape(
            -0.647f,-0.697f, 0.709f,-0.687f, 0.7f,0.75f, -0.713f,0.756f, -0.706f,-0.65f);
         Shape help2Sensor = new PolygonShape(
                 -2.6f,4.95f, -2.82f,-5.12f, 2.97f,-5.14f, 3.08f,5.25f, -2.5f,5.25f);
                 GhostlyFixture help1Fixture = new GhostlyFixture(this,help2);
           Sensor helpSensor1 = new Sensor(this, help2Sensor);
           helpSensor1.addSensorListener(this);
           
        addImage(helpImage);
    }

    /**
     * Method for when Player character enters Help2
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
     * Method for when Player character leaves Help2
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

