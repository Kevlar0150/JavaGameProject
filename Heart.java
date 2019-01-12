package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 * Class for Heart 
 * @author Kevin LA
 */
public class Heart extends DynamicBody {
    private static final BodyImage heart = new BodyImage("data/Heart.png",1f);  
    
    Shape heartShape = new PolygonShape(
            -0.467f,0.401f, -0.461f,-0.405f, 0.486f,-0.402f, 0.483f,0.431f, -0.465f,0.436f);
            SolidFixture heartFixture = new SolidFixture (this,heartShape);
            
    /**
     * Constructor that initialises instances of Heart
     * @param world The world
     */
    public Heart(World world) {
        super(world);
        addImage(heart);
    }
}
