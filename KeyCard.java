package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;
/**
 * Class for KeyCard
 * @author Kevin LA
 */
public class KeyCard extends DynamicBody {
    private static final BodyImage keyCardImage = new BodyImage("data/KeyCard.png",0.5f);  
          
    /**
     * Constructor that initialises instances of KeyCard
     * @param world  The world
     */
    public KeyCard(World world) {
        super(world);
          Shape keyCardShape = new PolygonShape(-0.384f,0.214f, -0.385f,-0.228f,
            0.382f,-0.226f, 0.382f,0.231f, -0.369f,0.229f);
            SolidFixture keyCardFixture = new SolidFixture (this,keyCardShape);
        addImage(keyCardImage);
    }
}
