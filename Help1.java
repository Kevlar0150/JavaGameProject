/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Class for Help1
 * @author Kevin LA
 */
public class Help1 extends StaticBody implements SensorListener{
    
    private static final BodyImage helpImage = new BodyImage("data/Help.png",2);  
     private static final BodyImage helpTextImage = new BodyImage("data/Help1.png",8);  
  
    private Strider ninja;
    private Game game;

    /**
     * Constructor that initialises instances of Help1
     * @param world The world
     * @param ninja The player character
     */
    public Help1(World world, Strider ninja) {
        super(world);
        this.ninja = ninja;
       
         Shape help1 = new PolygonShape(
            -0.647f,-0.697f, 0.709f,-0.687f, 0.7f,0.75f, -0.713f,0.756f, -0.706f,-0.65f);
         Shape help1Sensor = new PolygonShape(
         -0.08f,2.73f, -3.36f,0.1f, -2.21f,-2.69f, 2.2f,-2.67f, 3.36f,-0.08f, 0.14f,2.7f
         );
           GhostlyFixture help1Fixture = new GhostlyFixture(this,help1);
           Sensor helpSensor1 = new Sensor(this, help1Sensor);
           helpSensor1.addSensorListener(this);
           
        addImage(helpImage);
    }

    /**
     * Method for when Player character enters Help1
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
     * Method for when Player character leaves Help1
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
