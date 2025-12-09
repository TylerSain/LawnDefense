import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the controlling class for the Bullet objects that interact with the animals
 * 
 * @author Tyler Sain
 * @version 0.1
 */
public class Bullet extends mainCharacter
{
    /**
     * Constructor for the Bullet class
     * 
     * @author Tyler Sain
     * 
     */
    public Bullet(){
        setImage("./images/beeper.png");
    }
    public void act()
    {
        // Add your action code here.
        move(5);
        
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        
    }
}
