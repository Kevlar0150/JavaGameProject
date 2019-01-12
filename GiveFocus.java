/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Kevin LA
 */
public class GiveFocus extends MouseAdapter{
    private Component target;
    
    /**
     * Constructor that initialises GiveFocus
     * @param target the target
     */
    public GiveFocus(Component target)
    {
        this.target = target;
    }
    
    /**
     * method for when mouse enters frame
     * @param e MouseEvent
     */
    @Override
    public void mouseEntered(MouseEvent e)
    {
        target.requestFocus();
    }
}
