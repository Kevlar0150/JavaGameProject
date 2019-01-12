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
public class SecurityCamera extends StaticBody  implements SensorListener{
    
    private static final BodyImage helpImage = new BodyImage("data/Turret.png",2);  
    private Strider ninja;
    private Game game;
    

    boolean Detected = false;
    boolean hasBeenDetected = false;
 
    /**
     * Constructor for SecurityCamera
     * @param world the world
     * @param ninja the character
     */
    public SecurityCamera(World world, Strider ninja) {
        super(world);
        this.ninja = ninja;
       
         Shape cameraShape = new PolygonShape(-1.82f,0.02f, -1.82f,-1.34f, 1.48f,
                 -1.35f, 1.48f,0.06f, -1.77f,0.08f);
                 
         Shape cameraSensor = new PolygonShape(-0.81f,-1.42f, -3.01f,-8.76f, 1.86f,-8.7f, -0.58f,-1.93f);
           GhostlyFixture turretFixture = new GhostlyFixture(this,cameraShape);
           Sensor laserSensor = new Sensor(this, cameraSensor);
           laserSensor.addSensorListener(this);
           
        addImage(helpImage);
    }
    /**
     * Method that executes when player character within
     * SecurityCamera sensor
     * @param e  the sensor
     */
    @Override
    public void beginContact(SensorEvent e) {
        if(e.getContactBody().equals(ninja))
        {
               System.out.println("Detected");
               Detected = true;
               hasBeenDetected = true;
        } 
    }

    /**
     * Method that executes when player character leaves
     * SecurityCamera sensor
     * @param e the sensor
     */
    @Override
    public void endContact(SensorEvent e) {
        if(e.getContactBody().equals(ninja))
        {
            System.out.println("Target retreating");
            Detected = false;
        }
    }
    /**
     *  Method that returns value of Detected
     * @return isDetected 
     */
    public boolean isDetected() {
        return Detected;
    }
  
}