package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    private EnemyRobot robot;
    private Shuriken shuriken;
    private ShurikenPack shurikenPack;
    private Help1 help1;
    private Help2 help2;
    private Help3 help3;
    private Help4 help4;
    private static final int NUM_ENERGY = 50 ;
    private SecurityCamera turret;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        this.setGravity(20); //Sets the gravity of the world
        
        // make the ground
        Shape groundShape = new BoxShape(30, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -17.5f));
        //Make ceiling
        Shape ceilingShape = new BoxShape(30, 10f);
        Body ceiling = new StaticBody(this, ceilingShape);
        ceiling.setPosition(new Vec2(0, 30.5f));
        // walls
        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-27, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(27f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
         Shape midWallShape = new BoxShape(5,15, new Vec2(-5, 5.5f));
        SolidFixture midWall = new SolidFixture(ground, midWallShape);
        //High Wall

        // make platforms
        Shape Platform1 = new BoxShape(6, 6.5f);
        Body platform1 = new StaticBody(this, Platform1); // Top left platform
        platform1.setPosition(new Vec2(-23, -4.5f));
        Shape Platform2 = new BoxShape(4,0.5f);
        Body platform2 = new StaticBody(this, Platform2); // Mid-Right platform
        platform2.setPosition(new Vec2(10, -6.5f));
       
        //Make an Enemy
        robot = new EnemyRobot(this);
        robot.setPosition(new Vec2(11, -15)); // Set position of robot
        
        //Set Question for Tutorial
        help1 = new Help1(this,getPlayer());
        help1.setPosition(new Vec2(-18,-15));
        help2 = new Help2(this,getPlayer());
        help2.setPosition(new Vec2(-4,8));
        help3 = new Help3(this,getPlayer());
        help3.setPosition(new Vec2(10,-1.8f));
        help4 = new Help4(this,getPlayer());
        help4.setPosition(new Vec2(4,-13));
        //Spawn Shuriken
        shurikenPack = new ShurikenPack(this);
        shurikenPack.setPosition(new Vec2(-5,3.8f));
        
        //Collisions
        robot.addCollisionListener(new EnemyRobotTouchStaticBodyNoTurret(robot));//when robot touches Wall
        robot.addCollisionListener(new TouchedRobot(getPlayer())); // When robot touches ninja
        shurikenPack.addCollisionListener(new PickupShuriken(getPlayer()));//When spawned in shuriken touches ninja
       
        //Add energy drops
        for (int i = 0; i < 6; i++) { // Top left platform
            Body Energy = new Energy(this);
            Energy.setPosition(new Vec2(-22.5f+i, 5));
            Energy.addCollisionListener(new PickupEnergy(getPlayer()));
        }
                for (int j = 0; j < 6; j++) { // mid-right platform
            Body Energy = new Energy(this);
            Energy.setPosition(new Vec2(7.5f+j, -4f));
            Energy.addCollisionListener(new PickupEnergy(getPlayer()));
        }
    }
    /**
     * Initialises the start position of the character for level 1
     * @return new Vec2 The position
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(-25,-17);
    }
    /**
     * Initialises the start position of door for level 1
     * @return new Vec2 The position
     */
    @Override
    public Vec2 doorPosition() {
        return new Vec2(25f, -15f);
    }
    /**
     * MEthod that returns whether the level is completed or not
     * @return true or false
     */
    @Override
    public boolean isCompleted() {
        //If player energy count is more than NUM_ENERGY(50) AND the number of robots
        //killed is equal to 1 then level is complete.
        if( getPlayer().getEnergyCount() >= 50 && robot.numDefeatedRobots == 1) 
        {
            return true;
        }
        else //Else return false meaning level is not complete.
        {
            return false;
        }
    }
}
