/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Kevin LA
 */

/**
 * Class for DoorOpened
 */
public class DoorOpened extends StaticBody  implements SensorListener{
    
    private static final BodyImage doorClosedImage= new BodyImage("data/doorClosed.png",3.5f);  
     private static final BodyImage doorOpenImage = new BodyImage("data/doorOpened.png",3.5f);  
  
    private Strider ninja;
    private DoorClosed doorClosed;
    private boolean isClosed = true;
    /**
     * Initialise Door Opened
     * @param world The world
     */
    public DoorOpened(World world) {
        super(world);
        this.ninja=ninja;
       
         Shape doorClosedShape = new PolygonShape(
            -0.647f,-0.697f, 0.709f,-0.687f, 0.7f,0.75f, -0.713f,0.756f, -0.706f,-0.65f);
         Shape doorClosedSensorShape = new PolygonShape(
         -0.08f,2.73f, -3.36f,0.1f, -2.21f,-2.69f, 2.2f,-2.67f, 3.36f,-0.08f, 0.14f,2.7f
         );
           Sensor doorClosedSensor = new Sensor(this, doorClosedSensorShape);
           doorClosedSensor.addSensorListener(this);
        addImage(doorOpenImage);
    }
    /**
     * Method for when player character is within the DoorOpened
     * Sensor
     * @param e The door sensor
     */
    @Override
    public void beginContact(SensorEvent e) {
        if(e.getContactBody().equals(ninja))
        {
            if(ninja.keyCard >= 1)
            {
               removeAllImages();
               addImage(doorOpenImage);
               ninja.keyCard--;
            }
        }
    }
    /**
     * Method for when the player character leaves the DoorOpened
     * Sensor
     * @param e the door sensor
     */
    @Override
    public void endContact(SensorEvent e) {
        if(e.getContactBody().equals(ninja))
        {
            
        } 
    }  
}