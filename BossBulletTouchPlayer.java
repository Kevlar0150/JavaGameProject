package game;

import city.cs.engine.*;

    /**
    * Class for when Players collides with the Boss
    **/
public class BossBulletTouchPlayer implements CollisionListener {

    private BossBullet bossBullet;
    private Strider strider;

    /**
     * Constructor that initialises BossBulletTouchPlayer
     * Takes strider as parameter for the collide method.
     * @param strider The player character
     */
    public BossBulletTouchPlayer (Strider strider) {
        this.strider = strider;
    }
    /**
     * Collision event for Strider and BossBullet
     * @param e the body
     */
    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof BossBullet) {
            if(e.getReportingBody() instanceof Strider){
            strider.decreaseHealthCount(1);
            e.getOtherBody().destroy();
            }
        }
    }
}