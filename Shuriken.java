/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
/**
 * Class for Shuriken
 * @author Kevin LA
 */
public class Shuriken extends DynamicBody{
    
    private static final BodyImage shurikenImage = new BodyImage("data/Strider_Shuriken.gif"); 
    private Shuriken shuriken;
    private EnemyRobot robot;
    private int frame;
    
       /**
        * Constructor that initialises instances of Shuriken
        * @param world The world
        */
        public Shuriken(World world)
        {
            super(world);
            Shape Shuriken = new PolygonShape(
            -0.108f,0.703f, -0.741f,0.08f, -0.104f,-0.585f, 0.59f,-0.094f, 0.009f,0.703f);
            SolidFixture ShurikenFixture = new SolidFixture(this,Shuriken);

            addImage(shurikenImage);
            this.addCollisionListener(new ShurikenHitStuff(shuriken));
            this.addCollisionListener(new ShurikenHitRobot(robot)); //An object of this class is the 
                                                                    //e.getOtherBody
                                                                   
        }
}
