package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private Strider player;
    
    /**
     * Method that returns an instance of Strider when called
     * @return player The Player character
     */
    public Strider getPlayer() {
        return player;
    }
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     * @param game The game
     */
    public void populate(Game game) {
        player = new Strider(this,game);
        player.setPosition(startPosition());
        addStepListener(new GameStepListener(player,game)); // Listerner for every frame for smooth movement
        player.addCollisionListener(new StriderTouchGround(player)); // when Ninja touches static body

        Portal door = new Portal(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new PortalListener(game));
    }
    
    /** The initial position of the player. 
     @return null*/
    public abstract Vec2 startPosition();
    
    
    /** The position of the exit door. 
     @return null*/
    public abstract Vec2 doorPosition();
    
    /** Is this level complete?
     @return null*/
    public abstract boolean isCompleted();
}
