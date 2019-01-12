package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;

/**
 * The computer game.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;
    private int level;
    private Controller controller;
    private ControlPanel cp;
    private Strider ninja;
    private SoundClip stageOST;
    private boolean gamePlaying;
    final JFrame frame = new JFrame("Event handling");

    /** Initialise a new Game. */
    public Game() {
       
        // make the world
         level = 1;
         gamePlaying=true;
        world = new Level1();
        world.populate(this);
        view = new MyView(world,this, 1080, 700);
        // make a view
        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // display the view in a frame
        Container buttons = new ControlPanel(this);
        frame.add(buttons, BorderLayout.WEST);
        
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true); 
       
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
         controller = new Controller(world.getPlayer(),view);
         frame.addKeyListener(controller);
        //Shows whatever is in Controller into the gameWorld 
        //For example the shuriken as the position was set in controller, not Gameworld
        // Like the other Dynamic Bodies.
        frame.setLocation(45,5);
        
        // uncomment to make the view track the player
        world.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 1000, 800);
            try {
                stageOST= new SoundClip("data/stageOST.mp3");   // Open an audio input stream
                stageOST.loop();
                stageOST.setVolume(0.20f);
                
            } 
                    catch (UnsupportedAudioFileException|IOException|LineUnavailableException c) {
                System.out.println(c);
            }  
        
        // start!
        world.start();   
    }
    /**
     * Resumes the game
     */
    public void resume ()
    {
        world.start();
    }
    /**
     * Pauses the game
     */
    public void pause ()
    {
        world.stop();
    }
    /**
     * Spawns everything in the class Level1
     */
    public void goLevel1()
    {
         level = 1;
            // get a new world
            world = new Level1();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
             
           // world.getPlayer().setHealthCount(oldNinja.getHealth());
           // world.getPlayer().setEnergyCount(oldNinja.getEnergyCount());
           // world.getPlayer().setNumOfShuriken(oldNinja.getNumOfShuriken());
            // show the new world in the view
            view.setWorld(world);
            world.start();
    }
    /**
     * Spawns everything in the class Level2
     */
     public void goLevel2()
    {
         level = 2;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
             
           // world.getPlayer().setHealthCount(oldNinja.getHealth());
           // world.getPlayer().setEnergyCount(oldNinja.getEnergyCount());
           // world.getPlayer().setNumOfShuriken(oldNinja.getNumOfShuriken());
            // show the new world in the view
            view.setWorld(world);
            world.start();
    }
     /**
      * Spawns everything in the class Level3
      */
      public void goLevel3()
    {
         level = 3;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
             
           // world.getPlayer().setHealthCount(oldNinja.getHealth());
           // world.getPlayer().setEnergyCount(oldNinja.getEnergyCount());
           // world.getPlayer().setNumOfShuriken(oldNinja.getNumOfShuriken());
            // show the new world in the view
            view.setWorld(world);
            world.start();
    }
      /**
       * Spawns everything in the class Level4
       */
       public void goLevel4()
    {
         level = 4;
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
             
           // world.getPlayer().setHealthCount(oldNinja.getHealth());
           // world.getPlayer().setEnergyCount(oldNinja.getEnergyCount());
           // world.getPlayer().setNumOfShuriken(oldNinja.getNumOfShuriken());
            // show the new world in the view
            view.setWorld(world);
            world.start();
    }
    /** The player in the current level. 
     @return world.getPlayer() The Player character*/
    public Strider getPlayer() {
        return world.getPlayer();
    }  
    /** Is the current level of the game finished? 
     @return world.isCompleted The boolean that tells if level is completed*/
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    /**
     * Restarts the game to Level 1
     */
    public void restartGame()
    {
            level = 1;
            world.stop();
            // get a new world
            world = new Level1();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.start();
    }
    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();
        Strider oldNinja = world.getPlayer();
        if (level >= 4) {
            System.exit(0);
        } else if(level == 1 ) {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
             
            world.getPlayer().setHealthCount(oldNinja.getHealth());
            world.getPlayer().setEnergyCount(oldNinja.getEnergyCount());
            world.getPlayer().setNumOfShuriken(oldNinja.getNumOfShuriken());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        }
        else if(level ==2) {
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            world.getPlayer().setHealthCount(oldNinja.getHealth());
            world.getPlayer().setEnergyCount(oldNinja.getEnergyCount());
            world.getPlayer().setNumOfShuriken(oldNinja.getNumOfShuriken());
            // show the new world in the view
            view.setWorld(world);

            world.start();
        }
        else if(level ==3) {
            level++;
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            world.getPlayer().setHealthCount(oldNinja.getHealth());
            world.getPlayer().setEnergyCount(oldNinja.getEnergyCount());
            world.getPlayer().setNumOfShuriken(oldNinja.getNumOfShuriken());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        }
    }
    /** 
     * method that gets the level number
     * @return level The level number
     */
    public int getLevel() {
        return level;
    }
    /**
     * Method that quits the game
     */
    public void quit()
    {
        world.stop();
        frame.dispose();
    }
    /**
     * method that returns boolean gamePlaying
     * @return gamePlaying The boolean asking whether if game is in play
     */
    public boolean isGamePlaying() {
        return gamePlaying;
    }

    /**
    * Sets the gamePlaying variable to false or true
    * If false then stop the music. 
    * @param gamePlaying is a boolean True or false.
    */
    public void setGamePlaying(boolean gamePlaying) {
        this.gamePlaying = gamePlaying;
        if(gamePlaying == false)
                {
                    stageOST.stop();
                }
    }
    
    /** Runs the game.
     @param args contains command-line arguments as array made up of 
     String objects*/
    public static void main(String[] args) {
        new Game();
     
    }   
}
