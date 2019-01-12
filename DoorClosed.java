/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Kevin LA
 */
/**
 * Class for DoorClosed
 */
public class DoorClosed extends StaticBody implements SensorListener{
    
    private static final BodyImage doorClosedImage= new BodyImage("data/doorClosed.png",3.5f);  
     private static final BodyImage doorOpenImage = new BodyImage("data/doorOpened.png",3.5f);  
  
    private Strider ninja;
    private SoundClip doorOpen;
    private DoorClosed doorClosed;
    private boolean isClosed = true;
    /**
     * Constructor to initialise DoorClosed
     * @param world The world
     * @param ninja The player character
     */
    public DoorClosed(World world, Strider ninja) {
        super(world);
        this.ninja=ninja;
       
         Shape doorClosedShape = new PolygonShape(
            -0.647f,-0.697f, 0.709f,-0.687f, 0.7f,0.75f, -0.713f,0.756f, -0.706f,-0.65f);
         Shape doorClosedSensorShape = new PolygonShape(
         -0.08f,2.73f, -3.36f,0.1f, -2.21f,-2.69f, 2.2f,-2.67f, 3.36f,-0.08f, 0.14f,2.7f
         );
           SolidFixture doorClosedFixture = new SolidFixture(this,doorClosedShape);
           Sensor doorClosedSensor = new Sensor(this, doorClosedSensorShape);
           doorClosedSensor.addSensorListener(this);
        addImage(doorClosedImage);
    }
    /**
     * Method for when player character is within the
     * Door sensor
     * @param e  the sensor
     */
    @Override
    public void beginContact(SensorEvent e) {
        if(e.getContactBody().equals(ninja))
        {
            if(ninja.keyCard >= 1)
            {
               ninja.keyCard--;
               DoorOpened doorOpened = new DoorOpened(this.getWorld());
               doorOpened.setPosition(this.getPosition());
               this.destroy();
               try {
            doorOpen= new SoundClip("data/doorOpen.mp3");   // Open an audio input stream
            doorOpen.play();
        } 
                catch (UnsupportedAudioFileException|IOException|LineUnavailableException c) {
            System.out.println(c);
        }  
            }
        }
    }
    /**
     * Method for when player character leaves
     * the sensor.
     * @param e the sensor
     */
    @Override
    public void endContact(SensorEvent e) {
        if(e.getContactBody().equals(ninja))
        {
            
        } 
    }  
}

