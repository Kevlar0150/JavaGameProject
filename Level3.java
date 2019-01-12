package game;

import city.cs.engine.*;
import java.util.Random;
import org.jbox2d.common.Vec2;

/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

    private static final int NUM_ENERGY = 15;
    private static int NUM_ROBOT;
    private static int max = 3;
    private static int min = 1;
    private EnemyRobot robot1,robot2,robot3;
    private ShurikenPack shurikenPack;
    private SecurityCamera camera;
    private Heart heart;
    private LaserTurret laser,laser2,laser3,laser4,laser5;
    private shortLaser shortLaserBeam,shortLaserBeam2;
    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        //Randomise number of robots that spawn
        Random rand = new Random();
        NUM_ROBOT = rand.nextInt((max - min)+1) + min;
        System.out.println(NUM_ROBOT);
        this.setGravity(20);
        
        // make the ground
        Shape groundShape = new BoxShape(30, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -17.5f));
        
        //Make ceiling
        Shape ceilingShape = new BoxShape(30, 10f);
        Body ceiling = new StaticBody(this, ceilingShape);
        ceiling.setPosition(new Vec2(0, 27.5f));
        
        // walls
        Shape leftWallShape = new BoxShape(0.5f, 30, new Vec2(-27, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 30, new Vec2(27f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
        
        // make platforms
         Shape boxShape = new BoxShape(23, 0.5f);
        Body platform1 = new StaticBody(this, boxShape); // Top left platform
        platform1.setPosition(new Vec2(-5, 4.5f));
        Shape boxShape2 = new BoxShape(15,0.5f);
        Body platform2 = new StaticBody(this, boxShape2); 
        platform2.setPosition(new Vec2(15, -3.5f));
         Body platform3 = new StaticBody(this, boxShape2); 
        platform3.setPosition(new Vec2(-15, -10.5f));
         Shape boxShape3 = new BoxShape(3.5f, 0.5f);
         Body platform4 = new StaticBody(this, boxShape3);
         platform4.setPosition(new Vec2(-15, -6));
         Shape boxShape4 = new BoxShape(2f, 0.5f);
         Body smallPlatform1 = new StaticBody(this,boxShape3);
         smallPlatform1.setPosition(new Vec2(23,0));
                
                 
        Shape stopper = new BoxShape(0.5f,0.01f);
        Body enemyStopper = new StaticBody(this, stopper); // Top left platform
        enemyStopper.setPosition(new Vec2(0.5f,-3));
        Body enemyStopper2 = new StaticBody(this, stopper); // Top left platform
        enemyStopper2.setPosition(new Vec2(14,-3));
           //Make SecurityCamera
        camera = new SecurityCamera(this,getPlayer());
        camera.setPosition(new Vec2(-15,3.5f));
        //CeilingLaser Mid
        laser3 = new LaserTurret(this,-23,0);
        laser3.setPosition(new Vec2(-10,4f));
        laser3.rotateDegrees(0);
       
        //CeilingLaser next to portal
        laser3 = new LaserTurret(this,0,20);
        laser3.setPosition(new Vec2(7f,-4f));
        laser3.rotateDegrees(0);
        
        //Ceiling top
        laser3 = new LaserTurret(this,-23,25);
        laser3.setPosition(new Vec2(7,17f));
        laser3.rotateDegrees(0);
        
        //Ceiling Mid
        shortLaserBeam = new shortLaser(this,getPlayer(),-23,0);
        shortLaserBeam.setPosition(new Vec2(-10,-3.5f));
        shortLaserBeam.rotateDegrees(90);
       
        //Ceiling portal
        shortLaserBeam = new shortLaser(this,getPlayer(),0,20);
        shortLaserBeam.setPosition(new Vec2(7,-10.5f));
        shortLaserBeam.rotateDegrees(90);
        
        //Ceiling top
        shortLaserBeam = new shortLaser(this,getPlayer(),-23,25);
        shortLaserBeam.setPosition(new Vec2(7,11));
        shortLaserBeam.rotateDegrees(90);
        
        //Make an Enemy depending on the random number that is generated
         if(NUM_ROBOT == 1)
        {
        robot1 = new EnemyRobot(this);
        robot1.setPosition(new Vec2(11, -15)); // Set position of robot
        //Collision
        robot1.addCollisionListener(new EnemyRobotTouchStaticBody(robot1,camera));//when robot touches Wall
          robot1.addCollisionListener(new TouchedRobot(getPlayer())); // When robot touches ninja
        }
        if(NUM_ROBOT == 2)
        {
        robot1 = new EnemyRobot(this);
        robot1.setPosition(new Vec2(11, -15)); // Set position of robot
        robot2 = new EnemyRobot(this);
        robot2.setPosition(new Vec2(11, 0)); // Set position of robot
        //Collision
        robot1.addCollisionListener(new EnemyRobotTouchStaticBody(robot1,camera));//when robot touches Wall
        robot2.addCollisionListener(new EnemyRobotTouchStaticBody(robot2,camera));//when robot touches Wall
          robot1.addCollisionListener(new TouchedRobot(getPlayer())); // When robot touches ninja
            robot2.addCollisionListener(new TouchedRobot(getPlayer())); // When robot touches ninja
        }
        if(NUM_ROBOT == 3)
        {
        robot1 = new EnemyRobot(this);
        robot1.setPosition(new Vec2(11, -15)); // Set position of robot
        robot2 = new EnemyRobot(this);
        robot2.setPosition(new Vec2(11, 0)); // Set position of robot
        robot3 = new EnemyRobot(this);
        robot3.setPosition(new Vec2(11, 10)); // Set position of robot
        
        //Collision
        robot1.addCollisionListener(new EnemyRobotTouchStaticBody(robot1,camera));//when robot touches Wall
        robot2.addCollisionListener(new EnemyRobotTouchStaticBody(robot2,camera));//when robot touches Wall
        robot3.addCollisionListener(new EnemyRobotTouchStaticBody(robot3,camera));//when robot touches Wall
        
          robot1.addCollisionListener(new TouchedRobot(getPlayer())); // When robot touches ninja
            robot2.addCollisionListener(new TouchedRobot(getPlayer())); // When robot touches ninja
              robot3.addCollisionListener(new TouchedRobot(getPlayer())); // When robot touches ninja
        }
        shurikenPack = new ShurikenPack(this);
        shurikenPack.setPosition(new Vec2(-15,-3));
        heart = new Heart(this);
        heart.setPosition(new Vec2(0,0));
       // shield = new Shield(this);
        //shield.setPosition(new Vec2(-10,0));
        
        
        //Collisions
        getPlayer().addCollisionListener(new StriderTouchGround(getPlayer())); // when Ninja touches static body
        shurikenPack.addCollisionListener(new PickupShuriken(getPlayer()));//Pick up shuriken
        heart.addCollisionListener(new PickUpHeart(getPlayer()));//Pick up heart
//        shield.addCollisionListener(new PickUpShield(getPlayer()));
        
        for (int i = 0; i < NUM_ENERGY; i++) {
            Body orange = new Energy(this);
            orange.setPosition(new Vec2(i * 2 - 10, 10));
            orange.addCollisionListener(new PickupEnergy(getPlayer()));
        }
    }
     /**
     * Initialises the start position of the character for level 1
     * @return new Vec2 The position
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(-15, -15);
    }
    /**
     * Initialises the start position of door for level 1
     * @return new Vec2 The position
     */
    @Override
    public Vec2 doorPosition() {
        return new Vec2(-25, 6.6f);
    }
    /**
     * MEthod that returns whether the level is completed or not
     * @return true or false
     */
    @Override
    public boolean isCompleted() {
        return getPlayer().getEnergyCount() >= 200;
    }   
}
