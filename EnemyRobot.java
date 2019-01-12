package game;

import city.cs.engine.*;

/**
 * Class for the enemy robot
 **/
public class EnemyRobot extends Walker {
       private int robotHealth;
       public int numDefeatedRobots;
       private EnemyRobot robot;
        
    private static final BodyImage robotImage =
        new BodyImage("data/EnemyRobot.gif", 3.5f);
    private static final BodyImage robotImageRight=
        new BodyImage("data/EnemyRobotRight.gif", 3.5f);

    /**
     * Initialise EnemyRobot
     * @param world The world
     */
    public EnemyRobot(World world) {
        super(world);
          Shape robotBodyShape = new PolygonShape(
           -0.5f,1.08f, -0.49f,-0.69f, 0.5f,-0.68f, 0.51f,1.15f, -0.49f,1.13f);
           SolidFixture enemyRobotBodyFixture = new SolidFixture(this,robotBodyShape);
           Shape robotFeetShape = new PolygonShape(
           -0.46f,-0.83f, -0.46f,-1.13f, 0.36f,-1.14f, 0.37f,-0.8f, -0.42f,-0.8f);
           SolidFixture enemyRobotFeetFixture = new SolidFixture(this,robotFeetShape);
           enemyRobotBodyFixture.setRestitution(1);
           enemyRobotFeetFixture.setDensity(100);
           this.addCollisionListener(new ShurikenHitRobot(this));
           addImage(robotImage);
           robotHealth = 3;
           numDefeatedRobots = 0;
  
    }

    /**
     * method that gets the value of robots health
     * @return robotHealth
     */
    public int getRobotHealth() {
        return robotHealth;
    }
    /**
     * method that gets an image of the robot
     * @return robotimage
     */
    public static BodyImage getRobotimage() {
        return robotImage; // Returns an image
    }
    /**
     * Method that gets an image of the robot but facing right
     * @return robotImageRight
     */
    public static BodyImage getRobotImageRight() {
        return robotImageRight;//Returns an image
    }
    /**
     * Method that decreases robots health
     */
    public void decreaseRobotHealth() {
        robotHealth--; //Decreases robot health when called
        System.out.println("Robot taken 1 damage");
    }
    /**
     * Method that destroys robot is robotHealth is less
     * or equal to 0.
     */
     public void robotDie(){
        if(robotHealth <=0){//If the robots health is less than or equal to 0
        this.destroy();  //Destroy the body
         numDefeatedRobots++;//Increase the number of defeated enemies in order
                            // to complete levels.
        }
    }
    

}

