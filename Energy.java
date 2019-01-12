package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 * 
 * @author Kevin LA
 */

/**
 *Class for Energy, made as a dynamic body
 */
public class Energy extends DynamicBody {
    private static final BodyImage energy = new BodyImage("data/Energy.gif",0.5f);  
    
    Shape blueEnergy = new PolygonShape(
            -0.001f,0.241f, -0.216f,0.102f, -0.183f,-0.149f, -0.097f,-0.221f
            , 0.09f,-0.219f, 0.227f,-0.089f, 0.231f,0.055f, 0.125f,0.204f);
            SolidFixture energyFixture = new SolidFixture (this,blueEnergy);
            
                
    /**
     * Constructor that initialises instances of Energy
     * Adds an image
     * @param world The world
     */
    public Energy(World world) {
        super(world);
        addImage(energy);
    }
}
