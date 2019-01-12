package game;

import city.cs.engine.*;
import java.util.Random;
import org.jbox2d.common.Vec2;
/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private static final int NUM_ENERGY = 10;
    private static int NUM_ROBOT;
    private static int max = 4; // For generating random number of robots
    private static int min = 2;
    private EnemyRobot robot1,robot2,robot3,robot4;
    private ShurikenPack shurikenPack,shurikenPack1,shurikenPack2;
    private DoorClosed doorClosed,doorClosed2;
    private Heart heart;
    private SecurityCamera camera;
    private KeyCard key,key1;
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
        this.setGravity(20);//Set the gravity
        
        // make the ground
        Shape groundShape = new BoxShape(30, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -17.5f));
        
        //Make ceiling
        Shape ceilingShape = new BoxShape(30, 10f);
        Body ceiling = new StaticBody(this, ceilingShape);
        ceiling.setPosition(new Vec2(0, 27.5f));
        
        //Spawn door thats closed
        doorClosed = new DoorClosed(this,getPlayer());
        doorClosed.setPosition(new Vec2(-18.2f,-4.5f));
        doorClosed2 = new DoorClosed(this,getPlayer());
        doorClosed2.setPosition(new Vec2(18.2f,-4.5f));
        
        // walls
        Shape leftWallShape = new BoxShape(0.5f, 30, new Vec2(-27, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 30, new Vec2(27f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
        Shape WallShape1 = new BoxShape(0.5f, 4, new Vec2(18f, 18.5f));
        Fixture Wall1 = new SolidFixture(ground, WallShape1);
         Shape WallShape2 = new BoxShape(0.5f, 4, new Vec2(-18f, 18.5f));
        Fixture Wall2 = new SolidFixture(ground, WallShape2);
        
        // make platforms
         Shape boxShape = new BoxShape(23, 0.5f);
        Body platform1 = new StaticBody(this, boxShape); // Top left platform
        platform1.setPosition(new Vec2(-5, 4.5f));
        Shape boxShape2 = new BoxShape(15,0.5f);
        Body platform2 = new StaticBody(this, boxShape2); 
        platform2.setPosition(new Vec2(15, -6.5f));
         Body platform3 = new StaticBody(this, boxShape2); 
        platform3.setPosition(new Vec2(-25, -6.5f));
        Shape boxShape4 = new BoxShape(4,0.5f);
        Body platform4 = new StaticBody(this, boxShape4);
        platform4.setPosition(new Vec2(-4.8f,-12));
        Shape stopper = new BoxShape(0.5f,0.f);
        Body enemyStopper = new StaticBody(this, stopper); // Top left platform
        enemyStopper.setPosition(new Vec2(0.5f,-6));
        Body enemyStopper2 = new StaticBody(this, stopper); // Top left platform
        enemyStopper2.setPosition(new Vec2(14,-6));
        
        //Make Turret
        camera = new SecurityCamera(this,getPlayer());
        camera.setPosition(new Vec2(-15,2.9f));
        
        //Make an Enemy depending on the random number that is generated
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
        if(NUM_ROBOT == 4)
        {
        robot1 = new EnemyRobot(this);
        robot1.setPosition(new Vec2(11, -15)); // Set position of robot
        robot2 = new EnemyRobot(this);
        robot2.setPosition(new Vec2(11, 0)); // Set position of robot
        robot3 = new EnemyRobot(this);
        robot3.setPosition(new Vec2(11, 10)); // Set position of robot
        robot4 = new EnemyRobot(this);
        robot4.setPosition(new Vec2(-10, -15)); // Set position of robot
        //Collision
        robot1.addCollisionListener(new EnemyRobotTouchStaticBody(robot1,camera));//when robot touches Wall
        robot2.addCollisionListener(new EnemyRobotTouchStaticBody(robot2,camera));//when robot touches Wall
        robot3.addCollisionListener(new EnemyRobotTouchStaticBody(robot3,camera));//when robot touches Wall
        robot4.addCollisionListener(new EnemyRobotTouchStaticBody(robot4,camera));//when robot touches Wall
          robot1.addCollisionListener(new TouchedRobot(getPlayer())); // When robot touches ninja
            robot2.addCollisionListener(new TouchedRobot(getPlayer())); // When robot touches ninja
              robot3.addCollisionListener(new TouchedRobot(getPlayer())); // When robot touches ninja
                 robot4.addCollisionListener(new TouchedRobot(getPlayer())); // When robot touches ninja
        } 
        //Make Key
        key = new KeyCard(this);
        key.setPosition(new Vec2(-5,0));
        key1 = new KeyCard(this);
        key1.setPosition(new Vec2(-20,0));
        key.addCollisionListener(new PickUpKey(getPlayer()));
        key1.addCollisionListener(new PickUpKey(getPlayer()));
        //Heart
        heart = new Heart(this);
        heart.setPosition(new Vec2(-23,0));
        heart.addCollisionListener(new PickUpHeart(getPlayer()));
        shurikenPack = new ShurikenPack(this);
        shurikenPack.setPosition(new Vec2(-5,3.8f));
        shurikenPack1 = new ShurikenPack(this);
        shurikenPack1.setPosition(new Vec2(-20,0));
        shurikenPack2= new ShurikenPack(this);
        shurikenPack2.setPosition(new Vec2(-20,0));
        //Collisions
        getPlayer().addCollisionListener(new StriderTouchGround(getPlayer())); // when Ninja touches static body
        shurikenPack.addCollisionListener(new PickupShuriken(getPlayer()));//Pick up shuriken
        shurikenPack1.addCollisionListener(new PickupShuriken(getPlayer()));//Pick up shuriken
        shurikenPack2.addCollisionListener(new PickupShuriken(getPlayer()));//Pick up shuriken
          
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
        return new Vec2(8, -10);
    }
    /**
     * Initialises the start position of door for level 1
     * @return new Vec2 The position
     */
    @Override
    public Vec2 doorPosition() {
        return new Vec2(25, -14.6f);
    }
    /**
     * MEthod that returns whether the level is completed or not
     * @return true or false
     */
    @Override
    public boolean isCompleted() {
        if(getPlayer().getEnergyCount() >= 100)
        {
            return true;
        }
        else
        {
        return false;
        }
    }
    
}
