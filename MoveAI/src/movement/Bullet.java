/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;

import java.awt.Graphics;

/**
 *
 * @author TAI
 */
public class Bullet extends Character{

    @Override
    public void render(Graphics g) {
        super.render(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(this.color);
        //draw
        g.drawRect((int)position.getX(),(int)position.getZ(), 10, 5);
        System.out.println(this.orientation);
        
    }
    
}
