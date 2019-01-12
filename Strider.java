package game;

import city.cs.engine.*;

/**
 * Main Character
 */
public class Strider extends Walker{
    int jumpAmount, numOfShuriken, energyCount, healthCount, keyCard,shieldCount,damage
        ,stamina,frameCount,timer,timerCount;
    public boolean moveRight;
    public boolean moveLeft;
    public boolean climbUp;
    public boolean faceRight;
    public boolean isPlayerDead = false;
    private Game game;
            private static final BodyImage IdleRight =
        new BodyImage("data/Strider_Idle.gif", 2f);
             private static final BodyImage IdleLeft =
        new BodyImage("data/Strider_Idle_Left.gif", 2f);
              private static final BodyImage WalkRight =
        new BodyImage("data/Strider_Walk.gif", 2.5f);
               private static final BodyImage WalkLeft =
        new BodyImage("data/Strider_Walk_Left.gif", 2.5f);
                private static final BodyImage ThrowRight=
        new BodyImage("data/Strider_Throw.gif", 2.5f);
                 private static final BodyImage ThrowLeft=
        new BodyImage("data/Strider_Throw_Left.gif", 2.5f);
                private static final BodyImage JumpRight =
        new BodyImage("data/StriderJumpRight.gif", 3.6f);
                 private static final BodyImage JumpLeft=
        new BodyImage("data/StriderJumpLeft.gif", 3.6f);
                            
    //Getters for the different Gifs and animations
    public static BodyImage getIdleRight() {return IdleRight;}
    public static BodyImage getIdleLeft() {return IdleLeft;}
    public static BodyImage getWalkRight() {return WalkRight;}
    public static BodyImage getWalkLeft() {return WalkLeft;}
    public static BodyImage getThrowRight() {return ThrowRight;}
    public static BodyImage getThrowLeft() {return ThrowLeft;}

    public static BodyImage getJumpRight() {return JumpRight;}
    public static BodyImage getJumpLeft() {return JumpLeft;}
    public int getJumpAmount() {return jumpAmount;}
    
    /**
     * Constructor that initialises Strider
     * @param world The world
     * @param game The game
     */
    public Strider(World world, Game game) {
        super(world);
        
        this.game = game;
        Shape Body = new PolygonShape(//Fixture for the Body
                -0.69f,-0.79f, -0.686f,0.543f, 0.69f,0.552f, 0.71f,-0.795f, -0.69f,-0.838f);
                SolidFixture BodyFixture = new SolidFixture (this,Body);
                BodyFixture.setDensity(0);
        Shape Feet = new PolygonShape( //Fixture for the feet
                -0.786f,-0.805f, -0.795f,-0.986f, 0.829f,-0.995f, 0.795f,-0.771f, -0.781f,-0.752f);
                SolidFixture feetFixture = new SolidFixture (this,Feet);
                feetFixture.setFriction(50);
                this.addCollisionListener(new BossBulletTouchPlayer(this));
     
        addImage(IdleRight); // Spawned facing right
        energyCount = 0; // EnergyCount to open portal set to 0
        keyCard = 0;  //Set amount of keyCards the player has
        healthCount = 5; // Set health of player to 4
        numOfShuriken = 20;//Instantiate numOfShurikens to 5
        stamina = 100;
        timer = 500;
    }
    /**
     * gets Energy count
     * @return energyCount
     */
    public int getEnergyCount() {return energyCount;}
    
    /**
     * Increases energyCount
     */
    public void incrementenergyCount() {
        energyCount = energyCount + 10;
        System.out.println("Energy Increase " + energyCount);
    }
    /**
     * Decreases energyCount
     */
     public void decreaseenergyCount() {
         if(energyCount >=5)
         {
        energyCount = energyCount - 5;
        System.out.println("Damaged, 1 life lost. Energy: " + energyCount);
         }
    }
     /**
      * Gets stamina of player
      * @return stamina
      */
    public int getStamina() {return stamina;}
    
    /**
     * decrease Stamina of player
     */
    public void decreaseStaminaCount()
    {stamina -= 20;}//Throwing shuriken uses stamina
    /**
     * Gets the timer
     * @return timer
     */
    public int getTimer() {return timer;}
    
    /**
     * gets the heath
     * @return healthCount
     */
    public int getHealth() {return healthCount;
    } 
    /**
     * Increases health count of player
     */
    public void incrementHealthCount() {   
        if(healthCount >= 5){healthCount +=0;}
        else{healthCount ++;}
    }
    /**
     * Decreases health count of player
     * @param damage variable representing damage
     */
     public void decreaseHealthCount(int damage) {
        this.damage = damage;
        healthCount -= damage;
        if(healthCount <= 0)
        {
            destroy();
            isPlayerDead = true;
            game.pause();

        }
     }
     /**
      * increase Player stamina count
      */
    public void increaseStaminaCount()
    {
        if(stamina <=96){stamina +=5;}
        else{stamina +=0;}
    }
    /**
     * get the number of shuriken
     * @return numOfShuriken
     */
    public int getNumOfShuriken() {return numOfShuriken;}
    
    /**
     * increase number of keyCard
     */
    public void increasekeyCard()
    {
        keyCard++;
        System.out.println("Received Key Card");
    }
    
    /**
     * sets the health value
     * @param healthCount the players health
     */
    public void setHealthCount(int healthCount)
    {
        this.healthCount = healthCount;
    }
    /**
     * sets the number of shuriken
     * @param numOfShuriken number of shurikens of the player
     */
    public void setNumOfShuriken(int numOfShuriken)
    {
        this.numOfShuriken = numOfShuriken;
    }
    /**
     * sets energyCount of the player
     * @param energyCount The energycount of the player
     */
    public void setEnergyCount(int energyCount)
    {
        this.energyCount = energyCount;
    }
    /**
     * Get keyCard
     * @return keyCard The number of KeyCard the player has
     */
    public int getKeyCard(){return keyCard;}
}

