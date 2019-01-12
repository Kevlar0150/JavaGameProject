package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import java.awt.Color;

/**
 * extended view
 */
public class MyView extends UserView {
    private Game game;
       
    private Image background,HealthFull,Health4,Health3,Health2,Health1,Health0,
            keyCard, shurikenIcon,GameOver;

    /**
     * Constructor for MyView
     * @param world The world
     * @param game The Game
     * @param width Width of view
     * @param height Height of view
     */
    public MyView(World world, Game game, int width, int height) {
        super(world, width, height);
        //this.ninja = ninja;
        this.game = game; //Used to update and retain player information after each level
                          //(Health, Energy and so on
             
        this.background = new ImageIcon("data/Background_Level1.gif").getImage();
        this.HealthFull = new ImageIcon("data/HealthFull.jpg").getImage(); 
        this.Health4 = new ImageIcon("data/Health4.jpg").getImage();  
        this.Health3 = new ImageIcon("data/Health3.jpg").getImage();  
        this.Health2 = new ImageIcon("data/Health2.jpg").getImage();  
        this.Health1 = new ImageIcon("data/Health1.jpg").getImage();  
        this.Health0= new ImageIcon("data/Health0.jpg").getImage();  
        this.keyCard=new ImageIcon("data/KeyCard.png").getImage();
        this.shurikenIcon = new ImageIcon ("data/Shuriken.png").getImage();
        this.GameOver = new ImageIcon("data/GameOver.png").getImage();
    }
    /**
     * Paints the background of the view
     * @param g Allows use of Graphics2D methods
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    /**
     * Paints the foreground of the view
     * @param g allows use of Graphics2D methods
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        
        //Output the Player EnergyCount and NumOfShurikens
        //game.getPlayer gets the player allowing us to
        // output and keep the scores,health and num of shurikens of the player.
        g.setColor(Color.blue);
        g.drawString(" : " + game.getPlayer().getNumOfShuriken(), 100,100);
        g.drawRect(80,70, 102, 6);
        g.setColor(Color.green);
        g.drawRect(80, 72, game.getPlayer().getStamina(),2);
        g.drawImage(shurikenIcon,80,85,20,20, this);
        if(game.getLevel() == 3 )
        {
            g.drawRect(270,10, game.getPlayer().getTimer(), 6);
            g.setColor(Color.green);
            g.drawRect(270, 10, game.getPlayer().getTimer(),2);
        } 
        if(game.getPlayer().getHealth() <= 0)
        {
            g.drawImage(GameOver,300,150,500,400,this);
            
        }
        //(image,xPos,yPos,Width,Height)
          if(game.getPlayer().getHealth() >= 5)
            {g.drawImage(HealthFull, 0, 0, 250, 100, this);}
          if(game.getPlayer().getHealth() == 4)
            {g.drawImage(Health4, 0, 0, 250, 100, this);}
          if(game.getPlayer().getHealth() == 3)
            {g.drawImage(Health3, 0, 0, 250, 100, this);}
          if(game.getPlayer().getHealth() == 2)
            {g.drawImage(Health2, 0, 0, 250, 100, this);}
          if(game.getPlayer().getHealth() == 1)
            {g.drawImage(Health1, 0, 0, 250, 100, this);}
          if(game.getPlayer().getHealth() == 0)
            {g.drawImage(Health0, 0, 0, 250, 100, this);}
          if(game.getPlayer().getKeyCard() == 1)
            {g.drawImage(keyCard,270,50,20,10, this);}
          if(game.getPlayer().getKeyCard() == 2)
            {g.drawImage(keyCard,270,50,20,10, this);}
    }
}

